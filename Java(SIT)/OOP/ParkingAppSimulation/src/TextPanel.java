import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
/**
 * sadrži područje za pisanje teksta
 * 
 *
 */
public class TextPanel extends JPanel {

	JTextArea textArea;
 
	/**
	 * Konstruktor klase koji deklarira vrstu layouta,dimenzije i poziva metode
	 * kojima kreira komponente i bordere
	 */
	public TextPanel() {
		setLayout(new BorderLayout());
 
		Dimension dim = getPreferredSize();
		dim.height = 100;
		setPreferredSize(dim);

		createComp();

		setBorders();

		add(textArea);
		add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
	}
/**
 * kreira dva objekta
 */
	public void createComp() {
		textArea = new JTextArea();
		textArea.setEditable(false);
	}

	/**
	 * kreira bordere
	 */
	public void setBorders() {
		Border inner = BorderFactory.createTitledBorder("");
		Border outer = BorderFactory.createEmptyBorder(20, 10, 20, 10);

		setBorder(BorderFactory.createCompoundBorder(outer, inner));

	}

}
