package racingcar.validate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TryNumValidatorTest {

    @Test
    void 시도횟수는_1미만은_불가능 () {
        int tryNum = 0;
        TryNumValidator tryNumValidator = new TryNumValidator();

        Assertions.assertThatThrownBy(() ->
                tryNumValidator.validateTryNum(tryNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도횟수는 1미만일 수 없습니다.");
    }

    @Test
    void 시도횟수는_무조건_1이상 () {
        int tryNum = 1;
        TryNumValidator tryNumValidator = new TryNumValidator();

        Assertions.assertThatCode(() ->
                tryNumValidator.validateTryNum(tryNum))
                .doesNotThrowAnyException();
    }

}