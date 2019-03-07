package view;
import java.io.IOException;
import java.net.UnknownHostException;
/**
 * glavna klasa koja pokreće i stvara server
 * @author ivan
 * @since veljaca, 2019.
 */
public class ServerApp {
	public static void main(String[] args) throws UnknownHostException, IOException {

		Server server=new Server();
		
		server.setup();
	}

}
