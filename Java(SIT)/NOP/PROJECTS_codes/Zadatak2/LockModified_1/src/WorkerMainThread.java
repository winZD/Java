import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkerMainThread {

	private static List<Integer> list1 = new ArrayList<>();
	private static List<Integer> list2 = new ArrayList<>();
	private Random randomGenerateNum = new Random();
	int cnt = 0;
	double avg = 0;

	public WorkerMainThread() {

	}

	public void doJob() {

		// System.out.println("***************** main thread in action
		// *******************");
		long start = System.currentTimeMillis();
		for (int k = 1; k <= 250; k++) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(randomGenerateNum.nextInt(100));
			list2.add(randomGenerateNum.nextInt(100));
			cnt++;

		}
		long stop = System.currentTimeMillis();
		avg += (stop - start) / cnt;

	}

	public void printLine() {
		System.out.println(avg + " ms");

		System.out.println(
				" ___________________________________________________________________________________________________ ");
	}

}
