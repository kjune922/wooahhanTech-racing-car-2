package racingcar.validate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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

        assertThatCode(() ->
                tryNumValidator.validateTryNum(tryNum))
                .doesNotThrowAnyException();
    }

    @Test
    void 시도_횟수가_음수이면_예외가_발생한다() {
        TryNumValidator validator = new TryNumValidator();

        assertThatThrownBy(() -> validator.validateTryNum(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

}