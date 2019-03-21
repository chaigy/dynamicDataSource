package com.cgy.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cgy.mvc.dao.UserDao;
import com.cgy.mvc.dynamic.DynamicDataSourceHandler;

@SpringBootApplication
public class SpringDynamicDatasourceApplication  implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringDynamicDatasourceApplication.class, args);
	}

	@Autowired
	private UserDao dao;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		DynamicDataSourceHandler.setDataType("sc");
		System.out.println(dao.getUser(1));
		
		DynamicDataSourceHandler.setDataType("qk");
		System.out.println(dao.getUser(1));
		
		DynamicDataSourceHandler.setDataType("sc");
		System.out.println(dao.getUser(1));
		
		DynamicDataSourceHandler.setDataType("qk");
		System.out.println(dao.getUser(1));
		
	}

}
