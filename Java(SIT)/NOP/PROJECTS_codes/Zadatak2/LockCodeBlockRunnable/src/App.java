import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

	public static void main(String[] args) {

		WorkerSyncMethods workerSynchMethod = new WorkerSyncMethods();
		WorkerSynchBlocks workerSynchBlocks = new WorkerSynchBlocks();
		WorkerMainThread workerMainThread = new WorkerMainThread();
		
		
		workerSynchBlocks.doJob();
		workerSynchMethod.doJob();
		workerMainThread.doJob();
		
		

	}

}
