package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class ScrappingPanel extends JPanel {

	ScrappingLeft sLeft;
	ScrappingRight sRight;

	AppFrame appFrame;

	public ScrappingPanel(AppFrame appFrame) {
		this.appFrame = appFrame;

		setLayout(new BorderLayout());

		createComponents();
		layoutComponents();

	}

	public void createComponents() {
		sLeft = new ScrappingLeft();
		sRight = new ScrappingRight(appFrame);

	}

	public void layoutComponents() {

		add(sLeft, BorderLayout.WEST);
		add(sRight, BorderLayout.EAST);
	}

}
