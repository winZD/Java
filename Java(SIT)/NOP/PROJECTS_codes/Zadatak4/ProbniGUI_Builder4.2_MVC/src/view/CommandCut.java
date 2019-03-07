package view;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandCut implements Command {

	// MenuBar menu;
	// ScrappingPanel scrappingPanel;

	TextPanel dp;

	public CommandCut(TextPanel dp) {
		this.dp = dp;
	}

	@Override
	public void execute() {

		String selection = dp.textArea.getSelectedText();
		StringSelection stringSelection = new StringSelection(selection);

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		dp.textArea.replaceSelection("");

	}

}
