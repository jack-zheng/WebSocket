package com.jiabin.greeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MsgController {
    /**
     * index页
     *
     * @return page
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
