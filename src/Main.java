
public class Main {
	synchronized void Count() {
		for (int i = 0; i < 50000; i++) {
			if (i == 25000) {
				try {
					wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.print(i + " ");
			}
		}
	}

	synchronized void Running() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Running...");

		}
		notify();
	}

	public static void main(String[] args) {
		Main a = new Main();
		Thread t1 = new Thread() {
			public void run() {
				a.Count();
			}
		};
		t1.start();
		new Thread() {
			public void run() {
				a.Running();
			}
		}.start();
	}
}