package com.xupt.springmvc.test;

import com.xupt.springmvc.crud.dao.EmployeeDao;
import com.xupt.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Locale;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;

/**
 * @author Wnlife
 * @create 2020-04-09 9:38
 */
@Controller
public class SpringMVCTest {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private ResourceBundleMessageSource messageSource;

    /**
     * 处理异常的方法2
     *  处理运行时异常
     */
    @ExceptionHandler({RuntimeException.class})
    public ModelAndView exceptionHandler2(Exception e) {
        System.out.println("出异常了，方法2捕获" + e);
        ModelAndView modelAndView = new ModelAndView("errors");
        modelAndView.addObject("exception", e);
        return modelAndView;
    }

    /**
     * 处理异常的方法1
     * 处理数学异常
     *
     * 1. 在 @ExceptionHandler 方法的入参中可以加入 Exception 类型的参数, 该参数即对应发生的异常对象
     * 2. @ExceptionHandler 方法的入参中不能传入 Map. 若希望把异常信息传导页面上, 需要使用 ModelAndView 作为返回值
     * 3. @ExceptionHandler 方法标记的异常有优先级的问题.
     * 4. @ControllerAdvice: 如果在当前 Handler 中找不到 @ExceptionHandler 方法来出来当前方法出现的异常,
     * 则将去 @ControllerAdvice 标记的类中查找 @ExceptionHandler 标记的方法来处理异常.
     */
    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView exceptionHandler1(Exception e) {
        System.out.println("出异常了，方法1捕获" + e);
        ModelAndView modelAndView = new ModelAndView("errors");
        modelAndView.addObject("exception", e);
        return modelAndView;
    }

    /**
     * 测试异常处理的方法
     */
    @RequestMapping("/testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver(Integer id) {
        System.out.println(10 / id);
        return "success";
    }

    /**
     * 测试文件上传
     */
    @RequestMapping("/testFileUpload")
    public String testFileUpload(@RequestParam("file") MultipartFile file,
                                 @RequestParam("desc") String desc) throws IOException {
        if (!file.isEmpty()) {
            System.out.println(desc);
            String originalFilename = file.getOriginalFilename();
            file.transferTo(new File("I:\\" + originalFilename));
        }
        return "success";
    }

    /**
     * 国际化测试
     */
    @RequestMapping("/i18n1")
    public String i18nTest(Locale locale) {
        String username = messageSource.getMessage("username", null, locale);
        System.out.println(username);
        return "i18n1";
    }

    /**
     * 测试ResponseEntity
     */
    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {

        byte[] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream in = servletContext.getResourceAsStream("/files/abc.txt");
        body = new byte[in.available()];
        in.read(body);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=abc.txt");

        HttpStatus statusCode = HttpStatus.OK;

        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }

    /**
     * 测试HttpMessageConverter
     */
    @ResponseBody
    @RequestMapping("/testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body) {
        System.out.println(body);
        return "helloworld! " + new Date();
    }

    /**
     * 发送Json字符串到浏览器
     */
    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson() {
        return employeeDao.getAll();
    }

}
