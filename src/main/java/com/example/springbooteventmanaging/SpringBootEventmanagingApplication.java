package com.example.springbooteventmanaging;
import org.springframework.boot.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class SpringBootEventmanagingApplication
{

	@RequestMapping("/testaufruf")
	String home() {
		return "Dies ist eine Testzeile!\nScheint alles zu funktionieren";
	}
	public static void main(String[] args)
	{
		SpringApplication.run
				(SpringBootEventmanagingApplication.class, args);
	}

}
