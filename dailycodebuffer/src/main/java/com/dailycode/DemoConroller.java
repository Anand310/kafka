package com.dailycode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoConroller {

	@Autowired
	KafkaTemplate<String, Book> kafkaTemplate;
	
	private static final String TOPIC = "NewTopic";
	
	@PostMapping("/publish")
	public String publicMessage(@RequestBody Book book) {
		kafkaTemplate.send(TOPIC, book);
		return "Successfully published";
	}
		
}
