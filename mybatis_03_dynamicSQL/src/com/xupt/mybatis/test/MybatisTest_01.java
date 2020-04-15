package com.xupt.mybatis.test;

import com.xupt.mybatis.dao.EmployeeMapperDynamicSQL;
import com.xupt.mybatis.pojo.Department;
import com.xupt.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wnlife
 * @create 2020-04-13 9:49
 */
public class MybatisTest_01 {


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
    public void test01() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            EmployeeMapperDynamicSQL mapper2 = sqlSession2.getMapper(EmployeeMapperDynamicSQL.class);
//            List<Employee> emps = mapper.getEmpsByConditionIf(new Employee(1, "%to%", "tom@xupt.edu.cn", "1",new Department()));
//            for (Employee emp : emps) {
//                System.out.println(emp);
//            }

            //查询的时候如果某些条件没带可能sql拼装会有问题
            //1、给where后面加上1=1，以后的条件都and xxx.
            //2、mybatis使用where标签来将所有的查询条件包括在内。mybatis就会将where标签中拼装的sql，多出来的and或者or去掉
            //where只会去掉第一个多出来的and或者or。

//            List<Employee> emps = mapper.getEmpsByConditionTrim(new Employee(1, "%to%", null, "1"));
            List<Employee> emps = mapper.getEmpsByConditionChoose(new Employee(1, null, null, null,null));

            for (Employee emp : emps) {
                System.out.println(emp);
            }
            sqlSession.close();
           List<Employee> emps2 = mapper2.getEmpsByConditionChoose(new Employee(1, null, null, null,null));
            for (Employee emp : emps2) {
                System.out.println(emp);
            }
            sqlSession.close();

// mapper.updateEmp(new Employee(1, "tom", null, "1"));
//            sqlSession.commit();

//            List<Employee> emps = mapper.getEmpsByConditionForeach(Arrays.asList(1, 2, 3));
//            for (Employee emp : emps) {
//                System.out.println(emp);
//            }
//            List<Employee>emps=new ArrayList<>();
//            emps.add(new Employee(null,"shuang","shuang@qq.com","0",new Department(1)));
//            emps.add(new Employee(null,"qiang","qiang@qq.com","1",new Department(2)));
//            mapper.insertEmployeesByForeach(emps);
//            sqlSession.commit();
        } finally {

        }
    }

}
