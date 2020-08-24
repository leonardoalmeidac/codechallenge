package com.almeida.codechallenge.controllers;

import java.util.List;
import java.util.Map;

import com.almeida.codechallenge.models.Roll;

public interface ParseFileController {
	public Map<String, List<Roll>> parseFile(String filePath);
}
