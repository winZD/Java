package view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
/**
 * klasa za kreiranje textualnog panela te aktiviranje simulacije
 * @author ivan
 * @since veljaca, 2019.
 */
public class ServerTextPanel extends JPanel {

	public JTextArea textArea;
	
	public JScrollPane scrollPane;

	public JButton bot;

	
	
	ServerParkinPanel spp;
	
	public void setSPP(ServerParkinPanel spp) {
		this.spp=spp;
	}
	
	public ServerTextPanel() {

		setLayout(new BorderLayout());

		createComponents();
		setBorders();
	}

	public void createComponents() {
		textArea = new JTextArea(30,30);
		textArea.setEditable(false);
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, BorderLayout.CENTER);
		
		
		bot = new JButton("Run simulation");
		
		
		
		bot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ServerParkinPanel.startStop=true;
				
				spp.startSimulation();
			}
		});

		add(bot, BorderLayout.SOUTH);

	}

	private void setBorders() {

		Border inner = BorderFactory.createTitledBorder("Parking spot info");
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		setBorder(BorderFactory.createCompoundBorder(outer, inner));
	}

}
