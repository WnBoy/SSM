package com.xupt.mybatis.dao;

import com.xupt.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @author Wnlife
 * @create 2020-04-11 18:36
 */
public interface EmployeeMapperAnnotation {
    @Select("select * from tbl_employee where id= #{id}")
    public Employee getEmpById(Integer id);
}
