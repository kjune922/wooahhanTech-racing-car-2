package racingcar.car;

public class Car {

    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber){
        if(randomNumber >= 4){
            position++;
        }
    }
}
