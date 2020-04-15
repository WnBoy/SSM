package com.xupt.mybatis.test;

import com.xupt.mybatis.dao.EmployeeMapper;
import com.xupt.mybatis.pojo.Employee;
import com.xupt.mybatis.pojo.EmployeeExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

    /**
     * 运行MBG,生成相关文件
     * @throws Exception
     */
    @Test
    public void testMBG() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    /**
     *  测试simple版本的MBG
     */
   /* @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = mapper.selectAll();
            for (Employee employee : employees) {
                System.out.println(employee.getId());
            }
        } finally {
            sqlSession.close();
        }

    }*/


    /**
     * 测试好豪华版的MBG
     */
   @Test
   public void test3() throws IOException {
       SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
       SqlSession sqlSession = sqlSessionFactory.openSession();
       try {
           EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

           //查询所有
//           List<Employee> employees = mapper.selectByExample(null);

           //xxxExample就是封装查询条件的
           EmployeeExample example=new EmployeeExample();
           //查询姓名带a的女士
           EmployeeExample.Criteria criteria = example.createCriteria();
           criteria.andLastNameLike("%a%");
           criteria.andGenderEqualTo("0");
           //或者查询email带e的
           EmployeeExample.Criteria criteria2 =  example.createCriteria();
           criteria2.andEmailLike("e");
           //设置查询条件or关系
           example.or(criteria2);
           List<Employee> employees = mapper.selectByExample(example);
           for (Employee employee : employees) {
               System.out.println(employee.getId());
           }
       } finally {
           sqlSession.close();
       }
   }


}
