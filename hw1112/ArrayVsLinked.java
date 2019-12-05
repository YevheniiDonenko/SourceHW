package hw1112;

import java.util.ArrayList;

public class ArrayVsLinked {
	public static void main(String[] args) {
		ArrayList<String> arList = new ArrayList<>();
		for (int i = 1; i <= 1000000; i++) {
			arList.add("hello");
		}
		System.out.println(arList.size());
		long mill = System.currentTimeMillis();
		for (int i = 500000; i < 510000; i++) {
			arList.add(i, "hello");
		}
		long delta = System.currentTimeMillis() - mill;
		System.out.println(delta);
		System.out.println(arList.size());

	}
}
