package cs4240.gui;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JButton;

import cs4240.Portfolio;
import cs4240.Security;
import cs4240.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JRadioButton;
import java.awt.List;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.border.BevelBorder;
import javax.swing.JTabbedPane;
import java.awt.Canvas;
import java.awt.Button;
import javax.swing.JTable;

public class CompositionGUI extends JFrame {
	private JTable table;
	public CompositionGUI(final User mainUser, final String portfolioName, final ArrayList<Security> securityList){
		setTitle("Composition for " + portfolioName);
		setSize(345, 465);
		getContentPane().setLayout(null);
		final Window window;
		final Security tempSecurity;
		
		
		JButton btnViewPortfolios = new JButton("View Portfolios");
		btnViewPortfolios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PortfolioGUI portfolio = new PortfolioGUI(mainUser, mainUser.getPortfolioList());
				setVisible(false);
			}
		});
		btnViewPortfolios.setBounds(10, 395, 309, 23);
		getContentPane().add(btnViewPortfolios);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 195, 309, 134);
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		final List list = new List();
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
		panel.add(list);
		

		
		JLabel lblPortfolioComposition = new JLabel("Composition for "+portfolioName);
		lblPortfolioComposition.setForeground(new Color(255, 0, 0));
		lblPortfolioComposition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPortfolioComposition.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortfolioComposition.setBounds(10, 0, 309, 35);
		getContentPane().add(lblPortfolioComposition);
		
		JPanel panel_details = new JPanel();
		panel_details.setBackground(SystemColor.desktop);
		panel_details.setBounds(10, 33, 309, 134);
		getContentPane().add(panel_details);
		
		final JLabel labelPic = new JLabel("");
		panel_details.add(labelPic);
		
		JButton btnAddSecurity = new JButton("Add Security");
		btnAddSecurity.setBounds(10, 170, 150, 23);
		getContentPane().add(btnAddSecurity);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEdit.setBounds(169, 170, 150, 23);
		getContentPane().add(btnEdit);
		setVisible(true);//Security tempSecurity2 = new Security("","",0,0);
		final String securityURL;
		final Desktop d = Desktop.getDesktop();
		final Image chartImage = null;
		
		
		JButton btnViewPerformance = new JButton("View Performance");
		btnViewPerformance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String tickerSend = list.getSelectedItem().trim();
				/**
				for (int i=0; i < securityList.size(); i++){
					if (securityList.get(i).getTicker().equals(tickerSend)){
						 //securityURL = securityList.get(i).getChartURL();
						 try {
							 labelPic.setIcon(new ImageIcon(ImageIO.read(new URL(securityList.get(i).getChartURL()))));
							 d.browse(new URI(securityList.get(i).getChartURL()));
							//labelPic.setIcon(new ImageIcon(ImageIO.read(new URL(securityList.get(i).getChartURL()))));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
					}
				}
				*/
				Performance performance = new Performance(mainUser, portfolioName, securityList);
				setVisible(false);
				
			}
		});
		btnViewPerformance.setBounds(10, 361, 309, 23);
		getContentPane().add(btnViewPerformance);

		
	}
}
