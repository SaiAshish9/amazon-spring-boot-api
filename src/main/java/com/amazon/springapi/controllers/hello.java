package com.amazon.springapi.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

// username -> user password -> obtain from terminal

@RestController
public class hello {

    @GetMapping
    public ModelAndView home(ModelMap modelMap){
        return new ModelAndView("redirect:swagger-ui.html",modelMap);
    }


    @GetMapping("/api/public/hi")
    public Map<String, String> getMsg() {
        HashMap msg = new HashMap();
        msg.put("msg", "hi, sai this side");
        return msg;
    }

}
