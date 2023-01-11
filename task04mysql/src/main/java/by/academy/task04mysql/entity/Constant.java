package by.academy.task04mysql.entity;

import java.util.Objects;
import java.util.Random;

public final class Constant {
	public static final String PEOPLE_RESOURCE_FILE = Objects
			.requireNonNull(Constant.class.getClassLoader().getResource("data/people.dat"))
			.getFile();
	public static final int PEOPLE_QUANTITY = 100;
	public static final int MAX_AGE = 30;
	public static final int MIN_AGE = 15;
	public static final int UNDER_AGE_VALUE = 21;
	public static final Random RANDOM = new Random();
	public static final Name[] NAMES_ARRAY = Name.values();
	public static final Surname[] SURNAMES_ARRAY = Surname.values();
	public static final String SPACE = " ";

	private Constant() {
	}
}
