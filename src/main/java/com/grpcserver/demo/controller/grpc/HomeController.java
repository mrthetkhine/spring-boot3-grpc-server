package com.grpcserver.demo.controller.grpc;

import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/")
	String home()
	{
		return "Hello "+new Date();
	}

}
