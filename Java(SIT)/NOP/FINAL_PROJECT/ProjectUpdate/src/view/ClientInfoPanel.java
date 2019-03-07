package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * klasa za postavljanje labela i fieldova
 * @author ivan
 * @since veljaca, 2019.
*/
public class ClientInfoPanel extends JPanel {

	public JLabel connection;
	public JTextField connectionstatusInput;

	public JLabel info;
	public JTextField input;
	


	

	public ClientInfoPanel() {
		setLayout(new GridBagLayout());

		createComponents();
		layoutComponents();
		

	}

	private void createComponents() {
		connection = new JLabel("Connection");
		connectionstatusInput = new JTextField(12);
		connectionstatusInput.setBackground(Color.GREEN);

		info = new JLabel("Free spots");
		input = new JTextField(5);
		
	

		

	}

	private void layoutComponents() {

		GridBagConstraints gbc = new GridBagConstraints();

		

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		add(connection, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.insets = new Insets(5, 5, 5, 5);
		add(connectionstatusInput, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.insets = new Insets(5, 5, 5, 5);
		add(info, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.insets = new Insets(5, 5, 5, 5);
		add(input, gbc);
		
		

		

		

		

	}
}
