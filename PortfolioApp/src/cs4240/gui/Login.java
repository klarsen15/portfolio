package cs4240.gui;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
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

public class Login extends JFrame {
	private JTextField txtUsername;
	private JPasswordField passwordField;
	public Login(final User mainUser) {
		setSize(345, 465);
		setVisible(true);
		
		
		System.out.println(mainUser.getUsername());
		
		getContentPane().setLayout(null);
		
		JButton btnLogIn = new JButton("Log In");
	
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PortfolioGUI portfolioScreen = new PortfolioGUI(mainUser);
				setVisible(false);
				
			}
		});
		btnLogIn.setBounds(124, 306, 89, 23);
		getContentPane().add(btnLogIn);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setBounds(104, 340, 125, 23);
		getContentPane().add(btnForgotPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(148, 128, 86, 20);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("password");
		passwordField.setBounds(148, 160, 86, 20);
		getContentPane().add(passwordField);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(45, 131, 70, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(45, 163, 70, 14);
		getContentPane().add(lblPassword);
		
		JLabel lblPortfolioSimulator = new JLabel("Portfolio Simulator");
		lblPortfolioSimulator.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortfolioSimulator.setBounds(104, 43, 153, 20);
		getContentPane().add(lblPortfolioSimulator);
	}
}
