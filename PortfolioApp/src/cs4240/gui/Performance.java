package cs4240.gui;

import javax.swing.JFrame;
import javax.swing.JButton;

import cs4240.Portfolio;
import cs4240.User;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.List;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Performance extends JFrame {
	private final JButton btnPortfolio = new JButton("View Portfolios");
	public Performance(final User mainUser) {
		
		setSize(345, 465);
		setVisible(true);
		btnPortfolio.setBounds(10, 393, 309, 23);
		
		btnPortfolio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PortfolioGUI portfolio = new PortfolioGUI(mainUser);
				setVisible(false);
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnPortfolio);
		
		JButton btnReturnToComposition = new JButton("View Composition");
		btnReturnToComposition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//CompositionGUI comp = new CompositionGUI(mainUser);
				setVisible(false);
			}
		});
		btnReturnToComposition.setBounds(10, 360, 309, 23);
		getContentPane().add(btnReturnToComposition);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 195, 309, 152);
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		List list = new List();
		panel.add(list);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		panel.add(rdbtnNewRadioButton);
		
		JLabel lblViewPerformance = new JLabel("View Performance");
		lblViewPerformance.setBounds(210, 170, 94, 14);
		getContentPane().add(lblViewPerformance);
		
		JLabel lblPortfolioComposition = new JLabel("Portfolio Composition");
		lblPortfolioComposition.setBounds(10, 170, 190, 14);
		getContentPane().add(lblPortfolioComposition);
		
		JLabel lblPortfolioPerformance = new JLabel("Portfolio Performance");
		lblPortfolioPerformance.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortfolioPerformance.setBounds(10, 11, 309, 14);
		getContentPane().add(lblPortfolioPerformance);
		
		JPanel panel_performance = new JPanel();
		panel_performance.setBackground(SystemColor.desktop);
		panel_performance.setBounds(10, 36, 309, 123);
		getContentPane().add(panel_performance);
		setVisible(true);
	}
}
