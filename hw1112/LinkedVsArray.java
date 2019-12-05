package hw1112;

import java.util.LinkedList;

public class LinkedVsArray {

	public static void main(String[] args) {
		LinkedList<String> liList = new LinkedList<>();
		for (int i = 0; i < 1000000; i++) {
			liList.add("hello");
		}
		System.out.println(liList.size());
		long mill = System.currentTimeMillis();
		for (int i = 500000; i < 510000; i++) {
			liList.add(i, "hello");
		}
		long delta = System.currentTimeMillis() - mill;
		System.out.println(delta);
		System.out.println(liList.size());
	}

}
