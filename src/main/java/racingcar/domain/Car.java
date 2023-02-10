package racingcar.domain;

import static racingcar.messsages.ExceptionMessage.*;

import java.util.Objects;

public class Car {
	private static final int MAX_NAME_LENGTH = 5;

	private final CarMovement carMovement;
	private final String name;
	private int position = 0;

	public Car(final CarMovement carMovement, final String name) {
		validateNameNullOrBlank(name);
		validateNameLength(name);
		this.carMovement = carMovement;
		this.name = name;
	}

	public boolean move() {
		final boolean isMoved = carMovement.isMove();
		if (isMoved) {
			position++;
		}
		return isMoved;
	}

	public boolean isSamePosition(final int position) {
		return this.position == position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	private void validateNameNullOrBlank(final String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException(CAR_NAME_BLANK_EXCEPTION.getMessage());
		}
	}

	private void validateNameLength(final String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION.getMessage());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Car)) {
			return false;
		}
		Car car = (Car)o;
		return position == car.position && Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}
}
