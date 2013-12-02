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
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class PortfolioGUI extends JFrame {
	public PortfolioGUI(final User mainUser) {
		setTitle("Portfolios");
		setSize(345, 465);
		setVisible(true);
		
		final String portfolioName ="";
		
		System.out.println(mainUser.getPortfolioList());
		
		getContentPane().setLayout(null);
		Panel panel = new Panel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(10, 227, 309, 129);
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		final List list = new List();
		
		/**
		list.addActionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				portfolioName = list.getSelectedItem();
			}
		});
		**/
		
		for (Portfolio port: mainUser.getPortfolioList())
		{
			list.add(port.getName());
		}
		panel.add(list);
		/*
		for (int i = 0; i < mainUser.getPortfolioList().size(); i++){
			JRadioButton rdbtnNewRadioButton = new JRadioButton(mainUser.getPortfolioList().get(i).getName());
			panel.add(rdbtnNewRadioButton);
			setVisible(true);
		}
		*/
		JButton btnNewButton = new JButton("View Portfolio Composition");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Portfolio port = new Portfolio("", "");
				String portfolioName = list.getSelectedItem();
				CompositionGUI composition = new CompositionGUI(mainUser, port, portfolioName);
				setVisible(false);
			}
		});
		
		btnNewButton.setBounds(10, 393, 309, 23);
		getContentPane().add(btnNewButton);
	
		JLabel lblChooseDesirePortfolio = new JLabel("Choose Desired Portfolio:");
		lblChooseDesirePortfolio.setBounds(10, 207, 309, 14);
		getContentPane().add(lblChooseDesirePortfolio);
		
		JLabel lblPortfolios = new JLabel("Portfolios");
		lblPortfolios.setForeground(new Color(255, 0, 0));
		lblPortfolios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPortfolios.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortfolios.setBounds(10, 0, 309, 25);
		getContentPane().add(lblPortfolios);
		
		JButton btnNewButton_1 = new JButton("Add Portfolio");
		btnNewButton_1.setBounds(10, 362, 309, 23);
		getContentPane().add(btnNewButton_1);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(SystemColor.desktop);
		panel_1.setBounds(10, 31, 309, 170);
		getContentPane().add(panel_1);
		
		JLabel lblTesting = new JLabel("testing");
		//lblTesting.setIcon(open "http://chart.finance.yahoo.com/w?s=GOOG");
		panel_1.add(lblTesting);
		
	}
}
