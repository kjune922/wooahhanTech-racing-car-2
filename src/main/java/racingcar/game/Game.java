package racingcar.game;


import racingcar.car.Cars;
import racingcar.validate.CarNameValidator;
import racingcar.validate.TryNumValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;



public class Game {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CarNameValidator carNameValidator = new CarNameValidator();
    private final TryNumValidator tryNumValidator = new TryNumValidator();

    public void start(){

        outputView.inputCarNameMessage();
        String input = inputView.readCarNames();
        carNameValidator.validateCarName(input);

        outputView.inputTryNumMessage();
        int tryNum = inputView.readTryNum();
        tryNumValidator.validateTryNum(tryNum);

        String[] carNames = getCarNames(input);

        Cars cars = Cars.createCars(carNames);

        for (int i = 0; i < tryNum; i++) {
            cars.moveAll();
            outputView.printRoundResult(cars.getCarList());
        }
    }

    public String[] getCarNames(String input){
        return input.split(",",-1);
    }

}
