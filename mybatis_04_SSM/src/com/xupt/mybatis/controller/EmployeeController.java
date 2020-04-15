package com.xupt.mybatis.controller;

import com.xupt.mybatis.pojo.Employee;
import com.xupt.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-04-13 22:01
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/empsList")
    public String getEmpsList(Map<String,Object>map){
        Employee emp = employeeService.getEmpById(1);
//        List<Employee> empsList = employeeService.getEmpsList();
        map.put("emps",emp);
        return "list";
    }
}
