package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * klasa zadužena za stvaranje botuna,njihovu aktivnost i sljanje tih podataka klijentima
 * @author ivan
 * @since veljaca, 2019.
 */
public class ServerParkinPanel extends JPanel {

	ArrayList<JButton> botuni;

	ArrayList<ObjectOutputStream> output = new ArrayList<>();
	ServerFrame serFrame;

	// public Server server;

	private String msg;

	public int mjesto;

	int cnt = 0;
	int cntFree=60;

	JLabel p;

	public ServerParkinPanel(ServerFrame serFrame) {
		this.serFrame = serFrame;

		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(800, 600));
		createComponents();

	}

	public String getMessage() {

		return msg;
	}

	/**
	 * metoda za kreiranje botuna sa for petljom
	 */
	private void createComponents() {

		botuni = new ArrayList<>();

		for (int i = 0; i < 60; i++) {
			JButton botun = new JButton("");

			botun.setIcon(new ImageIcon("Icons/parkingSpot.png"));
			botun.setPreferredSize(new Dimension(50, 50));
			botun.setBackground(Color.GREEN);

			add(botun);
			botuni.add(botun);

		}

	}

	/**
	 * mijenjanje statusa botuna & slanje podataka klijentima
	 */
	public void changeButtonState(int n) {

		JButton botun = botuni.get(n);
		if (botun.getBackground() == Color.GREEN) {
			botun.setBackground(Color.RED);
			cntFree--;
		} else {
			botun.setBackground(Color.GREEN);
			cntFree++;
		}

		
		for (ObjectOutputStream out : serFrame.server.outputStream) {
			try {
				out.writeObject(new Integer(n));
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	/**
	 * metoda za random generiranje aktivnosti botuna
	 */
	public void startSimulation() {

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {

				Random random = new Random();

				while (true) {
					int randomMjesta = random.nextInt(30);

					for (int i = 0; i < randomMjesta; i++) {
						mjesto = random.nextInt(60);

						changeButtonState(mjesto);
						cnt++;
						serFrame.sFp.sTp.textArea.append(
								"Datum/Vrijeme: " + setDate() + " \nZauzeto mjesto broj " + (mjesto + 1) + "\n");
						serFrame.sFp.sTp.textArea.append("_____________________________\n");

						serFrame.sFp.sEp.field2.setText(Integer.toString(cnt));

					}
					serFrame.sFp.sEp.field.setText(Integer.toString(cntFree));

					try {
						Thread.sleep(random.nextInt(1500));
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}

			}
		});
		thread.start();

	}

	/**
	 * metoda za trenutni datum i vrijeme
	 */
	public String setDate() {
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String s = dateFormat.format(d);
		return s;

	}

}
