package controller;

import model.Database;

import view.ServerFrame;
/**
 * Kontroler koji stvara klasu database za spremanje podataka
 * @author ivan
 * @since veljaca, 2019.
 */
public class Controller {

	public Database database;
	public ServerFrame conFrame;

	public Controller(ServerFrame frame) {

		this.conFrame = frame;

		database = new Database();
	}

}
