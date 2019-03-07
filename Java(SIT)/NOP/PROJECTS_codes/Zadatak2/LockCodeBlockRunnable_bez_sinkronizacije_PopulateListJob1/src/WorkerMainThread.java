import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkerMainThread {

	private static List<Integer> list1 = new ArrayList<>();
	private static List<Integer> list2 = new ArrayList<>();
	private Random random = new Random();

	public void doJob() {
		int cnt = 0;
		double avg = 0;

		for (int k = 1; k <= 500; k++) {
			System.out.println("***************** main thread in action *******************");
			long start = System.currentTimeMillis();

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
			list2.add(random.nextInt(100));
			cnt++;
			long stop = System.currentTimeMillis();
			avg += (stop - start);
			System.out.println("Elapsed time: " + (stop - start) + " ms");
			System.out.println("List1: " + list1.size() + "\t List2: " + list2.size());
			System.out.println("Average time for ALL SynchMethods job on lists: " + avg / cnt + "ms");
			System.out.println(" ----------------------------------------------------- ");

		}
	}
}
