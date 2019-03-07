

import java.io.IOException;

public class AppServer {

	public static void main(String[] args) throws IOException {
		QuoteServer server = new QuoteServer();
		server.go();

	}

}
