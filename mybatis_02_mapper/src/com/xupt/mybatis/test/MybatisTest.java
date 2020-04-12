package com.xupt.mybatis.test;

import com.xupt.mybatis.dao.EmployeeMapper;
import com.xupt.mybatis.dao.EmployeeMapperAnnotation;
import com.xupt.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-04-11 10:06
 */
public class MybatisTest {

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

    /**
     * 传统方式
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //sql唯一映射：
        //执行sql的参数：
        try {
            Employee employee = sqlSession.selectOne("com.xupt.mybatis.dao.EmployeeMapper.getEmpById", "1");
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }

    }

    /**
     * mapper动态代理方法
     */
    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取接口的代理类
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
//            Employee emp = employeeMapper.getEmpById(1);
//            Employee emp = employeeMapper.getEmpByIdAndName(1, "tom");
            Map<String,Object>map=new HashMap<>();
            map.put("id",1);
            map.put("lastName","tom");
            Employee emp = employeeMapper.getEmpByMap(map);

            System.out.println(emp);
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 测试注解映射的方式
     */
    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperAnnotation mapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);
            Employee empById = mapper.getEmpById(1);
            System.out.println(empById);
        } finally {
            sqlSession.close();
        }
    }


    /**
     * 测试增删改的方法
     * 1、mybatis允许增删改直接定义以下类型返回值
     * 		Integer、Long、Boolean、void
     * 2、我们需要手动提交数据
     * 		sqlSessionFactory.openSession();===》手动提交
     * 		sqlSessionFactory.openSession(true);===》自动提交
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //不会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            //测试增加的方法
//            mapper.addEmp(new Employee("jackson","jackson@qq.com","0"));
            //测试修改的方法
//            mapper.updateEmp(new Employee(4,"jackson","jackson@163.com","1"));
            //测试删除的方法
            Integer integer = mapper.deleteEmp(4);
            System.out.println(4);
            //提交
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

}
