import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * 
 * klasa koja kreira i ređuje elemente implementira sučelje Action Listener
 * omogućuje funkcionalnost komponenti
 *
 */
public class ToolBar extends JPanel implements ActionListener {
 
	JButton send;
	JButton admin;

	JTextField password;

	DataPanel dp;
	MainFrame2 mf2; 

	/**
	 * kreira vrstu layouta dodaje komponente aktivira komponente
	 */
	public ToolBar() {
		setLayout(new FlowLayout(FlowLayout.RIGHT));

		createComp();

		add(admin);
		add(password);
		add(send);

		activateComp();

	}

	/**
	 * kreira tri objekta
	 */
	public void createComp() {
		send = new JButton("Kupi kartu");
		send.setEnabled(false);

		password = new JTextField(10);
		admin = new JButton("Admin");

	}

	/**
	 * aktivira komponente
	 */
	public void activateComp() {
		send.addActionListener(this);
		admin.addActionListener(this);
	}

	/**
	 * metoda Action Listenera osluškuje događaje komponenti i dodaje im zadatke
	 * otvara 2 popUp prozora i novi dialoški okvir 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == send) {
			JOptionPane.showMessageDialog(send, "Kupili ste kartu za vaše vozilo");

		}

		if (e.getSource() == admin) {

			if (password.getText().equals("admin")) {
				mf2 = new MainFrame2();
				password.setText("");

			} else
				JOptionPane.showMessageDialog(send, "Niste ispravno unijeli lozinku!\nPokušajte ponovno");

		}

	}

}
