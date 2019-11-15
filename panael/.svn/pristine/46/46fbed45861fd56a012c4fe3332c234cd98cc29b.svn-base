package com.example.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entry.Admin;
import com.example.service.AdminService;

@CrossOrigin(origins = { "http://localhost:8080", "null" })
@Controller

public class UserListController {
     
	@RequestMapping(value = "1", method = RequestMethod.POST)
	@ResponseBody
	public String jumpPage(@RequestBody Map<String, String> map,HttpServletResponse response) {		
		Cookie cookie=new Cookie("id", map.get("id"));
		cookie.setMaxAge(600);
		response.addCookie(cookie);
		return "1";
	}
}
