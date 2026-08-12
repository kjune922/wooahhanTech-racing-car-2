package racingcar.car;

import racingcar.generate.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    public static Cars createCars(String[] carNames) {

        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return new Cars(carList);
    }

    public List<Car> getCarList() {
        return List.copyOf(cars);
    }

    public void moveAll() {

        for (Car car : cars) {
            car.move(new RandomNumberGenerator().randomNumberGenerate());
        }
    }

}
