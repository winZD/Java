import java.awt.Toolkit;

import javax.swing.SwingWorker;

public class Task extends SwingWorker<Void, Void> {
	ScrappingLeft left;

	@Override
	protected Void doInBackground() throws Exception {

		int pr = 10;
		int val = 0;

		while (val < 100) {
			Thread.sleep(300);
			val += pr;
			left.progress.setValue(val);
			 left.progress.setStringPainted(true);
			//System.out.println("< -" + val + " ->");
		}

		return null;
	}

	@Override
	protected void done() {
		//System.out.println("Done method is executing...");
		Toolkit.getDefaultToolkit().beep();

		left.show.setEnabled(true);
	}

}
