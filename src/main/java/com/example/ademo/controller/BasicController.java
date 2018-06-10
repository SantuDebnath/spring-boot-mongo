package com.example.ademo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class BasicController {

	@RequestMapping("/user/greet")
	String userHome() {
		return "Hello USER!";
	}
	
	@RequestMapping("/admin/greet")
	String adminHome() {
		return "Hello ADMIN!";
	}
}
