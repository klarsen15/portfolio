package cs4240;

import cs4240.gui.Login;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User mainUser = new User("Kate", "password");
		Portfolio newPortfolio = new Portfolio(mainUser.getUsername(),"Finance Portfolio");
		
		Security genElectric = new Stock("General Electric", "GE", 11222013, 50);
		newPortfolio.addSecurity(genElectric);
		mainUser.getPortfolioList().add(newPortfolio);
		
		Login loginScreen = new Login(mainUser);
	}

}
