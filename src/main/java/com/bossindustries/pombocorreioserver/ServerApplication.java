package com.bossindustries.pombocorreioserver;

import com.bossindustries.pombocorreioserver.model.Message;
import com.bossindustries.pombocorreioserver.model.User;
import com.bossindustries.pombocorreioserver.repository.MessageRepository;
import com.bossindustries.pombocorreioserver.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(MessageRepository messageRepository) {
		return args -> {
			messageRepository.save(
					new Message(
							null,
							24L,
							"New Message!",
							LocalDateTime.now())
			);
		};
	}

}
