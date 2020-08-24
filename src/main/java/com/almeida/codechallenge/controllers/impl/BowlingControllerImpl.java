package com.almeida.codechallenge.controllers.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.almeida.codechallenge.controllers.BowlingController;
import com.almeida.codechallenge.models.Game;
import com.almeida.codechallenge.models.Roll;
import com.almeida.codechallenge.service.BowlingService;

@Controller
public class BowlingControllerImpl implements BowlingController {

	@Autowired
	private BowlingService bowlingService;

	/**
	 * Inizialize Bowling Game
	 * 
	 * @param filePath
	 */
	@Override
	public List<Game> bowlingGame(Map<String, List<Roll>> rolls) {
		return bowlingService.init(rolls);
	}

}