package com.syntaxzero.shopease;

import com.syntaxzero.shopease.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ShopeaseApplication implements CommandLineRunner {


	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ShopeaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
