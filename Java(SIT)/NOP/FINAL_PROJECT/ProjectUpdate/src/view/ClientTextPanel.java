package view;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
/**
 * Klasa koja kreira textualno područje 
 * @author ivan
 * @since veljaca, 2019.
 */
public class ClientTextPanel extends JPanel{
	
	public JTextArea tArea;
	public JScrollPane scp;
	
	
	public ClientTextPanel() {
		
		
		setLayout(new BorderLayout());
		
		
		Dimension dim = getPreferredSize();
		
		dim.width=150;
		dim.height=150;
		setPreferredSize(dim);
		
		createComponents();
		
		setBorders();
		
		
	

	}

	private void createComponents() {
		tArea=new JTextArea();
		tArea.setEditable(false);
		
		
		scp = new JScrollPane(tArea);
		scp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scp, BorderLayout.CENTER);
		
		
		
	}
	
	private void setBorders() {

		Border inner = BorderFactory.createTitledBorder("Parking info panel");
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		setBorder(BorderFactory.createCompoundBorder(outer, inner));
	}
}
