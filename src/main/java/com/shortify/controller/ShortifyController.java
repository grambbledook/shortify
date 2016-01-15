package com.shortify.controller;

import com.shortify.ShortifyUrlEntry;
import com.shortify.service.ShortifyUrlService;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ShortifyController {

    @Autowired
    private ShortifyUrlService shortifyUrlService;
    @Autowired
    private UrlValidator urlValidator;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcomePage(Model model) {
        model.addAttribute("entry", new ShortifyUrlEntry());
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String shortifyUrl(@ModelAttribute("entry") ShortifyUrlEntry shortifyUrlEntry, Model model) {
        model.addAttribute("entry", shortifyUrlEntry);
        if (urlValidator.isValid(shortifyUrlEntry.getOriginalUrl())) {
            shortifyUrlService.shortify(shortifyUrlEntry);
            return "result";
        } else {
            return "invalid";
        }
    }

}
