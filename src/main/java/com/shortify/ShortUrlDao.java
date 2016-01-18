package com.shortify;

import com.mongodb.*;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ShortUrlDao {

    private final static Logger logger = LoggerFactory.getLogger(ShortUrlDao.class);

    @Autowired
    private MongoDbFactory connectionFactory;

    public ShortUrlEntry findByShortenUrl(String shortenUrl) {
        DB db = connectionFactory.getDb();
        DBCollection collection = db.getCollection("data");
        DBObject query = QueryBuilder.start("shortenUrl").is(shortenUrl).get();

        DBObject update = new BasicDBObject("$inc", new BasicDBObject("count", 1));
        DBObject result = collection.findAndModify(query, update);

        if (Objects.isNull(result)) {
            return null;
        }

        ShortUrlEntry entry = new ShortUrlEntry();
        entry.setShortenedUrl(shortenUrl);
        entry.setOriginalUrl((String) result.get("originalUrl"));
        return entry;
    }

    public void save(ShortUrlEntry entry) {
        try {
            DB mongo = connectionFactory.getDb();
            DBCollection collection = mongo.getCollection("data");

            BasicDBObject object = new BasicDBObject()
                    .append("originalUrl", entry.getOriginalUrl())
                    .append("shortenUrl", entry.getShortenedUrl())
                    .append("created", DateTime.now().toDate())
                    .append("count", 0);

            collection.insert(object);
            logger.trace("Document {} inserted", object);
        } catch (Exception e) {
            logger.error("Unable to store shortenUrl [{}] in database", entry.getShortenedUrl(), e);
            throw new RuntimeException(e);
        }
    }

}
