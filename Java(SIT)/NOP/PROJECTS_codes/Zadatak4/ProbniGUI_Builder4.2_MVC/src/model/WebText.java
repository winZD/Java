package model;

import java.util.ArrayList;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

public class WebText {

	private UserAgent userAgent;
	private ArrayList<String> txtWeb;
	private String url;

	int id = 0;
	String name = url;
	String content;

	// url from JTextField
	public WebText(String url) {
		this.url = url;

		userAgent = new UserAgent();
		txtWeb = new ArrayList<>();

	}

	public WebText() {
		userAgent = new UserAgent();
		txtWeb = new ArrayList<>();

	}

	// scrap all from <p> html tags
	public void scrapText4Web(String url) {

		try {
			id++;
			txtWeb.clear();
			content = "";
			userAgent.visit(url);
			name = url;
			Elements pAll = userAgent.doc.findEach("<p>");

			for (Element elm : pAll) {
				txtWeb.add(elm.getTextContent());
				content += elm.getTextContent() + "\n";
				// System.out.println(elm.getTextContent());

			}

		} catch (ResponseException e) {

			e.printStackTrace();
		}

	}

	public ArrayList<String> getScrapedText() {
		return txtWeb;
	}

	public String toString() {
		return "id: " + id +"\n"+ name + "\n" + content;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
