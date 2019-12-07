package hw13;

public class FindMax {
	static int[][] matrix;

	public static void main(String[] args) {
		matrix = new FillInMatrix().fillMtr(matrix);

		long current = System.currentTimeMillis();
		int max = new MaxNoMulti().findMaxNoMulti(matrix);
		long delta = System.currentTimeMillis() - current;
		System.out.println("Без многопоточности нашел максимум (" + max + ") за " + delta + " мс");

//		long current2 = System.currentTimeMillis();
//		int max2 = new FindMaxByMulti().maxByMylti(matrix);
//		long delta2 = System.currentTimeMillis() - current2;
//		System.out.println("А с разделением потоков " + max2 +  " нашел за " + delta2 + " мс");
		System.out.println("А с разделением потоков так и не нашел...");

	}
}
