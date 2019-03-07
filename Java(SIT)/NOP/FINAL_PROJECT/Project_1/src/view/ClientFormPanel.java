package view;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * 
 * klasa za kreiranje textualnog i info panela
 * formira layoute i velicinu komponenti
 * @author ivan
 * @since veljaca, 2019.
 */
public class ClientFormPanel extends JPanel{
	
	public ClientTextPanel cTp=new ClientTextPanel();
	public ClientInfoPanel cIp=new ClientInfoPanel();
	
	
	public ClientFormPanel() {
		setLayout(new BorderLayout());
		
		setPreferredSize(new Dimension(300, 150));
		
		createLayout();
	
	}
		

	private void createLayout() {
		add(cTp,BorderLayout.CENTER);
		add(cIp,BorderLayout.EAST);
		
	}

	

}
