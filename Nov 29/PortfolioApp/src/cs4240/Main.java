package cs4240;

import cs4240.finance.StockBean;
import cs4240.gui.Login;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User mainUser = new User("Kate", "password");
		Portfolio newPortfolio = new Portfolio(mainUser.getUsername(),"Finance Portfolio");
		Portfolio port2 = new Portfolio(mainUser.getUsername(),"Sample Portfolio");
		
		Security genElectric = new Stock("General Electric", "GE", 11222013, 50);
		
		Security att = new Stock("AT&T", "T", 11222013, 50);
		Security goog = new Stock("Google", "GOOG", 11222013, 50);
		
		newPortfolio.addSecurity(genElectric);
		newPortfolio.addSecurity(att);
		port2.addSecurity(goog);
		mainUser.getPortfolioList().add(newPortfolio);
		mainUser.getPortfolioList().add(port2);
		
		StockBean sb = new StockBean();
		sb.setTicker(genElectric.getTicker());
		sb.getChartUrlSmall();
		System.out.println(sb.getChartUrlSmall());
		//System.load(sb.getChartUrlLarge());
		
		Login loginScreen = new Login(mainUser);
	}

}
