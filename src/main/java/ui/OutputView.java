package ui;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String POSITION_MARK = "-";
    private static final String WINNERS_MESSAGE_DELIMITER = ", ";
    private static final String WINNERS_MESSAGE_FORMAT = "%s가 최종 우승했습니다.\n";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final int POSITION_MARK_DEFAULT_VALUE = 1;

    public void printCarsStatus(Map<String, Integer> carsStatus) {
        carsStatus.forEach((name, position) -> System.out.println(name + " : " + convertPosition(position)));
        System.out.println();
    }

    private String convertPosition(int position) {
        return POSITION_MARK.repeat(POSITION_MARK_DEFAULT_VALUE + position);
    }

    public void printWinners(List<String> winnerNames) {
        String winners = String.join(WINNERS_MESSAGE_DELIMITER, winnerNames);
        System.out.printf(WINNERS_MESSAGE_FORMAT, winners);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }
}