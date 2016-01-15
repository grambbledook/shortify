package com.shortify.service;

import com.shortify.ShortUrlGenerator;
import com.shortify.ShortifyUrlDao;
import com.shortify.ShortifyUrlEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedirectService {

    @Autowired
    private ShortUrlGenerator shortUrlGenerator;

    @Autowired
    private ShortifyUrlDao shortifyUrlDao;

    public ShortifyUrlEntry findOriginalUrl(String id) {
        String shortenUrl = shortUrlGenerator.fromId(id);
        return shortifyUrlDao.findByShortenUrl(shortenUrl);
    }

}
