package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class CommandSelect implements Command {

	TextPanel dp;
	// MenuBar menu;
	// ScrappingPanel scrappingPanel;

	public CommandSelect(TextPanel dp) {
		this.dp = dp;
	}

	@Override
	public void execute() {

		dp.textArea.requestFocusInWindow();
		dp.textArea.selectAll();

	}

}
