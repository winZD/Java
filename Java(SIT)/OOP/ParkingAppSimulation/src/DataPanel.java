import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
 
/*
 * Dohvaća podatke,računa broj karata i parkirnih mjesta 
 */
public class DataPanel extends JPanel implements ActionListener { 

	

	int cnt = 0;
	static int brojParkMjesta = 100;

	JLabel tablica;
	JLabel vrijeme;

	JComboBox<String> box;

	

	JTextField registracija;

	public JRadioButton jR1;
	public JRadioButton jR2;
	public JRadioButton jR3;
	public JRadioButton jR4;

	public ButtonGroup bG;
	

	

	JButton provjera;

	public static ArrayList<Korisnik> korisnik = new ArrayList<>();

	TextPanel tp;

	LeftPanel lp;
	
	ToolBar tb;

	/**
	 * Konstruktor
	 * postavlja layout
	 * kreira komponente i bordere
	 * akticira komponente
	 * 
	 */
	public DataPanel() {
		setLayout(new GridBagLayout());

		createComp();
		createLayout();
		setBorders();
		activateComp();

	}
/**
 * kreira objekte
 */
	public void createComp() {
		tablica = new JLabel("Registarska oznaka:");
		vrijeme = new JLabel("Vrijeme korištenja parkinga(minute):");

		box = new JComboBox<>();
		box.addItem("Zona 1");
		box.addItem("Zona 2");
		box.addItem("Zona 3");
		


		jR1=new JRadioButton("1h");
		jR2=new JRadioButton("2h");
		jR3=new JRadioButton("3h");
		jR4=new JRadioButton("Dnevna karta");
		
		jR1.setSelected(true);
		jR2.setSelected(false);
		jR3.setSelected(false);
		jR4.setSelected(false);
		
		
		bG=new ButtonGroup();
		bG.add(jR1);
		bG.add(jR2);
		bG.add(jR3);
		bG.add(jR4);


		registracija = new JTextField(10);

		provjera = new JButton("Provjera");

	}
	
	/**
	 * kreira layout i postavlja komponente na zadano mjesto
	 */

