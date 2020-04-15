package com.xupt.mybatis.dao;

import com.xupt.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Wnlife
 * @create 2020-04-12 22:10
 */
public interface EmployeeMapperDynamicSQL {
    //携带了哪个字段查询条件就带上这个字段的值
    public List<Employee> getEmpsByConditionIf(Employee employee);
    public List<Employee> getEmpsByConditionTrim(Employee employee);
    public List<Employee> getEmpsByConditionChoose(Employee employee);

    public void updateEmp(Employee employee);

    //查询员工id'在给定集合中的
    public List<Employee> getEmpsByConditionForeach(@Param("ids") List<Integer> ids);

    //批量保存
    public void insertEmployeesByForeach(@Param("emps") List<Employee> emps);


    public List<Employee> getEmpsByInnerParameter(Employee employee);
}
