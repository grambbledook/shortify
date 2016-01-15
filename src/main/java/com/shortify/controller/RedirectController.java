package com.shortify.controller;


import com.shortify.ShortifyUrlEntry;
import com.shortify.service.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;

@Controller
public class RedirectController {

    @Autowired
    private RedirectService redirectService;

    @RequestMapping(value = "/{id:[a-zA-Z0-9]{1,11}}", method = RequestMethod.GET)
    public String lookup(@PathVariable String id, ModelMap model) {
        ShortifyUrlEntry entry = redirectService.findOriginalUrl(id);

        if (Objects.isNull(entry)) {
            return "404";
        }

        model.put("entry", entry);
        return "redirect";
    }

}
