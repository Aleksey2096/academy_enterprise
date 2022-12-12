package by.academy.task01file_sorter.service;

import java.util.Comparator;
import java.util.regex.Pattern;

public final class ArrayComparator implements Comparator<String[]> {

	private final static Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

	@Override
	public int compare(String[] o1, String[] o2) {
		int size = Math.min(o1.length, o2.length);
		for (int i = 0; i < size; ++i) {
			if (!o1[i].equals(o2[i])) {
				if (isNumber(o1[i]) && isNumber(o2[i])) {
					return compareNumbers(o1[i], o2[i]);
				} else if (isNumber(o1[i])) {
					return -1;
				} else if (isNumber(o2[i])) {
					return 1;
				} else {
					return o1[i].compareTo(o2[i]);
				}
			}
		}
		return 0;
	}

	private boolean isNumber(String strNum) {
		if (strNum == null) {
			return false;
		}
		return NUMBER_PATTERN.matcher(strNum).matches();
	}

	private int compareNumbers(final String str1, final String str2) {
		return Double.valueOf(str1) < Double.valueOf(str2) ? -1 : 1;
	}
}
