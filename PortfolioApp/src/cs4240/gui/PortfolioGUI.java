package cs4240.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.JMenuItem;

import cs4240.User;
import cs4240.Portfolio;
import java.awt.List;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

public class PortfolioGUI extends JFrame {
	public PortfolioGUI(final User mainUser) {
		setSize(345, 465);
		setVisible(true);
		
		System.out.println(mainUser.getPortfolioList());
		
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 23, 309, 175);
		getContentPane().add(tabbedPane);
		Panel panel = new Panel();
		panel.setBounds(10, 232, 309, 155);
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("Select Portfolio");
		panel.add(rdbtnmntmNewRadioItem);
		;
		
		for (int i = 0; i < mainUser.getPortfolioList().size(); i++){
			JRadioButton rdbtnNewRadioButton = new JRadioButton(mainUser.getPortfolioList().get(i).getName());
			panel.add(rdbtnNewRadioButton);
			setVisible(true);
		}
		JButton btnNewButton = new JButton("View Portfolio Composition");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Portfolio port = new Portfolio("", "");
				CompositionGUI composition = new CompositionGUI(mainUser, port);
				setVisible(false);
			}
		});
		
		btnNewButton.setBounds(68, 393, 184, 23);
		getContentPane().add(btnNewButton);
	
		JLabel lblChooseDesirePortfolio = new JLabel("Choose Desired Portfolio:");
		lblChooseDesirePortfolio.setBounds(10, 207, 309, 14);
		getContentPane().add(lblChooseDesirePortfolio);
		
	}
}
