import java.util.ArrayList;
import java.util.List;

public class WorkerSyncMethods {

	private static List<Integer> list1 = new ArrayList<>();

	private static List<Integer> list2 = new ArrayList<>();

	private static Runnable job = new PopulateListJob1(list1, list2);

	// private static Thread thr1 = new Thread(job);

	// private static Thread thr2 = new Thread(job);
	int cnt = 0;
	double avg = 0;

	public WorkerSyncMethods() {

	}

	public void doJob() {

		long start = System.currentTimeMillis();

		Thread thr1 = new Thread(job);
		Thread thr2 = new Thread(job);

		thr1.start();
		thr2.start();
		cnt++;
		try {
			thr1.join();
			thr2.join();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		long stop = System.currentTimeMillis();
		avg += (stop - start) / cnt;

	}

	public void printLine() {
		System.out.println(avg + " ms");
		System.out.println(
				" ____________________________________________________________________________________________________");
	}

}
