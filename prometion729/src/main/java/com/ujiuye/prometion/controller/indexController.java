package com.ujiuye.prometion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

     @RequestMapping("/{page:.+}")
    public String  page(@PathVariable("page") String page){
         return page;
     }
}
