package com.wz;

import com.wz.mapper.MapperDemo;
import org.hsqldb.jdbc.JDBCDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@MapperScan(basePackages = "com.wz")
@Configuration
public class MybatisSpringApp {

  public static void main(String[] args) {
    ApplicationContext ac = new AnnotationConfigApplicationContext(MybatisSpringApp.class);
    MapperDemo md = ac.getBean(MapperDemo.class);
    md.query();
    System.out.println("-----------");

  }

  @Bean
  public SqlSessionFactoryBean sqlSessionFactoryBean(){
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource());
    return sqlSessionFactoryBean;
  }

  public DataSource dataSource(){
      return new JDBCDataSource();
  }

}
