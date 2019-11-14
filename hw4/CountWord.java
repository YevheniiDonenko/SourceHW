package hw4;

import java.util.Scanner;

public class CountWord {
	public static void countV(String a) {

		int count = 1;
		if (a.length() != 0) {
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) == ' ') {
					count++;
				}
			}
			System.out.println("Количество слов в строке = " + count);
		} else {
			System.out.println("Ваша строка пуста!!!");
		}

	}

	public static void main(String[] args) {
		System.out.println("Введите вашу строку через пробел");
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine();
		countV(inputStr);

	}
}
