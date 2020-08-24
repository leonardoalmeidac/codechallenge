package com.almeida.codechallenge.service;

import java.util.List;

import com.almeida.codechallenge.models.Game;

public interface PrintService {

	public String getResultsString(List<Game> games);

	public String printSpare(List<String> spare);

	public String printBasic(List<String> frame);

	public String printStrike();
}