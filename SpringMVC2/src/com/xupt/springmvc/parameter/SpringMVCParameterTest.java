package com.xupt.springmvc.parameter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-04-10 14:52
 */
@Controller
public class SpringMVCParameterTest {

    @RequestMapping("/testParameter")
    public String testParameter(String sex,String[]tec,String country,Pojo pojo){

        System.out.println(sex);
        System.out.println(tec);
        System.out.println(country);

        System.out.println(pojo);
        return "success";
    }

    @RequestMapping("/items")
    public String list(Map<String,Object>map){
        List<Item>list=new ArrayList<>();
        list.add(new Item(1,"aaa",10));
        list.add(new Item(2,"bbb",20));
        list.add(new Item(3,"ccc",30));

        map.put("items",list);
        return "items";
    }

    @RequestMapping("/testList")
    public String testList(Pojo pojo){

        List<Item> items = pojo.getItems();
        System.out.println(items);
        return "success";
    }

}
