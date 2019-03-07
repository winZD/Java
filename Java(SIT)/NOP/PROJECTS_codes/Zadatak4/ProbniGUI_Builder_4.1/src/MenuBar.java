import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AbstractDocument.Content;

public class MenuBar extends JMenuBar {

	AppFrame frame;

	JMenu fileMenu;
	JMenu edit;

	JMenuItem open;
	JMenuItem saveAs;

	JMenuItem cut;
	JMenuItem copy;
	JMenuItem paste;
	JMenuItem selectAll;

	DataPanel data;

	JFileChooser fileChooser;
	JFrame parent = new JFrame();

	public MenuBar(AppFrame frame) {
		this.frame = frame;

		//setLayout(new BorderLayout());

		createComponents();

		// layoutComponents();
		add(fileMenu);
		add(edit);

		activateFileComponents();

	}

	private void createComponents() {

		fileMenu = new JMenu("File");
		edit = new JMenu("Edit");

		open = new JMenuItem("Open");
		saveAs = new JMenuItem("Save as");
		fileMenu.add(open);
		fileMenu.add(saveAs);

		selectAll = new JMenuItem("Select all");
		copy = new JMenuItem("Copy");
		cut = new JMenuItem("Cut");
		paste = new JMenuItem("Paste");

		edit.add(selectAll);
		edit.add(cut);
		edit.add(copy);

		edit.add(paste);

		fileChooser = new JFileChooser();

		shortcutKey();

	
	}

	// add accelerators and mnemonics
	public void shortcutKey() {
		edit.setMnemonic(KeyEvent.VK_E);
		selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));

	}

	public void layoutComponents() {

	}

	public void activateFileComponents() {

		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {

				try {

					FileNameExtensionFilter docFilter = new FileNameExtensionFilter("txt files", ".txt");
					fileChooser.setFileFilter(docFilter);

					int value = fileChooser.showOpenDialog(parent);

					if (value == JFileChooser.APPROVE_OPTION) {
						// dohvaća selektirani file
						File selectedFile = fileChooser.getSelectedFile();
						// cita file
						Scanner scanner = new Scanner(new BufferedReader(new FileReader(selectedFile)));
						while (scanner.hasNext()) {
							data.textArea.setText(scanner.nextLine() + "\n");
						}
						scanner.close();

					}

				} catch (Exception e) {
					e.printStackTrace();
					data.textArea.setText("ERROR in opening file!");
				}

			}

		});

		saveAs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {

					int value = fileChooser.showSaveDialog(parent);
					if (value == JFileChooser.APPROVE_OPTION) {

						File file = fileChooser.getSelectedFile();

						FileWriter fw = new FileWriter(file);

						String text = data.textArea.getText();
						fw.write(text);
						fw.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
					data.textArea.setText("ERROR in saving file!");
				}

			}
		});

		selectAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.select.execute();

			}
		});

		cut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.cut.execute();

			}
		});
		
		copy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.copy.execute();

			}
		});

		paste.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.paste.execute();

			}
		});

	}
}
