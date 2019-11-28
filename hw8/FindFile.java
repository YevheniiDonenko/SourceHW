package hw8;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class FindFile {
	static int countJavaFiles = 0;

	public static void findFiles(String path, String fileExtension) {

		StringBuilder allFiles = new StringBuilder();

		File listFile = new File(path);
		File exportFiles[] = listFile.listFiles();
		for (int i = 0; i < exportFiles.length; i++) {
			if (exportFiles[i].toString().endsWith(fileExtension)) {
				countJavaFiles++;
				allFiles.append(exportFiles[i].getName() + "\n");
			}
			if (exportFiles[i].isDirectory()) {
				String directory = exportFiles[i].toString();
				findFiles(directory, fileExtension);
			}

		}

		System.out.println(allFiles);
	}

	public static void main(String[] args) {

		System.out.println("Где будем искать файлы?");
		Scanner sc = new Scanner(System.in);
		String findFilesHere = sc.nextLine();
		System.out.println("Файлы с каким расширением будем искать?");
		String findThisFiles = sc.nextLine();
		findFiles(findFilesHere, findThisFiles);
		sc.close();
		System.out.println(
				"В директории " + findFilesHere + " находится " + 
				countJavaFiles + " " + findThisFiles + " файла.");
	}



}
