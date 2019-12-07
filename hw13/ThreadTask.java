package hw13;

public class ThreadTask {
	static ThreadTwo thrByRun;
	static ThreadOne thrByEx;

	public static void main(String[] args) throws InterruptedException {
		thrByRun = new ThreadTwo();
		Thread thread2 = new Thread(thrByRun);
		thread2.start();
		thrByEx = new ThreadOne();
		thrByEx.start();

	}
}

class ThreadTwo implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Я runnable " + Thread.currentThread().getName());
		}
	}
}

class ThreadOne extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Я наследник " + Thread.currentThread().getName());
		}
	}
}
