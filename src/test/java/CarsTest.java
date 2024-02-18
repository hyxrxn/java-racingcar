import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;

import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NumberGenerator;
import utils.Random;

class CarsTest {

    @Test
    @DisplayName("객체가 정상적으로 생성된다.")
    void createObjectTest() {
        assertThatCode(() -> new Cars(List.of("pobi")))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력된 이름이 없으면 예외가 발생한다.")
    void emptyListExceptionTest() {
        assertThatThrownBy(() -> new Cars(Collections.EMPTY_LIST))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 이름을 사용하면 예외가 발생한다.")
    void duplicatedNameExceptionTest() {
        assertThatThrownBy(() -> new Cars(List.of("takan", "takan")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("우승자 선정이 정상적으로 동작한다.")
    void chooseWinnerTest() {
        Cars cars = new Cars(List.of(
                "atto",
                "takan",
                "siso"));
        List<NumberGenerator> numberGenerator = List.of(
                new Constant(9),
                new Constant(3),
                new Constant(4));
        for (int round = 1; round <= 3; round++) {
            cars.tryMove(numberGenerator);
        }

        assertThat(cars.findWinnersName())
                .containsAll(List.of("atto", "siso"));
    }
}
