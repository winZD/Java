package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

/**
 * glavna klasa za vizualni dio
 * kreira parking panel i form panel
 * @author ivan
 * @since veljaca, 2019.
 */


public class ClientFrame extends JFrame {

	ClientParkingPanel cPp = new ClientParkingPanel();

	ClientFormPanel cFp = new ClientFormPanel();

	int reserved = 0;

	
	


	public ClientFrame() {
		setTitle("CLIENT");
		setLayout(new BorderLayout());

		add(cPp, BorderLayout.NORTH);
		add(cFp, BorderLayout.SOUTH);
		
		

		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	
	

		
	
	/**
	 * metoda za postavljanje trenutnog datuma i vremena
	 */
	public String setDate() {
		Date d=new Date();
		DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String s=dateFormat.format(d);
		return s;
		
	}
	
	/**
	 * metoda za upisivanje primljene poruke na textarea u podklasu klase clientFormPanel 
	 */
	public void writeReceivedMessage(String msg) {
		cFp.cTp.tArea.append(msg);
		
	}
}
