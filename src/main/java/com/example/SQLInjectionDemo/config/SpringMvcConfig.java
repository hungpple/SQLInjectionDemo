package com.example.SQLInjectionDemo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.SQLInjectionDemo.model.IStudentDAO;
import com.example.SQLInjectionDemo.model.IUserDAO;
import com.example.SQLInjectionDemo.model.StudentDAO;
import com.example.SQLInjectionDemo.model.UserDAO;

@Configuration
@ComponentScan(basePackages="com.example.SQLInjectionDemo")
@EnableWebMvc
public class SpringMvcConfig extends WebMvcConfigurerAdapter{
	 	@Bean
	    public ViewResolver getViewResolver(){
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/view/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	    }
	     
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	    }
	 
	    @Bean
	    public DataSource getDataSource() {
	    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/studentdb?allowMultiQueries=true");
			dataSource.setUsername("root");
			dataSource.setPassword("root");
	         
	        return dataSource;
	    }
	     
	    @Bean
	    public IStudentDAO getStudentDAO() {
	        return new StudentDAO(getDataSource());
	    }
	    
	    @Bean
	    public IUserDAO getUserDAO() {
	        return new UserDAO(getDataSource());
	    }
	
}
