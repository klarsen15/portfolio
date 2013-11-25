package cs4240.gui;

import javax.swing.JFrame;
import javax.swing.JButton;

import cs4240.Portfolio;
import cs4240.Security;
import cs4240.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JRadioButton;
import java.awt.List;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class CompositionGUI extends JFrame {
	public CompositionGUI(final User mainUser, Portfolio portfolio) {
		setSize(345, 465);
		getContentPane().setLayout(null);
		
		
		JButton btnViewPerformance = new JButton("View Performance");
		btnViewPerformance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Performance performance = new Performance(mainUser);
				setVisible(false);
			}
		});
		btnViewPerformance.setBounds(10, 361, 309, 23);
		getContentPane().add(btnViewPerformance);
		
		JButton btnViewPortfolios = new JButton("View Portfolios");
		btnViewPortfolios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PortfolioGUI portfolio = new PortfolioGUI(mainUser);
				setVisible(false);
			}
		});
		btnViewPortfolios.setBounds(10, 395, 309, 23);
		getContentPane().add(btnViewPortfolios);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 195, 309, 152);
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		List list = new List();
		for (Security sec: mainUser.getPortfolioList().get(0).getSecurityList())
		{
			list.add(sec.getName() + " " + sec.getTicker());
			JRadioButton rdbtnNewRadioButton = new JRadioButton(sec.getTicker());
			panel.add(rdbtnNewRadioButton);
		}
		panel.add(list);
		
		
		
		JLabel lblViewPerf = new JLabel("View Details");
		lblViewPerf.setBounds(210, 170, 94, 14);
		getContentPane().add(lblViewPerf);
		
		JLabel lblPortComp = new JLabel("Portfolio Composition");
		lblPortComp.setBounds(10, 170, 190, 14);
		getContentPane().add(lblPortComp);
		
		JLabel lblPortfolioComposition = new JLabel("Portfolio Composition");
		lblPortfolioComposition.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortfolioComposition.setBounds(10, 11, 309, 14);
		getContentPane().add(lblPortfolioComposition);
		
		JPanel panel_details = new JPanel();
		panel_details.setBackground(SystemColor.desktop);
		panel_details.setBounds(10, 36, 309, 123);
		getContentPane().add(panel_details);
		setVisible(true);
		
	}
}
