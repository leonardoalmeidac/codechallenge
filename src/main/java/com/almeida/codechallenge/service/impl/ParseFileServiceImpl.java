package com.almeida.codechallenge.service.impl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almeida.codechallenge.exceptions.InputException;
import com.almeida.codechallenge.models.Roll;
import com.almeida.codechallenge.service.ParseFileService;
import com.almeida.codechallenge.validations.InputValidations;

@Service
public class ParseFileServiceImpl implements ParseFileService {

	@Autowired
	private InputValidations inputValidations;

	/**
	 * Parse file to a Map
	 * 
	 * @param filePath
	 * @return Map
	 */
	@Override
	public Map<String, List<Roll>> parseFile(String filePath) {
		Map<String, List<Roll>> playersRolls = new HashMap<>();
		try (Stream<String> stream = Files.lines(Paths.get(filePath), Charset.defaultCharset())) {

			stream.forEach(roll -> {

				String[] currentRoll = inputValidations.format(roll);

				String playerName = getPlayerName(currentRoll);

				boolean isFoul = getPinsDown(currentRoll).equals("F");
				int pinsDown = Integer.parseInt(isFoul ? "0" : inputValidations.validateRoll(getPinsDown(currentRoll)));

				List<Roll> rolls = playersRolls.getOrDefault(playerName, new ArrayList<>());
				rolls.add(new Roll(pinsDown, isFoul));
				playersRolls.put(playerName, rolls);

			});

		} catch (IOException e) {
			throw new InputException("File path not valid");
		}
		return playersRolls;

	}

	/**
	 * @param rollLine
	 * @return Player name
	 */

	private String getPlayerName(String[] rollLine) {
		return rollLine[0];
	}

	/**
	 * @param rollLine
	 * @return Pins down
	 */

	private String getPinsDown(String[] rollLine) {
		return rollLine[1];
	}

}
