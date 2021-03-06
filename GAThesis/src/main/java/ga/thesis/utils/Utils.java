package ga.thesis.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Utils {
	public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
		for (Entry<T, E> entry : map.entrySet()) {
			if (value.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

	public static <T> boolean isValidList(List<T> list) {
		Set<T> set = new HashSet<T>(list.size());
		for (T item : list) {
			if (!set.add(item)) {
				return false;
			}
		}
		return true;
	}
}
