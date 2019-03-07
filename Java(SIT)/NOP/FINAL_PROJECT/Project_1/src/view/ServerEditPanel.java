package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * klasa zadužena za postavljanje komponenti za obradu texta te pridjeljivanju botuna pripadajućim komponentama
 * @author ivan
 * @since veljaca, 2019.
 */
public class ServerEditPanel extends JPanel {

	ServerFormPanel form;

	public JTextArea miniTextArea = new JTextArea();
	public JButton cut;

	public JButton paste;

	public JScrollPane scrollPane;

	JLabel slobodnaMjesta;

	JTextField field;

	JLabel ukupnaAktivnost;
	JTextField field2;

	public ServerEditPanel(ServerFormPanel form) {

		this.form = form;

		setLayout(new GridBagLayout());

		Dimension dim = getPreferredSize();
		dim.height = 300;
		dim.width = 400;
		setPreferredSize(dim);
		createComponents();
		layoutComponents();
		setBorders();

		activateComponents();

	}

	private void activateComponents() {
		cut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				form.frame.cut.execute();

			}
		});

		paste.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				form.frame.paste.execute();

			}
		});

	}

	private void createComponents() {
		miniTextArea = new JTextArea(10, 20);
		miniTextArea.setLineWrap(true);

		scrollPane = new JScrollPane(miniTextArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		cut = new JButton("Cut");
		paste = new JButton("Paste");

		slobodnaMjesta = new JLabel("Free spots");

		field = new JTextField(5);

		ukupnaAktivnost = new JLabel("Ukupna aktivnost parkinga");
		field2 = new JTextField(5);

	}

	private void layoutComponents() {

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;

		add(scrollPane, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 1, 1);
		add(cut, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 1, 1);
		add(paste, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		add(slobodnaMjesta, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		add(field, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		add(ukupnaAktivnost, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		add(field2, gbc);

	}

	private void setBorders() {

		Border inner = BorderFactory.createTitledBorder("Edit/monitoring area");
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		setBorder(BorderFactory.createCompoundBorder(outer, inner));
	}

}
