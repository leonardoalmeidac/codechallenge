package com.almeida.codechallenge.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.almeida.codechallenge.models.Game;
import com.almeida.codechallenge.models.Roll;
import com.almeida.codechallenge.service.impl.BowlingServiceImpl;

public class BowlingServiceTest {

	private BowlingService bowlingService;

	@Before
	public void setUp() {
		bowlingService = new BowlingServiceImpl();

	}

	@Test
	public void shouldCalculateZeroScore() {

		Map<String, List<Roll>> playersRoll = new HashMap<>();
		List<Roll> rolls = new ArrayList<>();
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));

		playersRoll.put("Leonardo", rolls);
		List<Game> game = bowlingService.init(playersRoll);

		assertThat(game.get(0).getFinalScore(), is(0));

	}

	@Test
	public void shouldCalculatePerfectScore() {

		Map<String, List<Roll>> playersRoll = new HashMap<>();
		List<Roll> rolls = new ArrayList<>();
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));

		playersRoll.put("Leonardo", rolls);
		List<Game> game = bowlingService.init(playersRoll);

		assertThat(game.get(0).getFinalScore(), is(300));

	}

	@Test
	public void shouldCalculateTwoPlayersScore() {

		Map<String, List<Roll>> playersRoll = new HashMap<>();
		List<Roll> leonardoRolls = new ArrayList<>();
		leonardoRolls.add(new Roll(10));
		leonardoRolls.add(new Roll(7));
		leonardoRolls.add(new Roll(3));
		leonardoRolls.add(new Roll(9));
		leonardoRolls.add(new Roll(0));
		leonardoRolls.add(new Roll(10));
		leonardoRolls.add(new Roll(0));
		leonardoRolls.add(new Roll(8));
		leonardoRolls.add(new Roll(8));
		leonardoRolls.add(new Roll(2));
		leonardoRolls.add(new Roll(0));
		leonardoRolls.add(new Roll(6));
		leonardoRolls.add(new Roll(10));
		leonardoRolls.add(new Roll(10));
		leonardoRolls.add(new Roll(10));
		leonardoRolls.add(new Roll(8));
		leonardoRolls.add(new Roll(1));

		List<Roll> fernandoRolls = new ArrayList<>();
		fernandoRolls.add(new Roll(3));
		fernandoRolls.add(new Roll(7));
		fernandoRolls.add(new Roll(6));
		fernandoRolls.add(new Roll(3));
		fernandoRolls.add(new Roll(10));
		fernandoRolls.add(new Roll(8));
		fernandoRolls.add(new Roll(1));
		fernandoRolls.add(new Roll(10));
		fernandoRolls.add(new Roll(10));
		fernandoRolls.add(new Roll(9));
		fernandoRolls.add(new Roll(0));
		fernandoRolls.add(new Roll(7));
		fernandoRolls.add(new Roll(3));
		fernandoRolls.add(new Roll(4));
		fernandoRolls.add(new Roll(4));
		fernandoRolls.add(new Roll(10));
		fernandoRolls.add(new Roll(9));
		fernandoRolls.add(new Roll(0));

		playersRoll.put("Leonardo", leonardoRolls);
		playersRoll.put("Fernando", fernandoRolls);
		List<Game> game = bowlingService.init(playersRoll);

		assertThat(game.get(0).getFinalScore(), is(167));
		assertThat(game.get(1).getFinalScore(), is(151));

	}

	@Test
	public void isSpare() {
		assertThat(bowlingService.isSpare(new Roll(7), new Roll(3)), is(true));
	}

	@Test
	public void isStrike() {
		assertThat(bowlingService.isStrike(new Roll(10)), is(true));
	}
	
}
