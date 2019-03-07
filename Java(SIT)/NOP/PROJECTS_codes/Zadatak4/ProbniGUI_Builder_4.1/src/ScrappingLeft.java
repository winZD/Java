import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.Border;

import webText.WebText;

public class ScrappingLeft extends JPanel {

	WebText web;
	DataPanel dp;
	
	Task webTask;
	
	private JLabel url;
	private JTextField urlField;

	public JButton getText;

	public JProgressBar progress;

	public JButton show;

	public ScrappingLeft() {
		
		
		
		
		
		setLayout(new GridBagLayout());

		createComponents();
		layoutComponents();

		activateComponents();

	}

	

	

	public void createComponents() {
		url = new JLabel("URL: ");
		urlField = new JTextField(15);

		getText = new JButton("Get Text");

		progress = new JProgressBar();
		progress.setForeground(Color.GREEN);

		show = new JButton("Show");
		show.setEnabled(false);

		
		web = new WebText();
		
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inner = BorderFactory.createTitledBorder("Web scrapping");
		Border border = BorderFactory.createCompoundBorder(outer, inner);
		this.setBorder(border);

		Dimension dims = getPreferredSize();
		dims.height = 200;
		dims.width = 300;
		setPreferredSize(dims);

	}

	public void layoutComponents() {

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.weightx = 0.1;
		gbc.weighty = 0.1;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(url, gbc);

		gbc.gridx++;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(urlField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(getText, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(progress, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;

		add(show, gbc);

	}

	public void activateComponents() {

		getText.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				web.scrapText4Web(urlField.getText());
				webTask.execute();
				
			
			}
		});
		
		show.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				for(String s:web.getScrapedText()) {
					dp.textArea.append(s+"\n\n");
				}
				
				
				
				
				
			}
		});
		
		
	}
}
