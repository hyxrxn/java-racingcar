package controller;

import domain.Cars;
import utils.Random;
import view.InputView;
import view.OutputView;

public class RacingGame {
    public static void main(String[] args) {
        try {
            run();
        } catch (StackOverflowError e) {
            System.out.println("잘못된 입력의 반복으로 프로그램을 종료합니다.");
        }
    }

    private static void run() {
        Cars cars = createCars();
        int count = initCount();
        OutputView.showRoundStart();
        for (int round = 1; round <= count; round++) {
            cars.tryMove(new Random());
            OutputView.showRoundResult(cars.getRoundResult());
        }
        OutputView.showWinners(cars.findWinnersName());
    }

    private static Cars createCars() {
        try {
            return new Cars(InputView.readCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createCars();
        }
    }

    private static int initCount() {
        try {
            return InputView.readRoundNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initCount();
        }
    }
}