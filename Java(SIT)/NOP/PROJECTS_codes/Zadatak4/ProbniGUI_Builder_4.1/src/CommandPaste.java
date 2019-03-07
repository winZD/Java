import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CommandPaste implements Command {

	// MenuBar menu;
	// ScrappingPanel scrappingPanel;
	DataPanel dp;

	public CommandPaste(DataPanel dp) {
		this.dp = dp;
	}

	@Override
	public void execute() {

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable transfer = clipboard.getContents(this);

		try {
			String str = (String) transfer.getTransferData(DataFlavor.stringFlavor);
			dp.textArea.append(str);

		} catch (UnsupportedFlavorException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

}
