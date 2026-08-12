package racingcar.game;

import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.Cars;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class GameTest {

    @Test
    void 가정_멀리_이동한_자동차를_우승자로_선정() {
        Car lee = new Car("lee");
        Car kim = new Car("kim");

        lee.move(4);

        Cars cars = new Cars(List.of(lee,kim));

        assertThat(cars.findWinner())
                .containsExactly("lee");
    }

    @Test
    void 위치가_같으면_공동_우승자 () {
        Car lee = new Car("lee");
        Car kim = new Car("kim");

        lee.move(4);
        kim.move(4);

        Cars cars = new Cars(List.of(lee,kim));

        assertThat(cars.findWinner())
                .containsExactly("lee","kim");
    }

}