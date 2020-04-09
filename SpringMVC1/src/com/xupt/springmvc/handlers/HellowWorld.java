package com.xupt.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Wnlife
 * @create 2020-04-06 18:12
 */
@Controller
public class HellowWorld {

    @RequestMapping("/helloworld")
    public String hellow() {
        System.out.println("Hello world");
        return "success";
    }

}
