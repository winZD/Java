package view;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * klasa zadužena za stvaranje textualnog panela i panela za editiranje
 * @author ivan
 * @since veljaca, 2019.
 */
public class ServerFormPanel extends JPanel {
	
	ServerTextPanel sTp;
	
	ServerEditPanel sEp;
	
	ServerFrame frame;
	
	
	public ServerFormPanel(ServerFrame frame) {
		
		this.frame=frame;
		
		setLayout(new BorderLayout());
		
		Dimension dim = getPreferredSize();
		dim.height = 300;
		//dim.width=200;
		setPreferredSize(dim);
		
		createComponents();
		layoutComponents();
		
	}

	private void createComponents() {
		
		sTp=new ServerTextPanel();
		sEp=new ServerEditPanel(this);
		
		
	}

	private void layoutComponents() {
		add(sTp,BorderLayout.CENTER);
		add(sEp,BorderLayout.EAST);
		
	}

}
