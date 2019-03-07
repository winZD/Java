import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import webText.WebText;

public class AppFrame extends JFrame {

	DataPanel dataPanel;
	ScrappingPanel scrapping;
	MenuBar menu;

	PopUpMenu pop;

	Task task;
	
	
	CommandSelect select;
	CommandCut cut;
	CommandPaste paste;
	CommandCopy copy;
	CommandClearView clearView;

	public AppFrame() {

		setTitle("Web txtScraper");
		setLayout(new BorderLayout());
		setSize(700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		createComps();
		layoutAll();
		setJMenuBar(menu);

		// povezivanje reference "dp" na ovaj glavni dataPanel
		scrapping.sLeft.dp = dataPanel;
		//scrapping.sRight.dp = dataPanel;

		// -||- -||- data na ovaj glavni panel
		//menu.data = dataPanel;

		// poveznica ovog objekta na popObjekt u dataPanelu(da bude isti objekt)
		pop = dataPanel.pop;
		pop.dp = dataPanel;

		// poveznica za progressBar
		task.left = scrapping.sLeft;
		scrapping.sLeft.webTask = task;

	}

	public void createComps() {

		scrapping = new ScrappingPanel(this);
		menu = new MenuBar(this);
		dataPanel = new DataPanel();

		pop = new PopUpMenu();
		task = new Task();
		 
		
		select=new CommandSelect(dataPanel);
		cut=new CommandCut(dataPanel);
		paste=new CommandPaste(dataPanel);
		copy=new CommandCopy(dataPanel);
		clearView=new CommandClearView(dataPanel);

	}

	private void layoutAll() {
		add(dataPanel, BorderLayout.CENTER);
		//add(menu, BorderLayout.NORTH);
		add(scrapping, BorderLayout.SOUTH);

	}

}
