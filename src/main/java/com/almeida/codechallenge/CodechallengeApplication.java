package com.almeida.codechallenge;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.almeida.codechallenge.controllers.BowlingController;
import com.almeida.codechallenge.controllers.ParseFileController;
import com.almeida.codechallenge.controllers.PrintController;
import com.almeida.codechallenge.models.Game;
import com.almeida.codechallenge.models.Roll;

@SpringBootApplication
public class CodechallengeApplication implements CommandLineRunner {

	@Autowired
	private BowlingController bowlingController;

	@Autowired
	private ParseFileController parseFileController;

	@Autowired
	private PrintController printController;

	@Override
	public void run(String... args) throws Exception {
		String filePath = Arrays.stream(args).collect(Collectors.joining("-"));

		Map<String, List<Roll>> rolls = parseFileController.parseFile(filePath);

		List<Game> games = bowlingController.bowlingGame(rolls);

		System.out.print(printController.getResultsString(games));
	}

	public static void main(String[] args) {
		SpringApplication.run(CodechallengeApplication.class, args);
	}

}

