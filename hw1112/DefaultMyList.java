package hw1112;

import java.util.Arrays;

public class DefaultMyList {
	private int size;
	private Object[] arr;

	public void clear() {
		for (int i = 0; i < size; i++) {
			arr[i] = null;
		}
		size = 0;
	}

	public boolean remove(Object obj) {
		for (int i = 0; i < size; i++) {
			if (obj.equals(arr[i])) {
				arr[i] = null;
				return true;
			}
		}
		return false;
	}

	public Object[] toArray() {
		return Arrays.copyOf(arr, size);
	}

	public int size() {
		return size;
	}

	public boolean contains(Object obj) {
		for (int i = 0; i < size; i++) {
			if (obj.equals(arr[i]))
				return true;
		}
		return false;
	}

	public boolean containsAll(MyList list) {
		for (Object obj : list) {
			if (!(contains(obj))) {
				return false;
			}
		}
		return true;
	}
}
