package com.example.serverside;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.serverside.model")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ServerSide2Application {

	public static void main(String[] args) {
		SpringApplication.run(ServerSide2Application.class, args);
	}
}
