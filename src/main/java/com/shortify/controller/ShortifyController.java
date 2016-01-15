package com.shortify.controller;

import com.shortify.Message;
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
        model.addAttribute("message", new Message());
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String shortifyUrl(@ModelAttribute("message") Message message, Model model) {
        model.addAttribute("message", message);
        if (urlValidator.isValid(message.getOriginalUrl())) {
            shortifyUrlService.shortify(message);
            return "result";
        } else {
            return "invalid";
        }


    }

}
