package hw13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FindMaxByMulti {

	public int maxByMulti(int[][] matrix) {
		int max = 0;
		ExecutorService executorService = Executors.newFixedThreadPool(matrix.length);
		List<Callable<Integer>> taskList = new ArrayList<Callable<Integer>>();

		for (int i = 0; i < matrix.length; i++) {
			taskList.add(get(matrix[i]));
		}

		try {
			List<Future<Integer>> futures = executorService.invokeAll(taskList);
			for (Future<Integer> future : futures) {
				int result = Integer.parseInt(future.get().toString());
				if (result > max)
					max = result;
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return max;

	}

	public Callable<Integer> get(int[] value) {

		return () -> {
			int localMax = 0;
			for (int i = 0; i < value.length; i++) {
				if (value[i] > localMax)
					localMax = value[i];
			}
			return localMax;
		};
	}

}