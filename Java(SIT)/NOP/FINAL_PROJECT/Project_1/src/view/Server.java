package view;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * klasa za postavljanje parametara za osluskivanje spojenih korsnika
 * @author ivan
 * @since veljaca, 2019.
 */
public class Server {

	private ServerFrame serFrame;
	private int cnt = 1;

	// private int brojacMjesta = 3;
	private ServerSocket serSckt;

	ArrayList<ObjectOutputStream> outputStream = new ArrayList<>();

	/**
	 *  Constructor od servera 
	 */
	public Server() {

		serFrame = new ServerFrame(this);

	}

	/**
	 * metoda za postavljanje parametara na klasi Server
	 * @throws IOException
	 */
	public void setup() throws IOException {

		serSckt = new ServerSocket(25000);

		/**
		 * Thread za slušanje korisnika
		 */
		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {

					Socket socket;
					try {
						socket = serSckt.accept();
						System.out.println("Spojen klijent broj "+cnt);
						
						outputStream.add(new ObjectOutputStream(socket.getOutputStream()));
						
						cnt++;
						
						
						

					} catch (IOException e) {

						e.printStackTrace();
					}
				}

			}
		});
		th.start();
	}

	
	
}
