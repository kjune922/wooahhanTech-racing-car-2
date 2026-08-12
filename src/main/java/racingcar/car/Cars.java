package racingcar.car;

import racingcar.generate.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public Cars(List<Car> carList) {
        this.cars = List.copyOf(carList);
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
            int randomNumber = randomNumberGenerator.randomNumberGenerate();
            car.move(randomNumber);
        }
    }

    public List<String> findWinners(){
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(car.getPosition(),maxDistance);
        }
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.getPosition() == maxDistance){
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

}
