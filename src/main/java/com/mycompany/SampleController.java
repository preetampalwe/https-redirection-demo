package com.mycompany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	private static Logger logger = LoggerFactory.getLogger(SampleController.class);

	@RequestMapping("/hello")
	public String hello(@RequestParam(defaultValue = "Spring Boot") String user) {
		logger.debug("user -- " + user);
		return "Hello " + user + " !";
	}

}
