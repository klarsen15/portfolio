package cs4240.gui;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JButton;

import cs4240.Portfolio;
import cs4240.Security;
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

import java.awt.Desktop;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class Performance extends JFrame {
	private final JButton btnPortfolio = new JButton("View Portfolios");
	public Performance(final User mainUser, final String portfolioName, final String ticker) {
		setTitle("Performance for " + ticker);
		
		setSize(593, 529);
		setVisible(true);
		btnPortfolio.setBounds(339, 458, 228, 23);
		
		btnPortfolio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PortfolioGUI portfolio = new PortfolioGUI(mainUser);
				setVisible(false);
			}
		});
		getContentPane().setLayout(null);
		
		JList list_1 = new JList();
		list_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		list_1.setBackground(SystemColor.desktop);
		list_1.setForeground(new Color(0, 0, 0));
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"Chart", "Data", "Graph"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setSelectedIndex(0);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBounds(525, 36, 42, 123);
		getContentPane().add(list_1);
		getContentPane().add(btnPortfolio);
		
		final List list = new List();
		list.setBounds(20, 345, 309, 136);
		getContentPane().add(list);
		
		JButton btnReturnToComposition = new JButton("View Composition");
		btnReturnToComposition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//CompositionGUI comp = new CompositionGUI(mainUser);
				setVisible(false);
			}
		});
		btnReturnToComposition.setBounds(339, 424, 228, 23);
		getContentPane().add(btnReturnToComposition);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 345, 309, 136);
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		int portIndex=0;
		for (int i =0; i< mainUser.getPortfolioList().size(); i++){
			if (mainUser.getPortfolioList().get(i).getName().equals(portfolioName)){
				portIndex = i;
			}
		}
		final ArrayList<Security>  securityList = mainUser.getPortfolioList().get(portIndex).getSecurityList();
		for (Security sec: securityList)
		{
			list.add(String.format("%s, %s", sec.getName(), sec.getTicker()));
		}
		
		JLabel lblPortfolioComposition = new JLabel("Portfolio Composition");
		lblPortfolioComposition.setBounds(20, 325, 190, 14);
		getContentPane().add(lblPortfolioComposition);
		
		final JLabel lblPortfolioPerformance = new JLabel("Performance for "+ticker);
		lblPortfolioPerformance.setForeground(new Color(255, 0, 0));
		lblPortfolioPerformance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPortfolioPerformance.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortfolioPerformance.setBounds(10, 11, 512, 14);
		getContentPane().add(lblPortfolioPerformance);
		
		JPanel panel_performance = new JPanel();
		panel_performance.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_performance.setBackground(SystemColor.desktop);
		panel_performance.setBounds(10, 36, 512, 288);
		getContentPane().add(panel_performance);
		panel_performance.setLayout(null);
		
		final JLabel lblChart = new JLabel(" ");
		lblChart.setIcon(new ImageIcon("C:\\Users\\Student\\Documents\\GitHub\\portfolio\\yahoo finance new logo.png"));
		
		lblChart.setBounds(0, 0, 512, 288);
		panel_performance.add(lblChart);
		
		final Desktop d = Desktop.getDesktop();
		final Image chartImage = null;
		
		JButton btnViewPerformance = new JButton("Update Performance");
		btnViewPerformance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tickerSend = list.getSelectedItem().split(",")[1].trim();
				
				for (int i=0; i < securityList.size(); i++){
					if (securityList.get(i).getTicker().equals(tickerSend)){
						 //securityURL = securityList.get(i).getChartURL();
						 try {
							 lblChart.setIcon(new ImageIcon(ImageIO.read(new URL(securityList.get(i).getChartURL()))));
							 d.browse(new URI(securityList.get(i).getChartURL()));
							//lblChart.setIcon(new ImageIcon(ImageIO.read(new URL(securityList.get(i).getChartURL()))));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
					}
				}
				setTitle("Performance for " + tickerSend);
				lblPortfolioPerformance.setText("Performance for "+tickerSend);
				//Performance performance = new Performance(mainUser, portfolioName, tickerSend);
				//setVisible(false);
			}
		});
		btnViewPerformance.setBounds(339, 345, 228, 50);
		getContentPane().add(btnViewPerformance);
		
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tickerSend = list.getSelectedItem().split(",")[1].trim();
				Performance performance = new Performance(mainUser, portfolioName, tickerSend);
				setVisible(false);
			}
		});
		
		
	}
}
