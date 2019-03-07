import java.util.List;
import java.util.Random;

public class PopulateListJob1 implements Runnable {

	private Random randomGenerateNum;
	
	private List<Integer> list1;
	private List<Integer> list2;
	

	public PopulateListJob1(List<Integer> lst1, List<Integer> lst2) {
		this.list1 = lst1;
		this.list2 = lst2;
		
		randomGenerateNum = new Random();

	}

	public void run() {
		for (int k = 1; k <= 2000; k++) {
			populateLst1();
			populateLst2();
		}

	}

	private synchronized void populateLst1() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.list1.add(randomGenerateNum.nextInt(100));
	}

	private synchronized void populateLst2() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in populateListJob1");
		}

		this.list2.add(randomGenerateNum.nextInt(100));

	}
}

