package com.example.springbooteventmanaging;
import  com.example.springbooteventmanaging.models.*; // eine Ebene tiefer
import com.example.springbooteventmanaging.models.Event;
import org.springframework.boot.*;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@Log
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
	static void addInitHooks(SpringApplication application)
	{

	}

	// Bean for test data
	@Bean
	public CommandLineRunner demo(EventRepository repository) {
		return (args) -> {
			// save a couple of events (test data)
			Event current = new Event();
			current.setEventDescription("Segelflug für Anfänger");
			current.setLocation("schwäbische Alb");
			current.setProvider(new Organizer("Super-Events für alle","Bahnhofstrasse 4","Traumstadt",3456,"www.events_for_all.de"));
            current.setPrice(BigDecimal.valueOf(2300.60));
			repository.save(current);

			// fetch all events so far ...
			log.info("Events, welche mit findAll() gefunden wurden:");
			log.info("-------------------------------");
			for (Event veranstaltung : repository.findAll()) {
				log.info(veranstaltung.toString());
			}
			log.info("");


			log.info("");
		};
	}
}

