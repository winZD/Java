package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
/**
 * Klasa za postavljanje konekcije prema serveru
 * @author ivan
 * @since veljaca, 2019.
 */
public class Client {
	private final int ServerPort = 25000;
	private ClientFrame clFrame;
	private BufferedReader bfr;
	private InputStreamReader isr;
	private PrintWriter pwr;
	private Socket con;
	public int dailyActivity = 0;

	ArrayList<String> broj = new ArrayList<>();


	public Client() throws UnknownHostException, IOException {

		clFrame = new ClientFrame();
		con = new Socket("127.0.0.1", 25000);
		clFrame.cFp.cIp.connectionstatusInput.setText("You are connected...");

	}

	/**
	 *  metoda za kreiranje threada koji slusa podatke sa servera te ih upisuje u za
	 *  to predvidena polja
	 */

	public void setup() throws UnknownHostException, IOException {

		/**
		 * Thread za slusanje podataka sa servera
		 * 
		 */
		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					ObjectInputStream inputStream = new ObjectInputStream(con.getInputStream());

					while (true) {

						String input = inputStream.readObject().toString();
						clFrame.cPp.changeClientButtonState(input);

						clFrame.cFp.cTp.tArea.append("Zauzeto mjesto broj: " + (input+1) + " " + clFrame.setDate() + "\n");
						clFrame.cFp.cTp.tArea.append("_______________________________________________________________\n");

						dailyActivity++;
						// clFrame.cFp.cIp.inputRegistrationPlate.setText(Integer.toString(clFrame.cPp.countingSpots(occupiedSpots)));
						clFrame.cFp.cIp.input.setText(Integer.toString(	clFrame.cPp.counterFree));

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		th.start();

	}

}