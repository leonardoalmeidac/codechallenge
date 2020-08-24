package com.almeida.codechallenge.controllers;

import java.util.List;

import com.almeida.codechallenge.models.Game;

public interface PrintController {
	public String getResultsString(List<Game> games);
}
