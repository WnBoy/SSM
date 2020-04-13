package com.xupt.mybatis.test;

import com.xupt.mybatis.dao.DepartmentMapper;
import com.xupt.mybatis.dao.EmployeeMapperPlus;
import com.xupt.mybatis.pojo.Department;
import com.xupt.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Wnlife
 * @create 2020-04-12 16:03
 */
public class MybatisTest2 {

    /**
     * 获取SqlSessionFactory
     *
     * @return
     * @throws IOException
     */
    private SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void  test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
//            Employee employee = mapper.getEmpById(1);
//            Employee employee = mapper.getEmpAndDepById(1);
            Employee employee = mapper.getEmpByIdStep(2);
            System.out.println(employee);
            System.out.println(employee.getDepartment());
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void test2() throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
//            Department department = mapper.getDepByIdPlus(1);
            Department department = mapper.getDepByIdStep(1);
            System.out.println(department);
            System.out.println(department.getEmps());
        } finally {
            sqlSession.close();
        }

    }

}
