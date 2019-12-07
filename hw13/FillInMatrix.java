package hw13;

import java.util.Random;

public class FillInMatrix {
	public int[][] fillMtr(int[][] matrix) {
		matrix = new int[4][100];
		Random random = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = random.nextInt(10000);
			}
		}
		return matrix;
	}
}
