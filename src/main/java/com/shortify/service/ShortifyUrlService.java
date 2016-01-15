package com.shortify.service;

import com.shortify.HashCodeGenerator;
import com.shortify.ShortUrlGenerator;
import com.shortify.ShortifyUrlDao;
import com.shortify.ShortifyUrlEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortifyUrlService {

    @Autowired
    private HashCodeGenerator generator;

    @Autowired
    private ShortUrlGenerator shortUrlGenerator;

    @Autowired
    private ShortifyUrlDao shortifyUrlDao;

    public void shortify(ShortifyUrlEntry entry) {
        String originalUrl = entry.getOriginalUrl();

        long hashCode = generator.generateHashCode(originalUrl);
        String shortenedUrl = shortUrlGenerator.generateShortenUrl(hashCode);

        entry.setShortenedUrl(shortenedUrl);

        shortifyUrlDao.save(entry);
    }
}
