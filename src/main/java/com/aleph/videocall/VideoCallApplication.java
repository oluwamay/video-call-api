package com.aleph.videocall;

import com.aleph.videocall.user.User;
import com.aleph.videocall.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideoCallApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoCallApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(UserService service){
		return args -> {
			service.register(User.builder()
							.email("sam@gmail.com")
							.password("12345")
							.username("samo")
					.build());
			service.register(User.builder()
							.email("dam@gmail.com")
							.password("12345")
							.username("damo")
					.build());
		};
	}
}
