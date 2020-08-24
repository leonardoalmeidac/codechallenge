package com.almeida.codechallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest
@Profile("test")
class CodechallengeApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(CodechallengeApplication.class, args);
	}
}
