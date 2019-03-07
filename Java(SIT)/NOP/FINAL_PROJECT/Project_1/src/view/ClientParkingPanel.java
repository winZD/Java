package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * ClientParkingPanel formira broj botuna na panelu,te mijenja njihovo
 * stanje(odnosno boju) i dimenzije
 * 
 * @author ivan
 * @since veljaca, 2019.
 */
public class ClientParkingPanel extends JPanel {

	ArrayList<JButton> botuniCLient;

	private String msg;
	private PrintWriter pwr;
	public int counterFree = 60;

	public ArrayList<Integer> count = new ArrayList<>();

	public ClientParkingPanel() {
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(300, 400));
		createComponents();

	}

	public String getMessage() {

		return msg;
	}

	public void setPrintWriter(PrintWriter writer) {
		this.pwr = writer;
	}

	/**
	 * kreiranje arrayliste i botuna koje spremamo u arrayListu
	 */
	private void createComponents() {
		botuniCLient = new ArrayList<>();

		for (int i = 0; i < 60; i++) {
			JButton botun = new JButton("");
			botun.setIcon(new ImageIcon("Icons/parkingSpot.png"));
			botun.setPreferredSize(new Dimension(50, 50));
			botun.setBackground(Color.GREEN);
			add(botun);

			botuniCLient.add(botun);

		}

	}

	/**
	 * mijenjanje statusa botuna,te aktiviranje brojaca stanja botuna
	 * 
	 * @param msg
	 */
	public void changeClientButtonState(String msg) {

		JButton botun = botuniCLient.get(Integer.parseInt(msg));

		if (botun.getBackground() == Color.GREEN) {
			botun.setBackground(Color.RED);
			counterFree--;

		} else {
			botun.setBackground(Color.GREEN);
			counterFree++;
		}

	}

}
