import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientFrame extends JFrame  {
	public JTextField IPfield;
	public JTextField tcpField;
	public JTextField dateTimeField;
	public JTextField statusField;
	public JTextArea textArea;
	public JButton btnNewButton;
	public String msg;
	public PrintWriter pwr;
	Client client;
	String temp;
	public JButton disconnect;
	

	public ClientFrame(Client cl) {
		
		this.client=cl;
		getContentPane().setLayout(null);
		
		
		
		textArea = new JTextArea();
		textArea.setBounds(10, 11, 474, 256);
		getContentPane().add(textArea);
		textArea.setEditable(false);

		JLabel lblIpAddress = new JLabel("IP address");
		lblIpAddress.setBounds(30, 334, 65, 14);
		getContentPane().add(lblIpAddress);

		IPfield = new JTextField();
		IPfield.setBounds(10, 350, 104, 20);
		getContentPane().add(IPfield);
		IPfield.setColumns(10);
		IPfield.setEditable(false);

		JLabel lblTcpSocketPort = new JLabel("TCP socket port");
		lblTcpSocketPort.setBounds(168, 334, 92, 14);
		getContentPane().add(lblTcpSocketPort);

		tcpField = new JTextField();
		tcpField.setBounds(156, 350, 104, 20);
		getContentPane().add(tcpField);
		tcpField.setColumns(10);
		tcpField.setEditable(false);

		JLabel lblDatumIVrijeme = new JLabel("Datum i vrijeme");
		lblDatumIVrijeme.setBounds(316, 334, 108, 14);
		getContentPane().add(lblDatumIVrijeme);

		dateTimeField = new JTextField();
		dateTimeField.setBounds(299, 350, 125, 20);
		getContentPane().add(dateTimeField);
		dateTimeField.setColumns(10);
		dateTimeField.setEditable(false);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(30, 403, 46, 14);
		getContentPane().add(lblStatus);

		statusField = new JTextField();
		statusField.setBounds(10, 422, 154, 20);
		getContentPane().add(statusField);
		statusField.setColumns(10);
		statusField.setEditable(false);

		btnNewButton = new JButton("Connect");
		btnNewButton.setBounds(254, 413, 117, 31);
		getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 92);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(29, 154, 342, 70);
		getContentPane().add(panel_1);
		
		disconnect = new JButton("Disconnect");
		disconnect.setBounds(254, 381, 117, 23);
		getContentPane().add(disconnect);
		
		activateBtn();
		setLocationRelativeTo(null);
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
	
	}
	

	public void writeReceivedMessage(String msg) {
		this.msg=msg;
		textArea.append(msg);
		textArea.append("\n");
	}
	
	public void activateBtn() {
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//msg=textArea.getText();
				
				if(client.con.isClosed()) {
					try {
						client.setUpNetworking();
						btnNewButton.setBackground(Color.GREEN);
						
						//IPfield.setText(client.con.getInetAddress().toString());
						statusField.setText("You are connected...");
						dateTimeField.setText(setDate());
						
						pwr.println(msg);
						pwr.flush();
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
					else  {
					btnNewButton.setBackground(Color.GREEN);
					
					//IPfield.setText(client.con.getInetAddress().toString());
					statusField.setText("You are connected...");
					dateTimeField.setText(setDate());
					
					pwr.println(msg);
					pwr.flush();
					
					}
				
				
				
			}
		});
		
		disconnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					disconnect.setBackground(Color.RED);
					statusField.setText("You are disconnected...");
					
					client.con.close();
					client.isr.close();
					client.bfr.close();
					client.pwr.close();
					
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	}
	
	public void setPrintWriter(PrintWriter pwr) {
		this.pwr = pwr;
	}
	
	
	public void writeTxt(String string) {
		textArea.append("******************************************\n");
		textArea.append(string);
		textArea.append("\n");
		textArea.append("******************************************\n");
	}


	public String setDate() {
		Date d=new Date();
		DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String s=dateFormat.format(d);
		return s;
		
	}
	
}
