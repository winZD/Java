package view;
import java.io.IOException;
import java.net.UnknownHostException;
/**
 * Stvaranje objekata tipa client
 * @author ivan
 * @since veljaca, 2019.
 */
public class ClientApp {

	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Client client1=new Client();
		Client client2=new Client();
		
		client1.setup();
		client2.setup();
		

	}

}
