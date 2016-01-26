package com.shortify.dao;

import com.mongodb.*;
import com.shortify.ShortUrlEntry;
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

    public ShortUrlEntry findById(String id) {
        DB db = connectionFactory.getDb();
        DBCollection collection = db.getCollection("links");
        DBObject query = QueryBuilder.start("_id").is(id).get();

        DBObject update = new BasicDBObject("$inc", new BasicDBObject("count", 1));
        DBObject result = collection.findAndModify(query, update);

        if (Objects.isNull(result)) {
            return null;
        }

        ShortUrlEntry entry = new ShortUrlEntry();
        entry.setId(id);
        entry.setOriginalUrl((String) result.get("originalUrl"));
        return entry;
}

    public void save(ShortUrlEntry entry) {
        try {
            DB mongo = connectionFactory.getDb();
            DBCollection collection = mongo.getCollection("links");

            BasicDBObject object = new BasicDBObject()
                    .append("originalUrl", entry.getOriginalUrl())
                    .append("_id", entry.getId())
                    .append("created", DateTime.now().toDate())
                    .append("count", 0);

            collection.insert(object);
            logger.trace("Document {} inserted", object);
        } catch (DuplicateKeyException e) {
            logger.warn("Id [{}] for url entry [{}]  already exists in database", entry.getShortUrl(), entry.getOriginalUrl());
        } catch (Exception e) {
            logger.error("Unable to store shortUrl [{}] in database", entry.getShortUrl(), e);
            throw new RuntimeException(e);
        }
    }

}
