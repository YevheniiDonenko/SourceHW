package hw1112;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		List<String> cars = new ArrayList<>();
		cars.add("Ford");
		cars.add("BMW");
		cars.add("Audi");
		cars.add("Opel");
		cars.add("Nissan");
		cars.add("Honda");

		System.out.println("В листе cars " + cars.size() + " элементов:");
		System.out.println(cars.toString());

		cars.remove("Opel");
		System.out.println("А теперь " + cars.size() + ":");
		System.out.println(cars.toString());

		System.out.println("Есть ли в листе ВАЗ? - " + cars.contains("ВАЗ"));

		List<String> cars2 = new ArrayList<>();
		cars.add("Audi");
		cars.add("BMW");
		cars.add("Nissan");
		cars.add("Opel");
		cars.add("Honda");
		cars.add("Ford");

		System.out.println("Лист 1 и 2 одинаковы? - " + cars.containsAll(cars2));

		cars.clear();
		System.out.println("После очистки лист выглядит так: " + cars.toString());

	}
}
