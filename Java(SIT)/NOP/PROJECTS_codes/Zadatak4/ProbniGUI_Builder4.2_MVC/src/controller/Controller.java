package controller;

import model.Database;
import model.WebText;
import view.AppFrame;

public class Controller {
	public Database database;
	public WebText webText;
	AppFrame frame;
	
	public Controller(AppFrame frame) {
		this.frame=frame;
		database=new Database();
		webText=new WebText();
		
	}
	
	public void addDataList() {
		//database.list.add(e)
		if (database.list.size() > 1) {
			frame.menu.previous.setEnabled(true);

		}
	}
}
