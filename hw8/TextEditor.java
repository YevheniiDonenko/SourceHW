package hw8;

import java.io.*;
import java.util.Scanner;

public class TextEditor {

	public static void wordCount(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner sc = new Scanner(file);
		int countWords = 0;

		while (sc.hasNextLine()) {
			String[] array = sc.nextLine().split(" ");
			countWords += array.length;
		}

		System.out.println("Всего слов: " + countWords);
		sc.close();
	}

	public static void maxVowels(String filename) throws IOException {
		File file = new File(filename);
		Scanner sc = new Scanner(file);
		int maxLine = 1;
		int maxVowels = 0;
		int temporaryLine = 1;
		while (sc.hasNextLine()) {
			String temporaryString = sc.nextLine();
			int countVowels = 0;

			for (int i = 0; i < temporaryString.length(); i++) {
				char temCh = temporaryString.charAt(i);
				if (temCh == 'a' || temCh == 'e' || temCh == 'y' || temCh == 'u' || temCh == 'i' || temCh == 'o'
						|| temCh == 'й' || temCh == 'у' || temCh == 'е' || temCh == 'ы' || temCh == 'а' || temCh == 'о'
						|| temCh == 'я' || temCh == 'и' || temCh == 'ю' || temCh == 'є' || temCh == 'ї'
						|| temCh == 'ё') {
					countVowels++;
				}

			}
			if (maxVowels < countVowels) {
				maxVowels = countVowels;
				maxLine = temporaryLine;
			}
			temporaryLine++;
		}
		sc.close();
		System.out.println("Больше всего гласных (" + maxVowels + ") в строке №" + maxLine);
	}

	public static void readWriteCountSymbols(String filename) throws IOException {
		Scanner sc = new Scanner(System.in);
		String stop = "exit";
		String text = "";
		int countSymbols = 0;
		FileWriter newFile = new FileWriter(filename);

		while (!text.equals(stop)) {

			text = sc.nextLine();
			if (text.equals(stop)) {
				break;
			}
			countSymbols += text.length();

			newFile.write(text + "\n");

		}
		newFile.close();
		sc.close();

		FileReader fr = new FileReader(filename);
		Scanner scan = new Scanner(fr);

		while (scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}

		scan.close();
		fr.close();
		System.out.println("В текстовом файле " + countSymbols + " символов.");
	}
	public static void main(String[] args) throws IOException {
		String path = "D:\\SourceIT\\JavaWS\\SourceIT\\src\\hw8TextEditor.txt";
		readWriteCountSymbols(path);
		wordCount(path);
		maxVowels(path);
		
	}
}