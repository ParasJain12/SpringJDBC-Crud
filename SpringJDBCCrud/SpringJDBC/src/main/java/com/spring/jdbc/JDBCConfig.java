package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class JDBCConfig {
   @Bean(name = {"ds"})
   public DataSource getDataSource()
   {
	   DriverManagerDataSource ds = new DriverManagerDataSource();
	   ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
	   ds.setUrl("jdbc:mysql://localhost:3306/student_manage");
	   ds.setUsername("root");
	   ds.setPassword("root");
	   return ds;
   }
   
   @Bean(name = {"jdbcTemplate"})
   public JdbcTemplate getTemplate()
   {
	   JdbcTemplate jdbc = new JdbcTemplate();
	   jdbc.setDataSource(getDataSource());
	   return jdbc;
   }
}
