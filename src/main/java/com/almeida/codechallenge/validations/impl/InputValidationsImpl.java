package com.almeida.codechallenge.validations.impl;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.almeida.codechallenge.exceptions.InputException;
import com.almeida.codechallenge.validations.InputValidations;

@Component
public class InputValidationsImpl implements InputValidations {

	/**
	 * Validate roll value
	 * 
	 * @param rollValue
	 * @return
	 */
	@Override
	public String validateRoll(String rollValue) {

		if (Pattern.matches("^-?(\\d+)$", rollValue)) { // If it's number
			Integer roll = Integer.parseInt(rollValue);
			if (roll < 0 || roll > 10)
				throw new InputException("Roll invalid. I must be number between 0 and 10");
		} else if (!Pattern.matches("^([fF])$", rollValue)) {
			throw new InputException("Roll invalid. I must be an 'F' or number");
		}

		return rollValue;

	}

	/**
	 * Validate file text format
	 * 
	 * @param roll
	 * @return
	 */
	@Override
	public String[] format(String roll) {
		String[] line = roll.split("\\t");
		if (line.length != 2)
			throw new InputException("File format invalid");
		return line;
	}
}
