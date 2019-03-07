package view;
import java.awt.Dimension;
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

public class ScrappingRight extends JPanel {

	public AppFrame appFrame;

	public JButton selectAll;
	public JButton paste;
	public JButton copy;
	public JButton cut;
	public JButton clearView;

	public ScrappingRight(AppFrame appFrame) {

		this.appFrame = appFrame;

		setLayout(new GridBagLayout());

		createComponents();
		layoutComponents();
		activateComponents();

	}

	public void createComponents() {

		selectAll = new JButton("SelectAll");
		paste = new JButton("Paste");
		copy = new JButton("Copy");
		cut = new JButton("Cut");
		clearView = new JButton("Clear view");
		clearView.setEnabled(false);

		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inner = BorderFactory.createTitledBorder("Edit");
		Border border = BorderFactory.createCompoundBorder(outer, inner);
		this.setBorder(border);

		Dimension dims = getPreferredSize();
		dims.width = 300;
		dims.height = 150;
		setPreferredSize(dims);

	}

	public void layoutComponents() {

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.weightx = 0;
		gbc.weighty = 0;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.insets = new Insets(10, 10, 10, 10);
		add(selectAll, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.insets = new Insets(10, 10, 10, 10);
		add(paste, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.insets = new Insets(10, 0, 10, 32);
		add(copy, gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.insets = new Insets(10, 10, 10, 0);
		add(clearView, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.insets = new Insets(10, 0, 10, 40);
		add(cut, gbc);

	}

	public void activateComponents() {
		selectAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appFrame.select.execute();

			}
		});

		copy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				appFrame.copy.execute();

				clearView.setEnabled(true);

			}
		});

		cut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				appFrame.cut.execute();

			}
		});

		paste.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				appFrame.paste.execute();

			}
		});

		clearView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appFrame.clearView.execute();

			}
		});
	}

}
