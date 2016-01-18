package com.shortify.controller;

import com.shortify.ShortUrlEntry;
import com.shortify.service.ShortifyUrlService;
import org.apache.commons.validator.routines.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ShortifyController {

    private static final Logger logger = LoggerFactory.getLogger(ShortifyController.class);

    @Autowired
    private ShortifyUrlService shortifyUrlService;
    @Autowired
    private UrlValidator urlValidator;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcomePage(Model model) {
        model.addAttribute("entry", new ShortUrlEntry());
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String shortifyUrl(@ModelAttribute("entry") ShortUrlEntry entry, Model model) {
        logger.trace("Shortify url [{}] request received.", entry.getOriginalUrl());
        model.addAttribute("entry", entry);

        try {
            if (urlValidator.isValid(entry.getOriginalUrl())) {
                shortifyUrlService.shortify(entry);

                logger.trace("Shorten urls for [{}] is [{}]", entry.getOriginalUrl(), entry.getShortenedUrl());
                return "result";
            } else {
                logger.trace("Url [{}] is invalid type of url.", entry.getOriginalUrl());
                return "invalid";
            }
        }catch (Exception e) {
            logger.error("An error occurred", e);
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

}
