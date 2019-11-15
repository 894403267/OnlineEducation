package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.entry.User;

@Mapper
public interface UserDao {
	public User checkLoginId(String email);
}
