package racingcar.validate;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

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

    @Test
    void 자동차_이름은_5글자까지만가능 () {
        String carName1 = "leeeeee";
        String carName2 = "kim";

        CarNameValidator carNameValidator = new CarNameValidator();
        assertThatThrownBy(() ->
                carNameValidator.validateCarName(carName1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");

        assertThatCode(() -> carNameValidator.validateCarName(carName2))
                .doesNotThrowAnyException();

    }

    @Test
    void 자동차_이름은_빈이름_공백_불가능 () {
        String carName1 = "";
        String carName2 = null;
        String carName3 = "    ";

        CarNameValidator carNameValidator = new CarNameValidator();

        assertThatThrownBy(() ->
                carNameValidator.validateCarName(carName1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어 있을 수 없습니다.");

        assertThatThrownBy(() ->
                carNameValidator.validateCarName(carName2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어 있을 수 없습니다.");

        assertThatThrownBy(() ->
                carNameValidator.validateCarName(carName3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어 있을 수 없습니다.");
    }

}