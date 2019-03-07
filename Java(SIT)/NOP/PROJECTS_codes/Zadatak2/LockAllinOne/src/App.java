import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App extends Thread {

	public static void main(String[] args) throws InterruptedException {
		Thread my = new App();
		// Thread my2=new App();

		my.start();
		// my2.start();
		try {
			my.join();
			// my2.join();
		} catch (Exception e) {

		}

	}
	
	public void doJob() {

		for (int k = 1; k <= 500; k++) {

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				System.out.println("Error in doJob()");
			}
			list1.add(random.nextInt(100));
			list2.add(random.nextInt(100));
			

		}
	}

	@Override
	public void run() {

		long start = System.currentTimeMillis();
		System.out.println("***************** Threads - SynchMethods job on lists *******************");
		populateList1();
		populateList2();
		System.out.println("List1: " + list1.size() + "\t List2: " + list2.size());
		long stop = System.currentTimeMillis();
		System.out.println("Elapsed time: " + (stop - start) + " ms");
		System.out.println(" _______________________________________________________________________________ ");
		list1.clear();// čisti listu
		System.out.println();
		list2.clear();
		System.out.println();

		
		

		long start2 = System.currentTimeMillis();
		System.out.println("***************** Threads - SynchCodeBlocks job on lists *******************");
		populateList3();
		populateList4();
		System.out.println("List1: " + list1.size() + "\t List2: " + list2.size());
		long stop2 = System.currentTimeMillis();
		System.out.println("Elapsed time: " + (stop2 - start2) + " ms");
		System.out.println();
		System.out.println();

		list1.clear();// čisti listu
		list2.clear();

		long start3 = System.currentTimeMillis();
		
		System.out.println("***************** main thread in action *******************");
		
		App app = new App();
		
		app.doJob();// običan thread
		
		long stop3 = System.currentTimeMillis();
		
		System.out.println("Elapsed time: " + (stop3 - start3) + " ms");
		System.out.println("List1: " + list1.size() + "\t List2: " + list2.size());
		System.out.println(" _____________________________________________________________________________ ");
	}

	private static List<Integer> list1 = new ArrayList<>();

	private static List<Integer> list2 = new ArrayList<>();


	private Random random = new Random();

	private synchronized void populateList1() {
		for (int k = 1; k <= 500; k++) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				System.out.println("Error in populateList1");
			}

			this.list1.add(random.nextInt(100));
		}
	}

	private synchronized void populateList2() {
		for (int k = 1; k <= 500; k++) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				System.out.println("Error in populateList2");
			}

			this.list2.add(random.nextInt(100));
		}
	}

	private void populateList3() {
		synchronized (list1) {
			for (int k = 1; k <= 500; k++) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					System.out.println("Error in populateList3");
				}

				this.list1.add(random.nextInt(100));
			}
		}
	}

	private void populateList4() {

		synchronized (list2) {
			for (int k = 1; k <= 500; k++) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					System.out.println("Error in populateList4");
				}
				this.list2.add(random.nextInt(100));
			}
		}
	}

	
}
