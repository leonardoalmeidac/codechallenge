package com.almeida.codechallenge.service;

import java.util.List;
import java.util.Map;

import com.almeida.codechallenge.models.Roll;

public interface ParseFileService {

	public Map<String, List<Roll>> parseFile(String filePath);

}
