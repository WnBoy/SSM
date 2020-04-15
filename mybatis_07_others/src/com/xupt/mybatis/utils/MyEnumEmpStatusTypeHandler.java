package com.xupt.mybatis.utils;

import com.xupt.mybatis.pojo.EmpStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Wnlife
 * @create 2020-04-15 12:23
 */
public class MyEnumEmpStatusTypeHandler implements TypeHandler<EmpStatus> {
    @Override
    public void setParameter(PreparedStatement ps, int i, EmpStatus parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("要保存的状态码："+parameter.getCode());
        ps.setString(i,parameter.getCode());
    }

    @Override
    public EmpStatus getResult(ResultSet rs, String columnName) throws SQLException {
        String code = rs.getString(columnName);
        //需要根据从数据库中拿到的枚举的状态码返回一个枚举对象
        EmpStatus empStatus = EmpStatus.getEmpStatusByCode(code);
        System.out.println("从数据库中获取的状态码："+code);
        return empStatus;
    }

    @Override
    public EmpStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
        String code = rs.getString(columnIndex);
        //需要根据从数据库中拿到的枚举的状态码返回一个枚举对象
        EmpStatus empStatus = EmpStatus.getEmpStatusByCode(code);
        System.out.println("从数据库中获取的状态码："+code);
        return empStatus;
    }

    @Override
    public EmpStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String code = cs.getString(columnIndex);
        //需要根据从数据库中拿到的枚举的状态码返回一个枚举对象
        EmpStatus empStatus = EmpStatus.getEmpStatusByCode(code);
        System.out.println("从数据库中获取的状态码："+code);
        return empStatus;
    }
}
