package view;
import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.*;

/**
 * klasa u kojoj se stvaraju sve ostale klase,odgovorna za velicinu frame i tazmjestaj komponenti
 * @author ivan
 * @since veljaca, 2019.
 */
public class ServerFrame extends JFrame {

	public ServerFormPanel sFp = new ServerFormPanel(this);

	public ServerParkinPanel sPp = new ServerParkinPanel(this);
	
	public Controller control=new Controller(this);
	
    public MenuBar menuBAr = new MenuBar(this);
    
    public CommandCut cut=new CommandCut(sFp);
    public CommandPaste paste=new CommandPaste(sFp);
	
	Server server;

	public ServerFrame(Server server) {
		this.server=server;
		
		setTitle("Server");
		setLayout(new BorderLayout());
		setSize(700, 650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		sFp.sTp.setSPP(sPp);
		
		layoutComponents();

		setJMenuBar(menuBAr);

	}

	private void layoutComponents() {
		add(sFp, BorderLayout.SOUTH);
		add(sPp, BorderLayout.NORTH);

	}

	

}
