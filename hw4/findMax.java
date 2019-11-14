package hw4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class findMax {
	public static void findMaxElement(int[] array) {
		int maxElement = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > maxElement) {
				maxElement = array[i];
			}
		}
		System.out.println("Ваш массив: " + Arrays.toString(array));
		System.out.println("Максимальный элемент: " + maxElement);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Введите максимальное количество элементов массива: ");
		int maxLen = sc.nextInt();
		Random rnd = new Random();
		int[] arr = new int[maxLen];
		for (int i = 0; i < maxLen; i++) {
			arr[i] = rnd.nextInt(50);			
		}

		findMaxElement(arr);

	}
}
