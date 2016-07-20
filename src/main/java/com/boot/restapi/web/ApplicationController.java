package com.boot.restapi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Oleg on 20 Jul 2016.
 */

@Controller
public class ApplicationController {

    @RequestMapping(value = "/", method = RequestMethod.GET)

    public String homepage() {
        return "index";
    }
}
