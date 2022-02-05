package com.co.ubunpay.adapter.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ubuntec")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class JurisCoopController {

	@GetMapping("/message")
	public String getMessage() {
		String name = "Heisohn";
		System.out.println(name.substring(3, 5));
		return "V20200914_01";
	}

}
