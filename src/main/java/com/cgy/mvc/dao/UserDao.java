package com.cgy.mvc.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
	
	@Select("select * from user where id=#{id}")
	public Map<String,Object> getUser(@Param("id") int id);
}
