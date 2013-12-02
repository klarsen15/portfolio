package cs4240.gui;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import cs4240.User;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JEditorPane;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Login extends JFrame {
	private JTextField txtUsername;
	private JPasswordField passwordField;
	public Login(final User mainUser) {
		setTitle("Log In");
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		setSize(345, 465);
		setVisible(true);
		
		
		System.out.println(mainUser.getUsername());
		
		getContentPane().setLayout(null);
		
		JButton btnLogIn = new JButton("Log In");
	
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PortfolioGUI portfolioScreen = new PortfolioGUI(mainUser);
				setVisible(false);
				//Desktop desktop = getDesktop();
				
			}
		});
		btnLogIn.setBounds(10, 359, 309, 23);
		getContentPane().add(btnLogIn);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setBounds(10, 393, 309, 23);
		getContentPane().add(btnForgotPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsername.setBounds(164, 248, 86, 20);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setToolTipText("password");
		passwordField.setBounds(164, 280, 86, 20);
		getContentPane().add(passwordField);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(61, 251, 93, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(61, 283, 93, 14);
		getContentPane().add(lblPassword);
		
		JLabel lblPortfolioSimulator = new JLabel("Portfolio Simulator");
		lblPortfolioSimulator.setForeground(new Color(255, 0, 0));
		lblPortfolioSimulator.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPortfolioSimulator.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortfolioSimulator.setBounds(10, 34, 309, 20);
		getContentPane().add(lblPortfolioSimulator);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Student\\Documents\\GitHub\\portfolio\\yahoo finance new logo.png"));
		lblNewLabel.setBounds(10, 65, 309, 141);
		getContentPane().add(lblNewLabel);
	}
}
