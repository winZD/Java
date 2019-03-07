
public class App {

	public static void main(String[] args) {

		WorkerSyncMethods workerSyncMethods = new WorkerSyncMethods();
		WorkerSynchBlocks workerSynchBlocks = new WorkerSynchBlocks();
		WorkerMainThread workerMainThread = new WorkerMainThread();

		for (int i = 0; i < 5; i++) {

			workerSyncMethods.doJob();

		}
		
		/*System.out.println(
				"Average time for ALL SynchMethods(Worker1) job on lists: " + worker1.avg / worker1.cnt + "ms");
		*/
		
		System.out.println();
		for (int i = 0; i < 5; i++) {

			workerSynchBlocks.doJob();

		}
		
		for(int i=0; i<2; i++) {
			workerMainThread.doJob();
		}
	
		
		System.out.println("*****************AVG time for list of 500 elements*****************");
		System.out.println();
		System.out.print("AVG time for SynchBlocks in threads...");
		workerSynchBlocks.printLine();
		
		System.out.println();
		System.out.print("AVG time for SynchMethods in threads...");
		workerSyncMethods.printLine();
		
		System.out.println();
		System.out.print("AVG time for MainThread in threads...");
		workerMainThread.printLine();
	}
	
}
