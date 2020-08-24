package com.almeida.codechallenge.models;

public class Roll {

	private final int value;

	private final boolean foul;

	public boolean isFoul() {
		return foul;
	}

	public int getValue() {
		return value;
	}

	public Roll(int value) {
		super();
		this.value = value;
		this.foul = false;
	}

	public Roll(int value, boolean foul) {
		super();
		this.value = foul ? 0 : value;
		this.foul = foul;
	}

}
