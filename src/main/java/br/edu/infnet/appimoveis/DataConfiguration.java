package br.edu.infnet.appimoveis;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataConfiguration {
	
	   @Bean
	   @Primary
	   public DataSource dataSource() {
	      DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	      dataSource.setUrl("jdbc:mysql://db-infnet.cyd1gxaisosi.us-east-2.rds.amazonaws.com:3306/infnetdb?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=GMT");
	      dataSource.setUsername("marcelojael");
	      dataSource.setPassword("nKry275k5P9z");
	      return dataSource;
	   }

}
