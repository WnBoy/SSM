package com.xupt.mybatis.service.serviceimpl;

import com.xupt.mybatis.dao.EmployeeMapper;
import com.xupt.mybatis.pojo.Employee;
import com.xupt.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wnlife
 * @create 2020-04-13 21:58
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public Employee getEmpById(Integer id) {
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    @Override
    public List<Employee> getEmpsList() {
        List<Employee> empsList = employeeMapper.getEmpsList();
        return empsList;
    }
}
