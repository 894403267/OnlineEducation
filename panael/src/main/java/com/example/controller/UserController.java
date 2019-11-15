package com.example.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entry.User;
import com.example.service.UserService;

@Controller
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping(value = "judge", method = RequestMethod.POST)
	@ResponseBody
	public String jumpPage(@RequestBody Map<String, String> map,
			HttpServletResponse response) {
		String id = map.get("id");
		String password = map.get("password");
		User user = userService.checkLoginId(id);
		if (user == null) {
			return "0";
		} else {
			if (user.getPassword().equals(password)) {
				Cookie cookie = new Cookie("id", map.get("id"));
				cookie.setMaxAge(600);
				response.addCookie(cookie);
				if (user.getAdmin_flg() == 0) {
					return "2";
				}
				return "1";
			} else {
				return "-1";
			}
		}
	}
}
