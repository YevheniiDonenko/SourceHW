package hw4;

import java.util.Scanner;

public class rectangle {
	public static void printRectangle(int a, int b) {
		for (int i = 1; i <= b; i++) {
			System.out.print("*");
		}
		for (int i = 1; i <= a - 2; i++) {
			System.out.print("\n*");
			for (int j = 1; j <= b - 2; j++) {
				System.out.print(" ");
			}
			System.out.print("*");
		}
		System.out.println();
		for (int i = 1; i <= b; i++) {
			System.out.print("*"); 
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Введите высоту прямоугольника: ");
		int height = sc.nextInt();
		System.out.println("Введите ширину прямоугольника: ");
		int width = sc.nextInt();

		printRectangle(height, width);

	}
}
