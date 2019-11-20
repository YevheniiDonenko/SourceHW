package hw6;

import java.util.Arrays;

public class Gift {

	public static void main(String[] args) {
		Candy one = new Candy("Chupa Chups", "Lollipop", "Round", 5, 42, 12);
		Candy two = new Candy("Succulent Willie Lollipop", "Lollipop", "Round", 3, 70, 35);
		Candy three = new Candy("Rafaello", "Soft", "Round", 3, 92, 15);
		Candy four = new Candy("Ferrero Rocher", "Chocolate", "Round", 5, 100, 15);
		Candy five = new Candy("Ромашка", "Chocolate", "Square", 4, 90, 17);
		Candy six = new Candy("Коровка", "Chocolate", "Square", 5, 55, 12);
		Candy seven = new Candy("Красный мак", "Chocolate", "Sqruare", 2, 71, 12);
		Candy[] gift = { one, two, three, four, five, six, seven };
		int weightOfGift = 0;
		System.out.println("Подарок, отсортированный по весу: ");
		for (int i = 0; i < gift.length; i++) {
			weightOfGift += gift[i].getWeight();

		}
		Arrays.sort(gift);
		System.out.println(Arrays.toString(gift));

		System.out.println("Вес подарка - " + weightOfGift + "граммv.");
		System.out.println("Конфеты, в которых более 3х грамм сахара");
		for (int i = 0; i < gift.length; i++) {
			if (gift[i].getSugar() > 3) {
				System.out.println(gift[i].getName());
			}
		}
	}
}
