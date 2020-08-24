package com.almeida.codechallenge.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.almeida.codechallenge.models.Game;
import com.almeida.codechallenge.service.PrintService;

@Service
public class PrintServiceImpl implements PrintService {

	private StringBuilder string = new StringBuilder();

	private String stringScore = "";

	private static final String STRIKE = "X";

	private static final String PRINT_HEADER = "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\n";

	private static final String PRINT_SCORE_LABEL = "\nScore\t\t";

	private static final String PRINT_PINFALLS_LABEL = "\nPinfalls\t";

	private static final String TAB = "\t";

	private static final String CARRIAGE_RETURN = "\n";

	@Override
	public String getResultsString(List<Game> games) {
		string.append(PRINT_HEADER);

		games.forEach(game -> {

			string.append(game.getPlayerName());

			string.append(PRINT_PINFALLS_LABEL);

			game.getFrames().forEach(frame -> {

				List<String> pinsDown = frame.getRolls().stream()
						.map(roll -> roll.isFoul() ? "F" : Integer.toString(roll.getValue()))
						.collect(Collectors.toList());

				if (frame.isStrike() && pinsDown.size() <= 2)
					string.append(printStrike());
				else if (frame.isSpare())
					string.append(printSpare(pinsDown));
				else
					string.append(printBasic(pinsDown));

				stringScore += frame.getScore() + TAB + TAB;

			});

			string.append(PRINT_SCORE_LABEL);
			string.append(stringScore);
			stringScore = "";
			string.append(CARRIAGE_RETURN);
		});

		return string.toString();

	}
	@Override
	public String printSpare(List<String> spare) {
		return spare.get(0) + TAB + "/" + TAB;
	}

	@Override
	public String printBasic(List<String> frame) {
		return frame.stream().map(roll -> (roll.equals("10") ? "X" : roll) + TAB).collect(Collectors.joining());
	}

	@Override
	public String printStrike() {
		return "\t" + STRIKE + "\t";
	}

}
