package com.xupt.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xupt.mybatis.dao.EmployeeMapperDynamicSQL;
import com.xupt.mybatis.pojo.Department;
import com.xupt.mybatis.pojo.EmpStatus;
import com.xupt.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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

    /**
     * 测试pagehelper
     *
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);

            Page<Object> page = PageHelper.startPage(1, 3);

            List<Employee> emps = mapper.getEmps();
            for (Employee emp : emps) {
                System.out.println(emp);
            }

//            System.out.println(page.getTotal());
//            System.out.println(page.getPageNum());
//            System.out.println(page.getPages());
//            System.out.println(page.getPageSize());

            //用PageInfo对结果进行包装 分页信息更加全面
            PageInfo pageInfo = new PageInfo(emps);
            System.out.println(Arrays.toString(pageInfo.getNavigatepageNums()));
            System.out.println(pageInfo.getNavigatePages());
            System.out.println(pageInfo.getList());
            System.out.println(pageInfo.getTotal());

        } finally {
            sqlSession.close();
        }
    }

    /**
     * 测试批量查询
     *
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);

        try {
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            for (int i = 1; i <= 10; i++) {
                String username = UUID.randomUUID().toString().substring(1, 5);
                mapper.addEmp(new Employee(null, username,
                        username + "@163.com", String.valueOf(i % 2), new Department(i % 2 + 1)));
//                sqlSession.flushStatements();
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 测试枚举类型
     *
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
//            Employee employee = new Employee(null, "rosei", "rosei@163.com", "0", new Department(1));
//            mapper.addEmp(employee);
            Employee employee = mapper.getEmpById(156);

            System.out.println(employee.getEmpStatus());
//            sqlSession.commit();

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test4() {
        EmpStatus login = EmpStatus.LOGIN;
        System.out.println("枚举的索引："+login.ordinal());
        System.out.println("枚举的名字："+login.name());

        System.out.println("枚举的状态码："+login.getCode());
        System.out.println("枚举的提示消息："+login.getMsg());
    }


}
