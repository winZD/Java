import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class DataPanel extends JPanel {

	public JTextArea textArea;
	public JScrollPane scrollPane;
	
	PopUpMenu pop;
	
	
	public DataPanel() {
		
		pop=new PopUpMenu();
		
		
		setLayout(new BorderLayout());

		createComponents();
		layoutComponents();
		
		
		
		Dimension dims = getPreferredSize();
		dims.width = 300;
		dims.height = 450;
		setPreferredSize(dims);

		Border outer = BorderFactory.createEmptyBorder(1, 1, 1, 1);
		Border inner = BorderFactory.createTitledBorder("");
		Border cmpBrd = BorderFactory.createCompoundBorder(outer, inner);

		textArea.setBorder(cmpBrd);
		
		textArea.addMouseListener(new MousePopUpListener(pop));
	}

	private void createComponents() {

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);

		scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
	}

	public void layoutComponents() {

		add(scrollPane, BorderLayout.CENTER);

	}


}
