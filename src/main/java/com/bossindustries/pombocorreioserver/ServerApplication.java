package com.bossindustries.pombocorreioserver;

import com.bossindustries.pombocorreioserver.model.User;
import com.bossindustries.pombocorreioserver.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository) {
		return args -> {
			userRepository.save(
					new User(
							null,
							"Bruno Oliveira",
							"https://img.icons8.com/fluency/48/000000/user-male-circle.png")
			);
		};
	}

}
