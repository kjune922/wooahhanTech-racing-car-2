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

        outputView.inputCarNameMessage();
        String input = inputView.readCarNames();
        String[] carNames = parseCarNames(input);
        carNameValidator.validateCarNames(carNames);

        outputView.inputTryNumMessage();
        int tryNum = inputView.readTryNum();
        tryNumValidator.validateTryNum(tryNum);

        Cars cars = Cars.createCars(carNames);
        /**
         * Cars cars = Cars.createCars(carNames); 에서 createCars메소드에 static이 붙는 이유
         * 왼쪽 -> Cars cars
         * Cars타입의 cars 변수를 선언함
         * 아직 Cars 객체가 담긴건 아님
         * 오른쪽 -> Cars.createCars(carNames);
         * Cars 클래스에 소속된 static 메소드를 객체 없이 호출
         *
         * Cars cars = "결과" ; 인건데 여기서
         * "결과"를 먼저 구해야 cars변수에 넣을 수 있는데, 결과를 구할려면 Cars객체가 필요함
         * static 메서드는 클래스에 소속된다
         * 그래서 객체 생성 없이, 클래스 이름으로만 호출 가능
         */

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
