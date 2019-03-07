import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ServerSendPanel extends JPanel {
	
	public JTextField text;
	
	public JButton send;
	
	
	public ServerSendPanel() {
		
		setLayout(new GridBagLayout());
		
		
		createComponents();
		
		layoutComponents();
	
	}

	private void layoutComponents() {
		
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.weightx = 0.1;
		gbc.weighty = 0.1;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		add(text, gbc);
		
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		add(send, gbc);
	}


	private void createComponents() {
		text=new JTextField(20);
		
		send=new JButton("send");
		
	}

}
