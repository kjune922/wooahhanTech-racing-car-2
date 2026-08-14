package racingcar.game;

import racingcar.car.Cars;
import racingcar.validate.CarNameValidator;
import racingcar.validate.TryNumValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;

public class Game {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CarNameValidator carNameValidator = new CarNameValidator();
    private final TryNumValidator tryNumValidator = new TryNumValidator();

    public void start(){

        Cars cars = readCars();
        int tryNum = readTryNum();
        play(cars,tryNum);

    }

    private Cars readCars() {
        outputView.inputCarNameMessage();

        String input = inputView.readCarNames();
        String[] carNames = parseCarNames(input);
        carNameValidator.validateCarNames(carNames);

        return Cars.createCars(carNames);
    }

    private int readTryNum() {
        outputView.inputTryNumMessage();

        int tryNum = inputView.readTryNum();
        tryNumValidator.validateTryNum(tryNum);

        return tryNum;
    }

    private void play(Cars cars, int tryNum) {
        outputView.printResultMessage();
        for (int i = 0; i < tryNum; i++) {
            cars.moveAll();
            outputView.printRoundResult(cars.getCarList());
        }
        List<String> winners = cars.findWinners();
        outputView.printWinners(winners);
    }

    private String[] parseCarNames(String input){
        return input.split(",",-1);
    }

}
