package hw5;

import java.util.Arrays;

public class Book {
	private String name;
	private String author;
	private String publishingHouse;
	private int date;
	private int pages;
	private double price;
	private String binding;

	public Book(String name, String author, String publishingHouse, int date, int pages, double price, String binding) {
		this.name = name;
		this.author = author;
		this.publishingHouse = publishingHouse;
		this.date = date;
		this.pages = pages;
		this.price = price;
		this.binding = binding;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {

		this.author = author;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public static void main(String[] args) {
		
		Book book1 = new Book("Водка", "А.С. Пушкин", "Пушок", 1996, 314, 19.50, "Мягкий");
		Book book2 = new Book("ЗОЖ", "Жека", "Exclusive.inc", 1970, 219, 20, "Твердый");
		Book book3 = new Book("Польза курения", "А.С. Пушкин", "Пушок", 2010, 400, 14.40, "Мягкий");
		Book book4 = new Book("Философия Java", "Жека", "Exclusive.inc", 2015, 85, 35.1, "Твердый");
		Book[] arr = { book1, book2, book3, book4 };

		// Вывести все книги
		System.out.println("Все книги:");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].getName() + " " + arr[i].getAuthor() + " " + arr[i].getPublishingHouse() + " "
					+ arr[i].getDate() + " " + arr[i].getPages() + " " + arr[i].getPrice() + " " + arr[i].getBinding());
		}
		//Книги заданного автора
		System.out.println("Книги А.С. Пушкина");

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getAuthor() == "А.С. Пушкин") {
				System.out.println(arr[i].getName() + " " + arr[i].getAuthor() + " " + arr[i].getPublishingHouse() + " "
						+ arr[i].getDate() + " " + arr[i].getPages() + " " + arr[i].getPrice() + " "
						+ arr[i].getBinding());
			}
		}
		//Книги заданного издательства
		System.out.println("Книги издательства Exclusive.inc:");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getPublishingHouse() == "Exclusive.inc") {
				System.out.println(arr[i].getName() + " " + arr[i].getAuthor() + " " + arr[i].getPublishingHouse() + " "
						+ arr[i].getDate() + " " + arr[i].getPages() + " " + arr[i].getPrice() + " "
						+ arr[i].getBinding());
			}
		}
//		// Книги, вышедшие после заданного года
		System.out.println("Книги, вышедшие после 1980 года:");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getDate() > 1980) {
				System.out.println(arr[i].getName() + " " + arr[i].getAuthor() + " " + arr[i].getPublishingHouse() + " "
						+ arr[i].getDate() + " " + arr[i].getPages() + " " + arr[i].getPrice() + " "
						+ arr[i].getBinding());
			}
		}
	
	}
	

}
