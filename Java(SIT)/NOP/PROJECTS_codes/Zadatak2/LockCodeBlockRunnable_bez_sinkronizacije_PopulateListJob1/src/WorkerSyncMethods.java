import java.util.ArrayList;
import java.util.List;

public class WorkerSyncMethods {

	private static List<Integer> list1 = new ArrayList<>();
	
	private static List<Integer> list2 = new ArrayList<>();
	
	private static Runnable job = new PopulateListJob1(list1, list2);
	
	// private static Thread thr1 = new Thread(job);
	
	// private static Thread thr2 = new Thread(job);

	public void doJob() {
		int cnt=0;
		double avg=0;
		for(int i=0; i<50; i++) {
		System.out.println("***************** Threads - SynchMethods job on lists *******************");
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
		avg+=(stop -start);
		System.out.println("Elapsed time: " + (stop - start) + " ms");
		System.out.println("Average time for ALL SynchMethods job on lists: "+avg/cnt+"ms");
		
		System.out.println("List1: " + list1.size() + "\t List2: " + list2.size());
		System.out.println(" ------------------------------------------------------------------- ");
		System.out.println(cnt);
	}
	}
}
