import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * Kreira i uređuje komponente postavljene u nevedenom panelu
 * 
 * @author ivan
 *
 */
public class LeftPanel extends JPanel {

	JLabel vrijemeDolaska;
	JTextField dolazak;
 
	JLabel ID; 
	JTextField iD;

	JLabel mijesta;
	JTextField brojMijesta;
	


	/**
	 * Konstruktor klase koji deklarira vrstu layouta,dimenzije i poziva metode
	 * kojima kreira komponente i bordere
	 */
	public LeftPanel() {
		setLayout(new GridBagLayout());

		Dimension dim = getPreferredSize();
		dim.width = 150;
		setPreferredSize(dim);

		createComp();
		createLayout();
		setBorders();

	}

	/**
	 * metoda koja kreira objekte komponenata
	 */
	public void createComp() {

		vrijemeDolaska = new JLabel("Vrijeme dolaska:");
		dolazak = new JTextField(11);
		dolazak.setEditable(false);

		ID = new JLabel("ID karte:");
		iD = new JTextField(11);
		iD.setEditable(false);

		mijesta = new JLabel("Slobodna mjesta:");
		brojMijesta = new JTextField(11);
		brojMijesta.setEditable(false);
	}

	/**
	 * kreira layout i dodaje komponente u layout
	 */
	public void createLayout() {

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.weightx = 1;
		gbc.weighty = 1;

		gbc.gridx = 0;
		gbc.gridy = 0;
		add(vrijemeDolaska, gbc);

		gbc.gridy++;
		add(dolazak, gbc);

		gbc.gridy++;
		add(ID, gbc);

		gbc.gridy++;
		add(iD, gbc);

		gbc.gridy++;
		add(mijesta, gbc);

		gbc.gridy++;
		add(brojMijesta, gbc);

	}

	/**
	 * kreira bordere prozora
	 */
	public void setBorders() {
		Border inner = BorderFactory.createTitledBorder("");
		Border outer = BorderFactory.createEmptyBorder(20, 10, 20, 10);

		setBorder(BorderFactory.createCompoundBorder(outer, inner));

	}

}
