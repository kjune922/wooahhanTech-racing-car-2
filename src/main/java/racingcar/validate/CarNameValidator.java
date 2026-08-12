package racingcar.validate;

public class CarNameValidator {

    public void validateCarName(String carName){

        if(carName.isBlank()){
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
    }
}
