package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * klasa odgovorna za postavljanje menu bara i njegovu funkcionalost
 * @author ivan
 * @since veljaca, 2019.
 */
public class MenuBar extends JMenuBar {

	public JMenu fileMenu=new JMenu("File");
	public JMenuItem open=new JMenuItem("Open");
	public JMenuItem saveAs=new JMenuItem("Save as");
	
	JFileChooser fileChooser = new JFileChooser();
	JFrame parent = new JFrame();

	ServerFrame frame;
	
	public MenuBar(ServerFrame frame) {
		
		this.frame=frame;
		
		add(fileMenu);
		fileMenu.add(open);
		fileMenu.addSeparator();
		fileMenu.add(saveAs);
		
		activateComponents();
		
	}
	
		
	/**
	 * metoda koja aktivira open i savAs naredbu u menu baru
	 */
	
	public void activateComponents() {
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {FileNameExtensionFilter docFilter = new FileNameExtensionFilter("txt files", ".txt");
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
						records.add(line+"\n");
					}

					reader.close();
					
					frame.control.conFrame.sFp.sEp.miniTextArea.setText(records.toString());

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
						String textSave = frame.sFp.sTp.textArea.getText();
						frame.control.database.data.add(textSave);
						fw.write(textSave);
						fw.close();
					}

				} catch (Exception e) {
					e.printStackTrace();

				}

			}

		});

	}
}
