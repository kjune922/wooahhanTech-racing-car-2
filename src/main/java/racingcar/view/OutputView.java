package racingcar.view;

import racingcar.car.Car;

import java.util.List;

public class OutputView {

    public void inputCarNameMessage() {
        System.out.println("자동차 이름을 입력하세요(자동차 이름은 쉼표(,)로 구분해주세요)");
    }

    public void inputTryNumMessage() {
        System.out.println("자동차가 이동을 시도할 횟수를 입력하세요");
    }

    public void printRoundResult(List<Car> cars){
        for (Car car : cars) {
            System.out.println(
                    car.getCarName() + ": " + "-".repeat(car.getPosition())
            );
        }
        System.out.println();
    }
}
