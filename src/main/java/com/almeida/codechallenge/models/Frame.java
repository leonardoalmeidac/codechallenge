package com.almeida.codechallenge.models;

import java.util.List;

public class Frame {

	private List<Roll> rolls;

	private int score;

	private boolean spare;

	private boolean strike;

	public List<Roll> getRolls() {
		return rolls;
	}

	public void setRolls(List<Roll> rolls) {
		this.rolls = rolls;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isSpare() {
		return spare;
	}

	public void setSpare(boolean spare) {
		this.spare = spare;
	}

	public boolean isStrike() {
		return strike;
	}

	public void setStrike(boolean strike) {
		this.strike = strike;
	}

	public Frame(List<Roll> rolls, int score) {
		super();
		this.rolls = rolls;
		this.score = score;
	}

	public Frame(List<Roll> rolls, int score, boolean strike, boolean spare ) {
		super();
		this.rolls = rolls;
		this.score = score;
		this.strike = strike;
		this.spare = spare;
	}

	public Frame() {
		super();
	}

}
