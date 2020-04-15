package com.xupt.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Wnlife
 * @create 2020-04-12 16:24
 */
public class Department implements Serializable {
    private static final long serialVersionUID =1L;
    private Integer id;
    private String deptName;
    private List<Employee>emps;

    public Department() {
    }

    public Department(Integer id) {
        this.id = id;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
