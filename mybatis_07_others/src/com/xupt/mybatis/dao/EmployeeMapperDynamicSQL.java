package com.xupt.mybatis.dao;

import com.xupt.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Wnlife
 * @create 2020-04-12 22:10
 */
public interface EmployeeMapperDynamicSQL {

    public List<Employee> getEmps();

    public Long addEmp(Employee employee);

    public Employee getEmpById(Integer id);

}
