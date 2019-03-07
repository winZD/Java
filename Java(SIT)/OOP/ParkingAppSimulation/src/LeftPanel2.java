import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Upisuje, šalje i računa podatke o korisnicima, implementira sučelje
 * 
 * @author ivan
 *
 */
public class LeftPanel2 extends JPanel implements ActionListener {

	JButton upis;
	JButton salji;
	JButton statistics;

	TextPanel2 tp2; 
 
	/**
	 * Konstruktor klase koji deklarira vrstu layouta,dimenzije i poziva metode
	 * kojima kreira komponente i bordere
	 */
	public LeftPanel2() {
		setLayout(new GridBagLayout());

		Dimension dim = getPreferredSize();
		dim.width = 150;
		setPreferredSize(dim);

		createComp();
		createLayout();
		setBorders();
		activateComp();

	}

	/**
	 * kreira tri objekta
	 */
	public void createComp() {
		salji = new JButton("Šalji");
		upis = new JButton("Upiši u datoteku");
		statistics = new JButton("Statistika");

	}

	/**
	 * kreira layout i dodaje komponente u layout
	 */
	public void createLayout() {

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.weightx = 1;
		gbc.weighty = 1;

		gbc.gridx = 0;
		gbc.gridy = 0;
		add(salji, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		add(upis, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		add(statistics, gbc);
	}

	public void setBorders() {
		Border inner = BorderFactory.createTitledBorder("");
		Border outer = BorderFactory.createEmptyBorder(20, 10, 20, 10);

		setBorder(BorderFactory.createCompoundBorder(outer, inner));

	}

	/**
	 * aktivira tri objekta
	 */
	public void activateComp() {
		salji.addActionListener(this);
		upis.addActionListener(this);
		statistics.addActionListener(this);
	}

	/**
	 * dohvaća podatke i static liste korisnik ispisuje korisnike,broji koliko ima
	 * vozila,lijepi ih na textpanel
	 */
	public void ispisKorisnika() {
		int cnt = 0;
		int svakoVozilo = 0;
		for (Korisnik k : DataPanel.korisnik) {
			svakoVozilo++;
			tp2.textArea.append(Integer.toString(svakoVozilo) + "." + k.toString());
			cnt++;
		}
		tp2.textArea.append("Ukupno automobila u danu: " + cnt);
		tp2.textArea.append("\n******************************************");
	}

	/**
	 * osluškuje događaje(metoda action listenera) ispisuje korisnike upisuje
	 * podatke u datoteku parking.txt ispisuje statistiku korisnika
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salji) {
			ispisKorisnika();
		}

		if (e.getSource() == upis) {

			FileWriter fr = null;
			BufferedWriter bw = null;

			try {
				fr = new FileWriter("parking.txt");//////// upis u datoteku/////////

				bw = new BufferedWriter(fr);

				int cnt = 1;
				for (Korisnik k : DataPanel.korisnik) {
					int c = cnt++;
					bw.write(Integer.toString(c) + ".)");
					bw.write(k.toString());
					bw.newLine();
					bw.write(
							"______________________________________________________________________________________________________________");
					bw.newLine();

				}
				bw.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		if (e.getSource() == statistics) {
			// readData();
			statistics();

		}
	}

	/**
	 * metoda za citanje texta UPISANE datoteke vraća listu readList sprema podatke
	 * u tu listu @
	 */

	public ArrayList<String> readData() {

		FileReader fr = null;
		BufferedReader br = null;

		ArrayList<String> readList = new ArrayList<>();

		try {

			fr = new FileReader("parking.txt");
			br = new BufferedReader(fr);

			String line;

			while ((line = br.readLine()) != null) {
				line.split(",");
				readList.add(line);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return readList;
	}

	/**
	 * metoda za računanje prihoda po zonama lijepi rezultate na text panel
	 */
	public void statistics() {

		int zona1sat1 = 0;
		int zona1sat2 = 0;
		int zona1sat3 = 0;

		///////////////
		int zona2sat1 = 0;
		int zona2sat2 = 0;
		int zona2sat3 = 0;
		//////////////
		int zona3sat1 = 0;
		int zona3sat2 = 0;
		int zona3sat3 = 0;
		//////////////
		int zona1Dnevna = 0;
		int zona2Dnevna = 0;
		int zona3Dnevna = 0;

		///////// ZONE//////////////
		for (String s : readData()) {

			if (s.matches("(.*)30kn 1h Zona 1(.*)")) {
				zona1sat1++;
				// System.out.println(s.matches("(.*)30kn 1h Zona 1(.*)"));
				// System.out.println(zona1sat1);
			} else if (s.matches("(.*)60kn 2h Zona 1(.*)")) {
				zona1sat2++;

			} else if (s.matches("(.*)90kn 3h Zona 1(.*)")) {
				zona1sat3++;

			}
			///////////////////////////////////////////////
			else if (s.matches("(.*)20kn 1h Zona 2(.*)")) {
				zona2sat1++;

			} else if (s.matches("(.*)40kn 2h Zona 2(.*)")) {
				zona2sat2++;

			} else if (s.matches("(.*)60kn 3h Zona 2(.*)")) {
				zona2sat3++;

			}
			/////////////////////////////////////////////

			else if (s.matches("(.*)15kn 1h Zona 3(.*)")) {
				zona3sat1++;

			}

			else if (s.matches("(.*)30kn 2h Zona 3(.*)")) {
				zona3sat2++;

			} else if (s.matches("(.*)45kn 3h Zona 3(.*)")) {
				zona3sat3++;

			}
			//////////////// DNEVNA KARTA/////////////////////////////
			else if (s.matches("(.*)200kn DNEVNA KARTA Zona 1(.*)")) {
				zona1Dnevna++;

			} else if (s.matches("(.*)150kn DNEVNA KARTA Zona 2(.*)")) {
				zona2Dnevna++;

			} else if (s.matches("(.*)100kn DNEVNA KARTA Zona 3(.*)")) {
				zona3Dnevna++;

			}

		}
		tp2.textArea.append(
				"\n********************************************************************************************\n");

		tp2.textArea.append("Ukupni prihod za ZONA1--SAT1: " + Integer.toString(zona1sat1 * 30) + "kn");
		tp2.textArea.append("\n--------------------------------------------------------------------\n");

		tp2.textArea.append("Ukupni prihod za ZONA1--SAT2: " + Integer.toString(zona1sat2 * 60) + "kn");
		tp2.textArea.append("\n--------------------------------------------------------------------\n");

		tp2.textArea.append("Ukupni prihod za ZONA1--SAT3: " + Integer.toString(zona1sat3 * 90) + "kn");
		tp2.textArea.append("\n--------------------------------------------------------------------\n");
		////////////////////////////////////////////////////////////////////////////////////////////////
		tp2.textArea.append("Ukupni prihod za ZONA2--SAT1: " + Integer.toString(zona2sat1 * 20) + "kn");
		tp2.textArea.append("\n--------------------------------------------------------------------\n");

		tp2.textArea.append("Ukupni prihod za ZONA2--SAT1: " + Integer.toString(zona2sat2 * 40) + "kn");
		tp2.textArea.append("\n--------------------------------------------------------------------\n");

		tp2.textArea.append("Ukupni prihod za ZONA2--SAT1: " + Integer.toString(zona2sat3 * 60) + "kn");
		tp2.textArea.append("\n--------------------------------------------------------------------\n");
		////////////////////////////////////////////////////////////////////////////////////////////////
		tp2.textArea.append("Ukupni prihod za ZONA3--SAT1: " + Integer.toString(zona3sat1 * 15) + "kn");
		tp2.textArea.append("\n--------------------------------------------------------------------\n");

		tp2.textArea.append("Ukupni prihod za ZONA3--SAT2: " + Integer.toString(zona3sat2 * 30) + "kn");
		tp2.textArea.append("\n--------------------------------------------------------------------\n");

		tp2.textArea.append("Ukupni prihod za ZONA3--SAT2: " + Integer.toString(zona3sat3 * 45) + "kn");
		tp2.textArea.append("\n--------------------------------------------------------------------\n");

		////////////////////////////////////////////// DNEVNE
		////////////////////////////////////////////// KARTE//////////////////////////////////////////////////
		tp2.textArea.append("Ukupni prihod za ZONA1--DNEVNE KARTE: " + Integer.toString(zona1Dnevna * 200) + "kn");
		tp2.textArea.append("\n--------------------------------------------------------------------\n");

		tp2.textArea.append("Ukupni prihod za ZONA2--DNEVNE KARTE: " + Integer.toString(zona2Dnevna * 150) + "kn");
		tp2.textArea.append("\n--------------------------------------------------------------------\n");

		tp2.textArea.append("Ukupni prihod za ZONA3--DNEVNE KARTE: " + Integer.toString(zona3Dnevna * 100) + "kn");
		tp2.textArea.append("\n--------------------------------------------------------------------\n");

		int ukupniPrihodi = (zona1sat1 * 30) + (zona1sat2 * 60) + (zona1sat3 * 90) + (zona2sat1 * 20) + (zona2sat2 * 40)
				+ (zona2sat3 * 60) + (zona3sat1 * 15) + (zona3sat2 * 30) + (zona3sat3 * 45) + (zona1Dnevna * 200)
				+ (zona2Dnevna * 150) + (zona3Dnevna * 100);

		tp2.textArea
				.append("\n#####################################################################################\n");
		tp2.textArea.append("Ukupni prihodi od parkinga iznose: " + Integer.toString(ukupniPrihodi) + "kn\n");
	}

	//////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////
}
