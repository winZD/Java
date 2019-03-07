import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Klasa Korisnik koja ima 3 argumenta,ispisuje vozila, vrijeme parkinga te
 * zonu. u njoj se random generira vrijeme dolaska, te se randm generira
 * registarska oznaka
 * 
 * @author ivan
 *
 */ 
public class Korisnik {

	String reg; 
	String vrijemePark;
	String zona;

	/**
	 * Konstruktor klase korisnik koji prima tri argumenta
	 *
	 * @param reg
	 * @param vrijemePark
	 * @param zona
	 * 
	 * 
	 */
	public Korisnik(String reg, String zona, String vrijemePark) {

		this.reg = reg;
		this.vrijemePark = vrijemePark;
		this.zona = zona;

	}

	/**
	 * Overridean-a metoda u koja vraća prethodna tri argumenta
	 */
	@Override
	public String toString() {
		return "\n  Vozilo registracije: " + reg + "\n  Vrsta parkiranja: " + zona + "\n" + " " +
				vrijemePark+ "\n-------------------------------------------------------------------------------------\n";
	}

	/**
	 * Metoda koja stvara datum oduzima trenutne milisekunde od 10000ms Pretvara ih
	 * u sate minute i sekunde
	 * 
	 * @return Vraća trenutni dan/mjesec/godinu Vraća trenutno vrijeme umanjenjeno
	 *         za 10000ms
	 */
	public static String randomVrijemeDolaska() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat(" dd-MM-yyyy ");

		Date now = new Date();

		String s = dateFormatter.format(now);// iz Date-a u string(dan,mjesec godina)

		long currentTime = System.currentTimeMillis();

		long randomVrijeme;

		Random random = new Random();

		randomVrijeme = currentTime - random.nextInt(1000000) - 10000;

		Date vrijeme = new Time(randomVrijeme);// vracam vrijeme iz milisek u stvarno vrijeme(sat,minuta,sekunda)

		return s + vrijeme.toString();
	}

	/**
	 * Vraća random generirano slovo u unaprijed deklaniranom nizu(Pretvoreno u
	 * slovo iz ascii koda)
	 * 
	 * @return
	 */
	public static String randomTab() {
		Random rand = new Random();
		String[] s1 = { "ZD", "ZG", "DU", "RI", "BJ" };
		int randomBroj = rand.nextInt(5);

		int randombrojReg = rand.nextInt(1000) + 100;

		int randReg1 = rand.nextInt(24) + 65;// za ASCII code
		int randReg2 = rand.nextInt(24) + 65;

		String s2 = Character.toString((char) randReg1) + Character.toString((char) randReg2);// pretvaranje u slova iz
																								// ASCII-a

		return s1[randomBroj] + randombrojReg + s2;

	}

	public static String zonaPark() {
		Random rand = new Random();

		String[] s1 = { " 45kn 3h Zona 3", " 30kn 2h Zona 3", " 15kn 1h Zona 3", " 60kn 3h Zona 2", " 40kn 2h Zona 2",
				" 90kn 3h Zona 1", " 60kn 2h Zona 1", " 30kn 1h Zona 1", " 200kn DNEVNA KARTA Zona 1",
				" 150kn DNEVNA KARTA Zona 2", " 100kn DNEVNA KARTA Zona 3", " 20kn 1h Zona 2" };

		int randomBroj = rand.nextInt(s1.length);

		return s1[randomBroj];

	}

}
