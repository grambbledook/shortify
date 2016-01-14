package com.shortify.service;

import com.shortify.controller.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortifyUrlService {

    @Autowired
    private HashCodeGenerator generator;

    @Autowired
    private Shortifier shortifier;

    public void shortify(Message message) {
        String originalUrl = message.getOriginalUrl();

        long hashCode = generator.generateHashCode(originalUrl);
        String shortenedUrl = shortifier.generateShortenUrl(hashCode);

        message.setShortenedUrl(shortenedUrl);
    }
}
