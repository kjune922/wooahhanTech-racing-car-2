package racingcar.validate;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {

    public void validateCarName(String carName){

        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }

        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void validateCarNames(String[] carNames) {
        Set<String> set = new HashSet<>();
        for (String carName : carNames) {
            if(set.contains(carName)){
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
            set.add(carName);
        }

        for (String carName : carNames) {
            validateCarName(carName);
        }
    }
}
