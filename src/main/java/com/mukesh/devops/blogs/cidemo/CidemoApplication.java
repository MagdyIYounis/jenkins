package com.mukesh.devops.blogs.cidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CidemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CidemoApplication.class, args);
	}

}

@RestController
class HelloWorldController {
    @GetMapping("/hello")
    public Message helloWorld() {
        return new Message("Hello World");
    }
}

class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}