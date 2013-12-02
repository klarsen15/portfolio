package cs4240.gui;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JButton;

import cs4240.Portfolio;
import cs4240.Security;
import cs4240.SecurityDAO;
import cs4240.User;
import cs4240.finance.StockBean;
import cs4240.finance.StockTickerDAO;

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
import java.net.MalformedURLException;
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
import javax.swing.JTable;

public class Performance extends JFrame {
	private final JButton btnPortfolio = new JButton("View Portfolios");
	private JTable dataTable;
	public Performance(final User mainUser, final String portfolioName, final ArrayList<Security> securityList) {
		setTitle("Performance");
		
		setSize(593, 529);
		setVisible(true);
		btnPortfolio.setBounds(339, 458, 228, 23);
		
		btnPortfolio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PortfolioGUI portfolio = new PortfolioGUI(mainUser, mainUser.getPortfolioList());
				setVisible(false);
			}
		});
		getContentPane().setLayout(null);
		
		final JList dataType = new JList();
		dataType.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		dataType.setBackground(SystemColor.desktop);
		dataType.setForeground(new Color(0, 0, 0));
		dataType.setModel(new AbstractListModel() {
			String[] values = new String[] {"Chart", "Data"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		dataType.setSelectedIndex(0);
		dataType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dataType.setBounds(525, 36, 42, 123);
		getContentPane().add(dataType);
		getContentPane().add(btnPortfolio);
		
		final List list = new List();
		list.setBounds(20, 345, 309, 136);
		getContentPane().add(list);
		
		JButton btnReturnToComposition = new JButton("View Composition");
		btnReturnToComposition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompositionGUI comp = new CompositionGUI(mainUser, portfolioName, securityList);
				setVisible(false);
			}
		});
		btnReturnToComposition.setBounds(339, 424, 228, 23);
		getContentPane().add(btnReturnToComposition);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 345, 309, 136);
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		/*
		int portIndex=0;
		for (int i =0; i< mainUser.getPortfolioList().size(); i++){
			if (mainUser.getPortfolioList().get(i).getName().equals(portfolioName)){
				portIndex = i;
			}
		}
		final ArrayList<Security>  securityList = mainUser.getPortfolioList().get(portIndex).getSecurityList();
		*/
		for (Security sec: securityList)
		{
			list.add(sec.getTicker());
		}
		
		JLabel lblPortfolioComposition = new JLabel("Portfolio Composition");
		lblPortfolioComposition.setBounds(20, 325, 190, 14);
		getContentPane().add(lblPortfolioComposition);
		
		final JLabel lblPortfolioPerformance = new JLabel("Select to View Performance");
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
		
		String columnNames[] = {"Ticker", "Price", "Month Price", "Previous Half Year Price", "Previous Year Price"};
		Object dataValues[][] = {{""},{""},{""},{""},{""}};
		dataTable = new JTable(dataValues, columnNames);
		dataTable.setFillsViewportHeight(true);
		dataTable.setBackground(SystemColor.activeCaption);
		dataTable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		dataTable.setBounds(298, 191, -281, -163);
		dataTable.setVisible(true);
		
		panel_performance.add(dataTable);
		
		final JLabel lblDataOutput = new JLabel(" ");
		lblDataOutput.setBounds(0, 0, 512, 288);
		lblDataOutput.setIcon(new ImageIcon("C:\\Users\\Student\\Documents\\GitHub\\portfolio\\yahoo finance new logo.png"));
		panel_performance.add(lblDataOutput);
		
		final JLabel lblInput = new JLabel(" ");
		lblInput.setBounds(525, 183, 46, 14);
		getContentPane().add(lblInput);
		
		JButton btnViewPerformance = new JButton("Update Performance");
		btnViewPerformance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tickerSend = list.getSelectedItem();	
				int tickerIndex = list.getSelectedIndex();
				int inputType = dataType.getSelectedIndex();
				if (inputType == 0){
					try {
						lblDataOutput.setIcon(new ImageIcon(ImageIO.read(new URL("http://chart.finance.yahoo.com/w?s="+tickerSend))));
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				else if (inputType == 1){
					lblDataOutput.setIcon(null);
					lblDataOutput.setText("Ticker: " + tickerSend + "\n Price: "+securityList.get(tickerIndex).getPrice());
				}
				
				setTitle("Performance for " + tickerSend);
				lblPortfolioPerformance.setText("Performance " + (String)dataType.getSelectedValue()+" for "+tickerSend);
			}
		});
		btnViewPerformance.setBounds(339, 345, 228, 50);
		getContentPane().add(btnViewPerformance);
		

		
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tickerSend = list.getSelectedItem().split(",")[1].trim();
				Performance performance = new Performance(mainUser, portfolioName, securityList);
				setVisible(false);
			}
		});
		
		
	}
}
