package cs4240.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import cs4240.Portfolio;
import cs4240.User;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPortfolio extends JFrame {
	private JTextField txtPortName;
	public AddPortfolio(final User mainUser) {
		setTitle("Add Portfolio");
		setSize(345, 217);
		getContentPane().setLayout(null);
		setVisible(true);
		
		JLabel lblAddAPortfolio = new JLabel("Add a Portfolio");
		lblAddAPortfolio.setBounds(0, 11, 278, 17);
		lblAddAPortfolio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddAPortfolio.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblAddAPortfolio);
		
		txtPortName = new JTextField();
		txtPortName.setBounds(116, 68, 133, 26);
		txtPortName.setToolTipText("Enter Portfolio Name\r\n");
		getContentPane().add(txtPortName);
		txtPortName.setColumns(10);
		
		JLabel lblEnterPortfolioName = new JLabel("Enter Portfolio Name");
		lblEnterPortfolioName.setBounds(10, 74, 109, 14);
		getContentPane().add(lblEnterPortfolioName);
		
		JButton btnAddPortfolio = new JButton("Add Portfolio");
		btnAddPortfolio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainUser.getPortfolioList().add(new Portfolio(mainUser.getUsername(), txtPortName.getText()));
				setVisible(false);
				PortfolioGUI portGUI = new PortfolioGUI(mainUser, mainUser.getPortfolioList());
			}
		});
		btnAddPortfolio.setBounds(83, 135, 133, 23);
		getContentPane().add(btnAddPortfolio);
	}
}
