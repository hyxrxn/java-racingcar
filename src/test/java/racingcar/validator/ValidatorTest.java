package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    private static final String EMPTY_NAME_CAR = "";
    private static final String CAR_NAME = "pobi";
    private static final String LONG_NAME_CAR = "longlongcars";
    private String[] racingCarNames;

    @Test
    @DisplayName("자동차가 한개일 때 예외 처리")
    public void validateCountOfCarTest() {
        racingCarNames = new String[]{CAR_NAME};

        assertThatThrownBy(() -> Validator.checkCountOfCar(racingCarNames)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("자동차 이름 빈칸일 때 예외처리")
    public void validateCarNameIsEmptyTest() {

        racingCarNames = new String[]{CAR_NAME, EMPTY_NAME_CAR};
        assertThatThrownBy(() -> Validator.checkCarsNameIsEmpty(racingCarNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 6자 이상일때 예외처리")
    public void validateCarNameSizeTest() {

        racingCarNames = new String[]{CAR_NAME, LONG_NAME_CAR};
        assertThatThrownBy(() -> Validator.checkCarsNameSize(racingCarNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복되는 자동차 이름이 있으면 예외처리")
    public void validateDuplicatedNameTest() {

        racingCarNames = new String[]{CAR_NAME, CAR_NAME};
        assertThatThrownBy(() -> Validator.checkDuplicatedName(racingCarNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유저 인풋이 ',' 로 끝나면 예외 처리")
    public void validateHaveLastInputCommaTest() {
        String userInput = "phobi,json,";

        assertThatThrownBy(() -> Validator.checkHaveLastInputComma(userInput)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 회수가 숫자가 아니면 예외처리")
    public void validateTryCountIsNotNaturalNumberTest() {
        String tryCountInput = "wrongInput";
        assertThatThrownBy(() -> Validator.checkTryCountIsNaturalNumber(tryCountInput)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 회수가 0이면 예외처리")
    public void validateTryCountIsZeroTest() {
        String tryCountInput = "0";
        assertThatThrownBy(() -> Validator.convertToInt(tryCountInput)).isInstanceOf(IllegalArgumentException.class);
    }

}