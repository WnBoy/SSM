package com.xupt.springmvc.handlers;

import com.xupt.springmvc.pojo.Address;
import com.xupt.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-04-06 18:56
 */
@SessionAttributes(value = "user")
@Controller
public class SpringMVCTest {

    public static final String SUCCESS = "success";

    @RequestMapping(value = "/testRedirect")
    public String testRedirect(){
        System.out.println("重定向");
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/testForward")
    public String testForward(){
        System.out.println("请求转发");
        return "forward:/WEB-INF/views/success.jsp";
    }

    @RequestMapping(value = "/testModelAttribute", method = RequestMethod.POST)
    public String testModelAttribute(@ModelAttribute(value = "user") User user) {
        System.out.println("修改"+user);
        return SUCCESS;
    }

    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id,
                        Map<String, Object> map) {
        if (id != null) {
            //模拟从数据库中获取对象
            User user = new User(1, "Tom", "123456", "tom@atguigu.com", 12);
            System.out.println("从数据库中获取一个对象: " + user);
            map.put("user", user);
        }
    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map) {
        User user = new User("acs", "das", "das", 18,
                new Address("xian", "shannxi"));
        map.put("user", user);
        return SUCCESS;
    }

    @RequestMapping("/testModelMap")
    public String testMap(ModelMap modelMap) {
        modelMap.addAttribute("names", Arrays.asList("xiaomi", "huawei", "vivo"));
        return SUCCESS;
    }

    @RequestMapping("/testModel")
    public String testMap(Model model) {
        model.addAttribute("names", Arrays.asList("xiaomi", "huawei", "vivo"));
        return SUCCESS;
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("names", Arrays.asList("xiaomi", "huawei", "vivo"));
        return SUCCESS;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView(SUCCESS);
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }

    @RequestMapping(value = "/testPOJO", method = RequestMethod.POST)
    public String testPOJO(User user) {
        System.out.println(user);
        return SUCCESS;
    }

    @RequestMapping("/testCookieValue")
    public String testCookievalue(@CookieValue(value = "JSESSIONID", required = false) String sessionId) {
        System.out.println(sessionId);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRequestParam", method = RequestMethod.GET)
    public String testRequestParam(@RequestParam(value = "name", required = false, defaultValue = "1") String name, @RequestParam Integer age) {
        System.out.println("name=" + name + " : age=" + age);
        return SUCCESS;
    }


    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
    public String testRESTFULGet(@PathVariable Integer id) {
        System.out.println("get请求" + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
    public String testRESTFULDelete(@PathVariable Integer id) {
        System.out.println("delete请求" + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest", method = RequestMethod.POST)
    public String testRESTFULPost() {
        System.out.println("post请求");
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
    public String testRESTFULPut(@PathVariable Integer id) {
        System.out.println("Put请求" + id);
        return SUCCESS;
    }


    @RequestMapping(value = "/testPathVariable/{num}")
    public String testPathVariable(@PathVariable(value = "num") Integer num) {
        System.out.println(num);
        return SUCCESS;
    }

}
