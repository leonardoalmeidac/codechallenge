package com.almeida.codechallenge.controllers;

import java.util.List;
import java.util.Map;

import com.almeida.codechallenge.models.Game;
import com.almeida.codechallenge.models.Roll;

public interface BowlingController {
	public List<Game> bowlingGame(Map<String, List<Roll>> rolls);
}
