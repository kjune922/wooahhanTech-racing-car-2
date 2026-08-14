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
        String carName1 = "leeeee";
        String carName2 = "kimmm";

        CarNameValidator carNameValidator = new CarNameValidator();
        assertThatThrownBy(() ->
                carNameValidator.validateCarName(carName1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");

        assertThatCode(() -> carNameValidator.validateCarName(carName2))
                .doesNotThrowAnyException();

    }
    @Test
    void 자동차_이름은_빈_문자열일_수_없다() {
        CarNameValidator validator = new CarNameValidator();

        assertThatThrownBy(() -> validator.validateCarName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어 있을 수 없습니다.");
    }

    @Test
    void 자동차_이름_앞뒤에_공백은_불가능하다 () {
        CarNameValidator carNameValidator = new CarNameValidator();
        assertThatThrownBy(() -> carNameValidator.validateCarName(" lee"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 앞뒤에는 공백을 포함할 수 없습니다.");
    }

    @Test
    void 자동차_이름은_공백으로만_구성될_수_없다() {
        CarNameValidator validator = new CarNameValidator();

        assertThatThrownBy(() -> validator.validateCarName("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어 있을 수 없습니다.");
    }

    @Test
    void 자동차_이름은_null일_수_없다() {
        CarNameValidator validator = new CarNameValidator();

        assertThatThrownBy(() -> validator.validateCarName(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어 있을 수 없습니다.");
    }

}