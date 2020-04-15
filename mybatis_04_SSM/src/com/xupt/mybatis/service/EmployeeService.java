package com.xupt.mybatis.service;

import com.xupt.mybatis.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wnlife
 * @create 2020-04-13 21:57
 */
@Service
public interface EmployeeService {
    public Employee getEmpById(Integer id);
    public List<Employee> getEmpsList();
}
