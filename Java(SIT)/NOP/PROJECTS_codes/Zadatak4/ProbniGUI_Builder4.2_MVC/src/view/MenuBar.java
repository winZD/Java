package view;

import java.awt.event.ActionEvent;
import model.Database;
import model.WebText;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

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

	JMenuItem undo;
	JMenuItem redo;

	TextPanel data;

	JFileChooser fileChooser = new JFileChooser();

	public JButton previous;
	JButton next;

	JFrame parent = new JFrame();
	static int currentIndex = 0;

	public MenuBar(AppFrame frame) {
		this.frame = frame;

		// setLayout(new BorderLayout());

		createComponents();

		// layoutComponents();
		add(fileMenu);
		add(edit);

		add(previous);
		add(next);

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

		undo = new JMenuItem("Undo");
		redo = new JMenuItem("Redo");

		previous = new JButton("Previous");
		previous.setEnabled(false);
		next = new JButton("Next");
		next.setEnabled(false);

		edit.add(selectAll);
		edit.add(cut);
		edit.add(copy);

		edit.add(undo);
		edit.add(redo);

		edit.addSeparator();

		edit.add(paste);

		// fileChooser = new JFileChooser();

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

					ArrayList<String> records = new ArrayList<String>();

					if (value == JFileChooser.APPROVE_OPTION) {
						// dohvaća selektirani file
						File selectedFile = fileChooser.getSelectedFile();
						// cita file
						FileReader fr = new FileReader(selectedFile);

						BufferedReader reader = new BufferedReader(fr);
						String line;
						while ((line = reader.readLine()) != null) {
							records.add(line);
						}

						reader.close();
						frame.dataPanel.textArea.setText(records.toString());

					}

				} catch (Exception e) {
					e.printStackTrace();

				}

			}

		});

		saveAs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("txt datoteke", ".txt"));
					int value = fileChooser.showSaveDialog(parent);

					if (value == JFileChooser.APPROVE_OPTION) {
						File file = fileChooser.getSelectedFile();

						FileWriter fw = new FileWriter(file);
						String text = frame.controller.database.toString();
						fw.write(text);
						fw.close();
					}

				} catch (Exception e) {
					e.printStackTrace();

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

		undo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.undo.execute();

			}
		});

		redo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.redo.execute();

			}
		});

		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				currentIndex--;
				// System.out.println(count);
				frame.dataPanel.textArea.setText(frame.controller.database.list.get(currentIndex).toString());
				// frame.dataPanel.textArea.setText(frame.database.list.get(currentIndex).toString());
				// System.out.println(frame.database.list.get(count).toString());
				// System.out.println("brojac--" + currentIndex);
				next.setEnabled(true);
				if (currentIndex == 0) {
					previous.setEnabled(false);
				}

			}
		});

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				currentIndex++;
				// System.out.println("brojac"+count);

				frame.dataPanel.textArea.setText(frame.controller.database.list.get(currentIndex).toString());

				// frame.dataPanel.textArea.setText(frame.database.list.get(currentIndex).toString());
				previous.setEnabled(true);
				if (currentIndex == frame.controller.database.list.size() - 1) {
					next.setEnabled(false);
				}

			}
		});

	}

	public void enablePreviousButton() {
		previous.setEnabled(true);
	}

}
