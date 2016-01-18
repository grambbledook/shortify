package com.shortify.controller;


import com.shortify.ShortUrlEntry;
import com.shortify.service.RedirectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;

@Controller
public class RedirectController {

    private static final Logger logger = LoggerFactory.getLogger(RedirectController.class);

    @Autowired
    private RedirectService redirectService;

    @RequestMapping(value = "/{id:[a-zA-Z0-9]{1,11}}", method = RequestMethod.GET)
    public String lookup(@PathVariable String id) {
        logger.trace("Redirect request received for id [{}]", id);

        try {
            ShortUrlEntry entry = redirectService.findOriginalUrl(id);

            if (Objects.isNull(entry)) {
                return "404";
            }

            logger.trace("Original link for id [{}] found: [{}]. Redirecting...", entry.getOriginalUrl());
            return "redirect:" + entry.getOriginalUrl();
        } catch (Exception e) {
            logger.error("An error occurred", e);
            return "error";
        }
    }

}
