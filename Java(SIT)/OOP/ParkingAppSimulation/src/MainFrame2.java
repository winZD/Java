import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * povezuje objekte dva objekta jedan sa drugim te kreira novi frame
 * 
 *
 *
 */
public class MainFrame2 extends JFrame {

	TextPanel2 tP2;

	LeftPanel2 lP2;
  
	/**
	 * Konstruktor klase MainFrame2,sadrži vrstu layouta u njemu kreiramo
	 * komponente,postavljamo raspored komponenata,te ih međusobno povezujemo
	 * postavljamo veličinu,poziciju te vidljivost prozora povezuje objekt lP2 sa
	 * objektom tP2
	 */
	public MainFrame2() {
		super("Admin's app");
		setLayout(new BorderLayout());

		createComp();

		add(tP2, BorderLayout.CENTER);
		add(lP2, BorderLayout.WEST);

		lP2.tp2 = tP2;

		setSize(500, 300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	/**
	 * kreira dva objekta
	 */
	public void createComp() {
		tP2 = new TextPanel2();
		lP2 = new LeftPanel2();
	}

}
