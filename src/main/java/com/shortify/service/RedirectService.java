package com.shortify.service;

import com.shortify.ShortUrlGenerator;
import com.shortify.dao.ShortUrlDao;
import com.shortify.ShortUrlEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedirectService {

    @Autowired
    private ShortUrlGenerator shortUrlGenerator;

    @Autowired
    private ShortUrlDao shortUrlDao;

    public ShortUrlEntry findOriginalUrl(String id) {
        String shortenUrl = shortUrlGenerator.fromId(id);
        return shortUrlDao.findByShortenUrl(shortenUrl);
    }

}
