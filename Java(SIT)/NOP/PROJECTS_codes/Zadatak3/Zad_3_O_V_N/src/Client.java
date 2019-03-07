
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public final int ServerPort = 8000;
	public ClientFrame clFrame;
	public BufferedReader bfr;
	public InputStreamReader isr;
	public PrintWriter pwr;
	public Socket con;

	public Client() {

		clFrame = new ClientFrame(this);
		
		
	}

	public void go() throws UnknownHostException, IOException {
		setUpNetworking();
	}

	public void setUpNetworking() throws UnknownHostException, IOException {

		// getting ip address of the server --> here localhost
		// InetAddress ip = InetAddress.getByName("localhost");

		con = new Socket("127.0.0.1", ServerPort);

		// i/o streams for communication
		isr = new InputStreamReader(con.getInputStream());

		bfr = new BufferedReader(isr);
		pwr = new PrintWriter(con.getOutputStream());
		clFrame.writeTxt("Connection is established...");
		Thread recMsgThr = new Thread(new ReceiveMsgJob());

		clFrame.setPrintWriter(pwr);
		recMsgThr.start();
	}

	private class ReceiveMsgJob implements Runnable {

		@Override
		public void run() {
			String msg;
			while (true) {
				try {

					while ((msg = bfr.readLine()) != null) {
						clFrame.writeReceivedMessage(msg);
						clFrame.IPfield.setText(con.getInetAddress().toString());
						clFrame.tcpField.setText(Integer.toString(con.getPort()));
						
					

						
						

					}

					
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}

		}

	}
}