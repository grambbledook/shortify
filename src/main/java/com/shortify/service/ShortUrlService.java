package com.shortify.service;

import com.shortify.HashCodeGenerator;
import com.shortify.ShortUrlGenerator;
import com.shortify.dao.ShortUrlDao;
import com.shortify.ShortUrlEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlService {

    @Autowired
    private HashCodeGenerator generator;

    @Autowired
    private ShortUrlGenerator shortUrlGenerator;

    @Autowired
    private ShortUrlDao shortUrlDao;

    public void shortify(ShortUrlEntry entry) {
        String originalUrl = entry.getOriginalUrl();

        long hashCode = generator.generateHashCode(originalUrl);

        String id = shortUrlGenerator.generateId(hashCode);
        entry.setId(id);

        String shortUrl = shortUrlGenerator.fromId(id);
        entry.setShortUrl(shortUrl);

        shortUrlDao.save(entry);
    }
}
