package view;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
* klasa zaduzena za izvrsavanje stop akcije koja zapocinje sa radom pritiskom na gumb stop
* @author ivan
* @since veljaca, 2019.
*/
public class CommandStopSimulation implements Command {

	public ServerFormPanel sFp;
	
	public CommandStopSimulation(ServerFormPanel sFp) {
		this.sFp=sFp;
	}
	
	
	/**
	 *implementirana metoda interface-a Command
	 */
	@Override
	public void execute() {
		
		ServerParkinPanel.startStop=false;
		

	}

}