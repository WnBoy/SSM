package com.xupt.mybatis.dao;

import com.xupt.mybatis.pojo.Department;

/**
 * @author Wnlife
 * @create 2020-04-12 18:27
 */
public interface DepartmentMapper {
    public Department getDepById(Integer id);

    public Department getDepByIdPlus(Integer id);

    public Department getDepByIdStep(Integer id);
}
