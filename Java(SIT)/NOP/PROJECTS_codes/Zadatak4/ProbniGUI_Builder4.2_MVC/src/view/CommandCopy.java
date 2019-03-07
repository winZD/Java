package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandCopy implements Command {

	// MenuBar menu;
	// ScrappingPanel scrappingPanel;

	TextPanel dp;

	public CommandCopy(TextPanel dp) {
		this.dp = dp;
	}

	@Override
	public void execute() {

		dp.textArea.copy();
		// scrappingPanel.sRight.clearView.setEnabled(true);

	}

}
