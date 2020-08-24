package com.almeida.codechallenge.service;

import java.util.List;
import java.util.Map;

import com.almeida.codechallenge.models.Frame;
import com.almeida.codechallenge.models.Game;
import com.almeida.codechallenge.models.Roll;

public interface BowlingService {

	public List<Game> init(Map<String, List<Roll>> playerRolls);

	public boolean isSpare(Roll roll, Roll next);

	public boolean isStrike(Roll roll);

	public Frame createFrame(int score, boolean strike, boolean spare, Roll... rolls);

}
