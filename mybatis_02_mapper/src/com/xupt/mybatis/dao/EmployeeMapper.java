package com.xupt.mybatis.dao;

import com.xupt.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-04-11 14:20
 */
public interface EmployeeMapper {

    public Employee getEmpByMap(Map<String,Object>map);

    public Employee getEmpByIdAndName(@Param("id") Integer id, @Param("lastName") String lastName);

    public Employee getEmpById(Integer id);

    public Boolean addEmp(Employee employee);

    public Long updateEmp(Employee employee);

    public Integer deleteEmp(Integer id);
}