	public void createLayout() {

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.weightx = 1;
		gbc.weighty = 1;

		gbc.gridx = 0;
		gbc.gridy = 0;
		add(tablica, gbc);

		gbc.gridx++;
		add(vrijeme, gbc);

		gbc.gridx++;
		gbc.gridy = 1;
		add(box, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		add(registracija, gbc);

		gbc.gridx++;
		add(jR1, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(jR2, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(jR3, gbc);
		

		gbc.gridx = 0;
		gbc.gridy = 3;
		add(jR4, gbc);

		gbc.gridx = 2;
		gbc.gridy = 3;
		add(provjera, gbc);

	}

	/**
	 * postavlja bordere
	 */
	public void setBorders() {
		Border inner = BorderFactory.createTitledBorder("Podaci");
		Border outer = BorderFactory.createEmptyBorder(20, 10, 10, 10);

		setBorder(BorderFactory.createCompoundBorder(outer, inner));

	}
	/**
	 * osluškuje događaje(metoda action listenera)
	 * dohvaća podatke iz komponenti
	 * sprema korisnike u listu
	 * dohvaćapodatke iz drugih objekata
	 * računa broj karata i parkirnih mjesta
	 * podatke lijepi u textArea
	 * 
	 */
	public void activateComp() {
		provjera.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == provjera) {
			tb.send.setEnabled(true);
			
			String dnevna = null;
			
			if(jR1.isSelected()&& box.getSelectedItem()=="Zona 1") {
				
				int v =30;
				dnevna = Integer.toString(v) + "kn 1h "+box.getSelectedItem();
			}
			if(jR1.isSelected()&& box.getSelectedItem()=="Zona 2") {
				
				int v =20;
				dnevna = Integer.toString(v) + "kn 1h "+box.getSelectedItem();
			}
			if(jR1.isSelected()&& box.getSelectedItem()=="Zona 3") {
				
				int v =15;
				dnevna = Integer.toString(v) + "kn 1h "+box.getSelectedItem();
			}
			
			

			if(jR2.isSelected()&& box.getSelectedItem()=="Zona 1") {
				int v = 60;
				dnevna = Integer.toString(v) + "kn 2h "+box.getSelectedItem();
			}
			if(jR2.isSelected()&& box.getSelectedItem()=="Zona 2") {
				int v = 40;
				dnevna = Integer.toString(v) + "kn 2h "+box.getSelectedItem();
			}
			if(jR2.isSelected()&& box.getSelectedItem()=="Zona 3") {
				int v = 30;
				dnevna = Integer.toString(v) + "kn 2h "+box.getSelectedItem();
			}
			
			

			if(jR3.isSelected()&& box.getSelectedItem()=="Zona 1") {
				int v = 90;
				dnevna = Integer.toString(v) + "kn 3h "+box.getSelectedItem();
			}
			if(jR3.isSelected()&& box.getSelectedItem()=="Zona 2") {
				int v = 60;
				dnevna = Integer.toString(v) + "kn 3h "+box.getSelectedItem();
			}
			
			if(jR3.isSelected()&& box.getSelectedItem()=="Zona 3") {
				int v = 45;
				dnevna = Integer.toString(v) + "kn 3h "+box.getSelectedItem();
			}
			
			if (jR4.isSelected()) {
				
			
				
				if (box.getSelectedItem() == "Zona 1") {
					int v = 50 * 4;
					dnevna = Integer.toString(v) + "kn DNEVNA KARTA "+box.getSelectedItem();

				} else if (box.getSelectedItem() == "Zona 2") {
					int v = 50 * 3;
					dnevna = Integer.toString(v) + "kn DNEVNA KARTA "+box.getSelectedItem();

				} else if (box.getSelectedItem() == "Zona 3") {
					int v = 50 * 2;
					dnevna = Integer.toString(v) + "kn DNEVNA KARTA " +box.getSelectedItem();
				} 

				}
				

				Korisnik k = new Korisnik(registracija.getText(), dnevna, Korisnik.randomVrijemeDolaska().toString());

				korisnik.add(k);
				
				tp.textArea.append(k.toString());
				
				lp.dolazak.setText(k.vrijemePark);
				//lp.dolazak.setText(Korisnik.randomVrijemeDolaska().toString());

				////////////////////////////////// LEFT PANEL///////////////////////////

				/**************** DATE *******************/
				/*
				

				int minDay = (int) LocalDate.of(2018, 1, 1).toEpochDay();
				int maxDay = (int) LocalDate.of(2018, 12, 31).toEpochDay();
				long randomDay = minDay + random.nextInt(maxDay - minDay);

				LocalDate parkingDate = LocalDate.ofEpochDay(randomDay);
				*/
				
/*				SimpleDateFormat dateFormatter = new SimpleDateFormat(" d-M-y 'at");
				Date now = new Date();
				String s=dateFormatter.format(now);
				
				long currentTime = System.currentTimeMillis();
				
				
				
				/*
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String format = (parkingDate).format(formatter);
				*/

				
				/*************TIME****************************/
/*				Random random = new Random();
				
				Time time = new Time((long)random.nextLong());
*/			
				
				
				 //lp.dolazak.setText(s+" "+t);
				 
				
				
				 
				/***************** ID karte ******************/
				
				String provjeraID= lp.iD.getText();
				int cnt=Integer.parseInt(provjeraID);
				cnt++;
				if (cnt <= 100) {
					lp.iD.setText(Integer.toString(cnt));

				} else {
					lp.iD.setText("Sve mjesta su popunjena");
				}

				/************* broj parkirnih mjesta ******************/

				
				
				String provjera= lp.brojMijesta.getText();
				int n=Integer.parseInt(provjera);
				if (n > 0) {
					n--;
					lp.brojMijesta.setText(Integer.toString(n));

				} else {
					lp.brojMijesta.setText("Sva su mjesta popunjena");
				}

			}
		}

	}
	
	




