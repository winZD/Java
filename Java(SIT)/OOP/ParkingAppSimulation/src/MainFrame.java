
import java.awt.BorderLayout;

/**
 * Glavna klasa koja komunicira
 * sa svim ostalim klasama, i njihovim obilježjima
 */
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	DataPanel dP;
	TextPanel tP;
	ToolBar tB;

	LeftPanel lP; 

	/**
	 * Konstruktor klase MainFrame,sadrži vrstu layouta u njemu kreiramo
	 * komponente,postavljamo raspored komponenata,te ih međusobno povezujemo
	 * postavljamo veličinu,poziciju te vidljivost prozora
	 */ 

	public MainFrame() {
		super("Parking app");
		setLayout(new BorderLayout());

		createComp();
		add(dP, BorderLayout.NORTH);
		add(tP, BorderLayout.CENTER);
		add(tB, BorderLayout.SOUTH);
		add(lP, BorderLayout.WEST);

		tB.dp = dP;

		dP.tp = tP;
		dP.lp = lP;

		dP.tb = tB;

		randomKorisnici();

		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Kreiramo objekte komponenata
	 */
	public void createComp() {
		dP = new DataPanel();
		tP = new TextPanel();
		tB = new ToolBar();
		lP = new LeftPanel();
	}

	/**
	 * Kreiramo određen broj korisnika(zadan u petlji) te ih spremamamo u static
	 * listu tipa korisnik računamo ukupni broj mjesta i karata
	 * 
	 */
	public void randomKorisnici() {

		for (int i = 0; i < 50; i++) {
			Korisnik k = new Korisnik(Korisnik.randomTab(), Korisnik.zonaPark(),
					Korisnik.randomVrijemeDolaska().toString());
			dP.korisnik.add(k);

			int brojac = 0;
			int brojKarata = 0;

			for (Korisnik kor : dP.korisnik) {
				// brojac++;
				brojKarata++;
			}
			int ukupno = DataPanel.brojParkMjesta - dP.korisnik.size();
			String s = Integer.toString(ukupno);

			// String brojK = Integer.toString(dP.korisnik.size());
			String brojK = Integer.toString(brojKarata);

			lP.brojMijesta.setText(s);
			lP.iD.setText(brojK);
		}
	}

}
