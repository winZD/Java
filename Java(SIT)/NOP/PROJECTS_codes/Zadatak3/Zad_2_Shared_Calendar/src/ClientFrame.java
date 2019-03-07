
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.ScrollPaneConstants;

public class ClientFrame extends JFrame {
	private JTextField pocetak;
	private JTextField naslov;
	private JTextField kraj;
	private JTextField opis;
	private JTextField mjesto;
	private JTextField datumVrijeme;
	JTextArea textArea;
	JButton btnKreirajDogadaj;
	Date date;
	DateFormat dateFormat;
	private PrintWriter pwr;
	private JScrollPane scp;
	String vrijemeSpajanjaServer;
	private JScrollPane scrollPane;
	String objava;

	public ClientFrame() {
		getContentPane().setLayout(null);

		JLabel lblPocetakDogadaja = new JLabel("Početak događaja");
		lblPocetakDogadaja.setBounds(65, 55, 112, 33);
		getContentPane().add(lblPocetakDogadaja);

		JLabel lblKrajDogadaja = new JLabel("Kraj događaja");
		lblKrajDogadaja.setBounds(431, 59, 104, 24);
		getContentPane().add(lblKrajDogadaja);

		JLabel lblNaslov = new JLabel("Naslov");
		lblNaslov.setBounds(255, 59, 104, 24);
		getContentPane().add(lblNaslov);

		pocetak = new JTextField();
		pocetak.setBounds(65, 84, 112, 24);
		getContentPane().add(pocetak);
		pocetak.setColumns(10);

		naslov = new JTextField();
		naslov.setBounds(431, 84, 104, 24);
		getContentPane().add(naslov);
		naslov.setColumns(10);

		kraj = new JTextField();
		kraj.setBounds(255, 84, 117, 24);
		getContentPane().add(kraj);
		kraj.setColumns(10);

		JLabel lblOpisDogadaja = new JLabel("Opis događaja:");
		lblOpisDogadaja.setBounds(65, 155, 104, 14);
		getContentPane().add(lblOpisDogadaja);

		opis = new JTextField();
		opis.setBounds(65, 173, 104, 24);
		getContentPane().add(opis);
		opis.setColumns(10);

		mjesto = new JTextField();
		mjesto.setBounds(255, 173, 104, 24);
		getContentPane().add(mjesto);
		mjesto.setColumns(10);

		JLabel lblMjestoDogadaja = new JLabel("Mjesto događaja");
		lblMjestoDogadaja.setBounds(255, 155, 104, 14);
		getContentPane().add(lblMjestoDogadaja);

		JLabel lblDatumvrijeme = new JLabel("Datum/vrijeme:");
		lblDatumvrijeme.setBounds(431, 155, 104, 14);
		getContentPane().add(lblDatumvrijeme);

		datumVrijeme = new JTextField();
		datumVrijeme.setBounds(431, 175, 117, 22);
		getContentPane().add(datumVrijeme);
		datumVrijeme.setColumns(10);
		datumVrijeme.setEditable(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(41, 245, 525, 253);
		getContentPane().add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		//textArea.setBorder(BorderFactory.createCompoundBorder(outer, inner));

		btnKreirajDogadaj = new JButton("Kreiraj događaj");
		btnKreirajDogadaj.setBounds(215, 509, 124, 33);
		getContentPane().add(btnKreirajDogadaj);

		// Borders for panels
		
		Border outer = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		Border inner = BorderFactory.createTitledBorder("");
		
		

		setDate();
		activateButton();
		setSize(600, 600);
		setResizable(false);
		setVisible(true);
	}

	public void setDate() {
		date = new Date();
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		datumVrijeme.setText(dateFormat.format(date));
		vrijemeSpajanjaServer = datumVrijeme.getText();
		
		
	}

	public void setPrintWriter(PrintWriter writer) {
		this.pwr = writer;
	}

	public void activateButton() {

		btnKreirajDogadaj.addActionListener(new ActionListener() {
			String podaci = null;
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				date = new Date();
				dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				objava= dateFormat.format(date);
				
				if(pocetak.getText().isEmpty()|| naslov.getText().isEmpty()|| opis.getText().isEmpty()) {
					
					 JFrame frame = new JFrame("Information");
					JOptionPane.showMessageDialog(frame, "Popunite sva polja!");
				}
				else {
				podaci = "Početak:" + pocetak.getText() + "\n" + "Naslov:" + naslov.getText() + "\nKraj događaja:"
						+ kraj.getText() + "\nOpis:" + opis.getText() + "\nPočetak pisanja priče:"
						+ datumVrijeme.getText()+"\nKraj pisanja priče:"+objava;

				pwr.println(podaci);
				pwr.flush();
				pwr.println(" ________________________________________________________________");
				pwr.flush();

				btnKreirajDogadaj.setBackground(Color.GREEN);
				}
			}
		});

	}

	public void writeTxt(String string) {
		textArea.append("******************************************\n");
		textArea.append(string);
		textArea.append("\n");
		textArea.append("******************************************\n");
	}

	public void writeReceivedMessage(String msg) {
		textArea.append(msg);
		textArea.append("\n");
	}
}
