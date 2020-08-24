package com.almeida.codechallenge.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.almeida.codechallenge.controllers.PrintController;
import com.almeida.codechallenge.models.Game;
import com.almeida.codechallenge.service.PrintService;

@Controller
public class PrintControllerImpl implements PrintController {

	@Autowired
	private PrintService printService;

	/**
	 * @param games
	 */
	@Override
	public String getResultsString(List<Game> games) {
		return printService.getResultsString(games);

	}
}
