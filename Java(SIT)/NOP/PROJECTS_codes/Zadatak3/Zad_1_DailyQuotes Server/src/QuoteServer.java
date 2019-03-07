
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;

public class QuoteServer {

	private Vector<ClientHandler> clList;
	
	private int cnt = 1;
	private ServerSocket serSckt;

	String[] quotesList = {
			"Create the highes, grandest vission possible for your life, because you become what you believe!",
			"When you can't find the sunshine be the one!", "The grass is greener where you water it",
			"Wherever life plantss you, bloom with grace!",
			"Little by little, day by day what iss meant for you WILL find its way!",
			"An arrow can only be sshot by pulling it backward"
					+ "When life is dragging you back with difficulties, it means it's going to lunch cou into something great. So just focus, and keep aiming!",
			"Believe, act as if, live like you already have it - it's coming!",
			"Begin now to be what you will be hereafter!",
			"Magic is believing in  yourself, if you can do that, you can make anything happen!",
			"If you want something you never had, you have to do something you've never done!",
			"Who looks outside, dreams; who looks inside, awakes.", "Little by little, one travels far.",
			"We know what we are, but know not what we may be.",
			"Difficult roads often leads to beautiful destinations.",
			"Ever tried, Ever failed. No matter. Try again. Fail again. Fail better and at the end you will succed!",
			"Ask and it will be given to you; seek and you will find; knock and door" + " will be opened to you.",
			"Always do your best - what you plant now, you will harvest later.",
			"If you don't like something, change it. If you can't change it, change your attitude.",
			"You don't need to see the whole staircase, just take the first step",
			"In three words I can sum up everything I have learned about life: it goes on.",
			"Try not to became a man of success, but rather try to become a man of value.",
			"Whether you believe you can do thing or not, you are right.",
			"Life isn't about finding yourself. Life is about creating yourself.",
			"Be yourself, everyone is already taken.", "Your big opportunity may be right where xou are now.",
			"One day or day one. You decide.", "They can because they think they can.",
			"Diligence is the mother of good fortune.",
			"Your mind is a powerful thing. When you fill it with positive thoughts, your life will start to change.",
			"I learned long ago, never wrestle with a pig. You get dirty, and besides, the pig likes it.",
			"The only thing you can get in a hurry is trouble.",
			"The two most important days in our life are the day you are born and the day you find out why.",
			"The less effort, the faster and more powerful you will be.",
			"You have to die a few times before you can really live.",
			"My father used to say: 'don't raise your voice, rather improve your argument'.",
			"You will not be punished for your anger," + " you will be punished by your anger.",
			"Truth, and goodness, and beauty are but different faces of the same all.",
			"If you tell the truth, you don't have to remember anything.", "Beware the barreness of a busy life.",
			"Do not take life too seriously. You will never get out of it alive.",
			"Take rest - a field that has rested gives bountiful crop.", "These are the days that must happen to you.",
			"Beauty begins the moment you decide to be yourself.",
			"You have power over your mind - not outside events. Realize this, and you will find strength.",
			"Very little is needed to make a happy life; it is all within yourself, in your way of thinking.",
			"Gratitude is not only the greatest of virtues, but the parent of all others.",
			"Love all, trust a few, do wrong to none.", "Pleasure in the job puts perfection in the work.",
			"Work in silence, let your success be your noise.",
			"The most successful people are those who are good at planning.",
			"There is no greatness where there is no simplicity, goodness and truth.",
			"If you want to make enemies, try to change something.", "Change alone is eternal, perpetual, immortal.",
			"Life is a progress, and not a station.", "Nothing is enough for the man to whom enough is too little.",
			"Every noble work is at first impossible.", "It does not matter how slowly you go as you do not stop.",
			"It is easy to quit smoking. I've done it hundreds of times.",
			"The risk I took was calculated, but man, I am bad at math.",
			"If you feel like giving up, look back at how far you've come." };
	
	
	public String getQuote() {
		int randIn = (int) (Math.random() * quotesList.length);
		return quotesList[randIn];
	}

	// Constructor
	public QuoteServer() {

		
		clList = new Vector<>();

	}

	// method for starting the server
	public void go() throws IOException {
		setUpNtwrk();
	}

	// networking and socket communication
	private void setUpNtwrk() throws IOException {

		serSckt = new ServerSocket(25007);
		System.out.println("Server is running and up to date on a port: " + serSckt.getLocalPort());

		// Ensure socket for clients requests
		Socket clSckt;

		// server is waiting for a new client request - infinite loop
		while (true) {

			// Accept the incoming request from the client
			clSckt = serSckt.accept();

			System.out.println(" --------------------------------------------------------------------- ");
			System.out.println("New client request received: " + clSckt);

			// i/o streams for socket communication
			InputStreamReader dtInptStr = new InputStreamReader(clSckt.getInputStream());
			PrintWriter writer = new PrintWriter(clSckt.getOutputStream());

			System.out.println("Creating a new handler for this client...");
			// Create a new object for clients handling
			String name = "Client_" + cnt;
			ClientHandler clHndl = new ClientHandler(name, dtInptStr, writer);
			System.out.println(clHndl);

			System.out.println("Add this client to the active clients list...");

			// adding to the vector
			clList.add(clHndl);

			// Create the thread for the client
			Thread thr = new Thread(clHndl);

			// start the thread
			thr.start();

			// increment counter for the next client
			cnt++;
		}

	}

	// Inner class for handling clients
	public class ClientHandler implements Runnable {

		private BufferedReader bfrInptRdr;
		private PrintWriter writer;
		private String name;

		// constructor
		public ClientHandler(String name, InputStreamReader isr, PrintWriter wrt) {
			bfrInptRdr = new BufferedReader(isr);
			writer = wrt;
			this.name = name;
			System.out.println("Input stream: " + bfrInptRdr);
			System.out.println("Output stream: " + writer);
			System.out.println("Name: " + name);
		}

		@Override
		public void run() {
			String msg;
			// Check if msg is send from client to the server
			try {
				while ((msg = bfrInptRdr.readLine()) != null) {
					
					send2All(getQuote(), name);
					
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private PrintWriter getOutputWriter() {
			return writer;
		}

		private String getName() {
			return name;
		}
	}

	public void send2All(String msg, String name) {
		// send message to the all clients
		Iterator<ClientHandler> it = clList.iterator();
		while (it.hasNext()) {
			ClientHandler clh = it.next();
			PrintWriter prw = clh.getOutputWriter();
			prw.println(name + ": " + msg);
			prw.flush();
		}
		
	}
}
