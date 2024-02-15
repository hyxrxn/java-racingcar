import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    Cars cars;

    @BeforeEach
    void setup() {
        cars = new Cars(List.of("pobi", "atto"), new Random());
    }

    @Test
    @DisplayName("객체가 정상적으로 생성된다.")
    void createObjectTest() {
        assertThatCode(() -> new Cars(List.of("pobi"), new Random()))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력된 이름이 없으면 예외가 발생한다.")
    void emptyListExceptionTest() {
        assertThatThrownBy(() -> new Cars(Collections.EMPTY_LIST, new Random()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}