package cs4240;

import java.io.IOException;

import cs4240.finance.StockBean;
import cs4240.gui.Login;

public class Main {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		User mainUser = new User("Kate", "password");
		Portfolio finPort = new Portfolio(mainUser.getUsername(),"Finance Portfolio");
		Portfolio port2 = new Portfolio(mainUser.getUsername(),"Sample Portfolio");
		
		Security goog = new Stock("GOOG");
		System.out.println(goog.getPrice());
		
		Security sp = new Index("gspc");
		System.out.println(sp.getPrice());
		
		
		//genElectric.setTicker("GE");
		
		Security att = new Stock("T");
		
		
		//Security goog = new Stock();
		//goog.setTicker("GOOG");
		
		
		/*
		Security genElectric = new Stock("General Electric", "GE", 11222013, 50);
		
		Security att = new Stock("AT&T", "T", 11222013, 50);
		Security goog = new Stock("Google", "GOOG", 11222013, 50);
		*/
		
		//finPort.addSecurity(genElectric);
		//finPort.addSecurity(att);
		finPort.addSecurity(goog);
		finPort.addSecurity(att);
		finPort.addSecurity(sp);
		port2.addSecurity(goog);
		
		mainUser.getPortfolioList().add(finPort);
		mainUser.getPortfolioList().add(port2);
		
		//StockBean sb = new StockBean();
		//sb.setTicker(genElectric.getTicker());
		
		
		Login loginScreen = new Login(mainUser);
	}

}
