package racingcar.validate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.car.Cars;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarNameValidatorTest {

    @Test
    void 자동차_이름_중복_불가능 () {
        String[] carNames = {"lee","kim","lee"};
        CarNameValidator carNameValidator = new CarNameValidator();
        assertThatThrownBy(() ->
                carNameValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

}