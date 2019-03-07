package view;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
* klasa zaduzena za izvrsavanje paste akcije koja zapocinje sa radom pritiskom na gumb Paste
* @author ivan
* @since veljaca, 2019.
*/
public class CommandPaste implements Command {

	public ServerFormPanel sFp;
	
	public CommandPaste(ServerFormPanel sFp) {
		this.sFp=sFp;
	}
	
	
	/**
	 *implementirana metoda interface-a Command
	 */
	@Override
	public void execute() {
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable transfer = clipboard.getContents(this);

		try {
			String str = (String) transfer.getTransferData(DataFlavor.stringFlavor);
			sFp.sEp.miniTextArea.append(str);

		} catch (UnsupportedFlavorException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

}
