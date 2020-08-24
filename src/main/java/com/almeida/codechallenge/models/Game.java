package com.almeida.codechallenge.models;

import java.util.List;

public class Game {

	private String playerName;

	private List<Frame> frames;

	private final Integer finalScore;

	public Integer getFinalScore() {
		return finalScore;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}

	public Game(String playerName, List<Frame> frames) {
		super();
		this.playerName = playerName;
		this.frames = frames;
		this.finalScore = frames.get(frames.size() - 1).getScore();
	}

}
