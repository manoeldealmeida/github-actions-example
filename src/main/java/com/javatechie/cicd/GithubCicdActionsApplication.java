package com.javatechie.cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GithubCicdActionsApplication {

	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome javatechie!";
	}
	
	@GetMapping("/api/v1/is-valid-item")
	public ResponseEntity isValidItem(@RequestParam("item") String item) {
		
		if(item == null || item.trim().isEmpty() || item.matches("\\d+"))
			return ResponseEntity.badRequest().build();
		else
			return ResponseEntity.ok().build();
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GithubCicdActionsApplication.class, args);
	}

}
