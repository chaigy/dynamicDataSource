package com.cgy.mvc.conf;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cgy.mvc.dynamic.DynamicDataSource;

@Configuration
@MapperScan(basePackages="com.cgy.mvc.dao",sqlSessionFactoryRef="sqlSessionfactory")
public class DataConfig {
	
	@Bean("cgy")
	@ConfigurationProperties(prefix="spring.datasource.cgy")
	public DataSource getdata(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean("cgy1")
	@ConfigurationProperties(prefix="spring.datasource.cgy1")
	public DataSource getdata1(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean("datasource1")
	public DynamicDataSource getDynamic(@Qualifier("cgy") DataSource cgy,@Qualifier("cgy1") DataSource cgy1) {
		DynamicDataSource dy = new DynamicDataSource();
		dy.setDefaultTargetDataSource(cgy);
		Map<Object,Object> map = new HashMap<>();
		map.put("sc",cgy);
		map.put("qk", cgy1);
		dy.setTargetDataSources(map);
		return dy;
	}
	@Bean("sqlSessionfactory")
	public SqlSessionFactory getSqlSessionFactory(@Qualifier("datasource1") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean.getObject();
	}
}
