
public class App {

	public static void main(String[] args) {

		

		WorkerSyncMethods worker1 = new WorkerSyncMethods();
		WorkerSynchBlocks worker2 = new WorkerSynchBlocks();
		WorkerMainThread worker3 = new WorkerMainThread();
		
	
		worker1.doJob();
		
		//worker2.doJob();

	}
}
