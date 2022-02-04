package com.jarzsoft.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping({ "/ping" })
	public String firstPage() {
		return "pong";
	}

}