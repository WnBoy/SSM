package com.xupt.mybatis.dao;

import com.xupt.mybatis.pojo.Employee;

import java.util.List;

/**
 * @author Wnlife
 * @create 2020-04-12 16:00
 */
public interface EmployeeMapperPlus {

    public Employee getEmpById(Integer id);

    public Employee getEmpAndDepById(Integer id);

    public Employee getEmpByIdStep(Integer id);

    public List<Employee> getEmpsByDeptId(Integer deptId);
}
