package com.xupt.mybatis.dao;

import com.xupt.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-04-11 14:20
 */
public interface EmployeeMapper {


    //多条记录封装一个map：Map<Integer,Employee>:键是这条记录的主键，值是记录封装后的javaBean
    //@MapKey:告诉mybatis封装这个map的时候使用哪个属性作为map的key
    @MapKey("id")
    public Map<Integer,Employee> getEmpsByNameLikeReturnMap(String namePatter);

    //返回一条记录的map；key就是列名，值就是对应的值
    public Map<String,Object> getEmpByIdReturnMap(Integer id);

    //模糊查询返回一个集合
    public List<Employee> getEmpsByName(String namePatter);

    public Employee getEmpByMap(Map<String,Object>map);

    public Employee getEmpByIdAndName(@Param("id") Integer id, @Param("lastName") String lastName);

    public Employee getEmpById(Integer id);

    public Boolean addEmp(Employee employee);

    public Long updateEmp(Employee employee);

    public Integer deleteEmp(Integer id);
}
