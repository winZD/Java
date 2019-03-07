import java.util.List;
import java.util.Random;

public class PopulateListJob2 implements Runnable {
	private List<Integer> list1;
	private List<Integer> list2;
	private Random random;

	public PopulateListJob2(List<Integer> lst1, List<Integer> lst2) {
		this.list1 = lst1;
		this.list2 = lst2;
		random = new Random();

	}
	
	

	public void run() {
		for (int k = 1; k <= 500; k++) {
			populateLst1();
			populateLst2();
		}

	}

	private void populateLst1() {
		synchronized (list1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.list1.add(random.nextInt(100));
		}
	}

	private void populateLst2() {

		synchronized (list2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.list2.add(random.nextInt(100));
		}
	}

}
