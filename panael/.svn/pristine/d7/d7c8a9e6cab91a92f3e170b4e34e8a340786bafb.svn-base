package com.example.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entry.User;

@Service
public class UserService {
	@Resource
	private UserDao userDao;	
	
	public User checkLoginId(String email) {
		return userDao.checkLoginId(email);
	}
}
