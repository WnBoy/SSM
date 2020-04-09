package com.xupt.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Wnlife
 * @create 2020-04-09 21:51
 */
@ControllerAdvice
public class SpringMVCTestExceptionHandler {

    /**
     * 处理异常的方法1
     */
    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView exceptionHandler1(Exception e) {
        System.out.println("出异常了，方法1捕获" + e);
        ModelAndView modelAndView = new ModelAndView("errors");
        modelAndView.addObject("exception", e);
        return modelAndView;
    }
}
