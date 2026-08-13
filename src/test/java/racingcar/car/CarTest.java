package racingcar.car;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 랜덤값이_4이상이면_전진 () {
        Car car = new Car("lee");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤값이_4미만이면_전진안함 () {
        Car car = new Car("lee");

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

}