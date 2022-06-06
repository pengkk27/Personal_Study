package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {


	@RequestMapping("/adminLogin")
	public String toLogin() {
		return "admin-login";
	}

	@RequestMapping("/login")
	public String adminLogin(@RequestParam("account")String account,
							 @RequestParam("password")String password,
							 HttpServletRequest request) {
		return "redirect:/adminLogin";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("admin");
		return "redirect:/adminLogin";
	}
}
