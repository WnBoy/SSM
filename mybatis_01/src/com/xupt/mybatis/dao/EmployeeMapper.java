package com.xupt.mybatis.dao;

import com.xupt.mybatis.pojo.Employee;

/**
 * @author Wnlife
 * @create 2020-04-11 14:20
 */
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);
}
