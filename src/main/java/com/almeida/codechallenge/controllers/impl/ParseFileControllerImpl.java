package com.almeida.codechallenge.controllers.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.almeida.codechallenge.controllers.ParseFileController;
import com.almeida.codechallenge.models.Roll;
import com.almeida.codechallenge.service.ParseFileService;

@Controller
public class ParseFileControllerImpl implements ParseFileController {

	@Autowired
	private ParseFileService parseFileService;

	/**
	 * @param filePath
	 * @return
	 */
	@Override
	public Map<String, List<Roll>> parseFile(String filePath) {
		return parseFileService.parseFile(filePath);
	}
}
