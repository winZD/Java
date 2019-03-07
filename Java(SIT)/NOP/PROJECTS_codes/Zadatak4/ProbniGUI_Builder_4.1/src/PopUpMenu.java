import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpMenu extends JPopupMenu {

	public JMenuItem item;

	public DataPanel dp;

	private ActionListener menuLstnr;

	public PopUpMenu() {

		menuLstnr = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evnt) {
				// System.out.println("PopUp menu item <- " + evnt.getActionCommand() + " -> was
				// pressed :)");

				if (evnt.getActionCommand() == "Copy") {
					dp.textArea.copy();

				} else if (evnt.getActionCommand() == "Paste") {
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

				} else if (evnt.getActionCommand() == "Cut") {

					String selection = dp.textArea.getSelectedText();
					StringSelection stringSelection = new StringSelection(selection);

					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(stringSelection, null);

					dp.textArea.replaceSelection("");

				} else if (evnt.getActionCommand() == "Select all") {
					dp.textArea.requestFocus();
					dp.textArea.selectAll();
				}
			}
		};

		popMenuItems();
	}

	public void popMenuItems() {
		item = new JMenuItem("Copy");
		add(item);
		// dodavanje AL-a na prvi item
		item.addActionListener(menuLstnr);

		item = new JMenuItem("Paste");
		add(item);
		item.addActionListener(menuLstnr);

		item = new JMenuItem("Cut");
		add(item);
		item.addActionListener(menuLstnr);

		addSeparator();

		item = new JMenuItem("Select all");
		add(item);
		item.addActionListener(menuLstnr);

	}

}
