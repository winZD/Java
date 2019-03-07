package view;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
/**
 * klasa zaduzena za izvrsavanje cut paste koja zapocinje sa radom pritiskom na gumb Cut
 * @author ivan
 * @since veljaca, 2019.
 */
public class CommandCut implements Command {

	public ServerFormPanel sFp;
	
	public CommandCut(ServerFormPanel sFp) {
		
		this.sFp=sFp;
	
	}
	
	/**
	 * implementirana metoda interface Command
	 */
	@Override
	public void execute() {
		
		String selection = sFp.sEp.miniTextArea.getSelectedText();
		StringSelection stringSelection = new StringSelection(selection);

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		sFp.sEp.miniTextArea.replaceSelection("");
		

	}

}
