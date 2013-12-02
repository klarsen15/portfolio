package cs4240;

import java.util.ArrayList;

public class User {
	

	private String username;
	private String password;
	private ArrayList<Portfolio> portfolioList = new ArrayList<Portfolio>();
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public void createPortfolio(String portName){
		Portfolio newPortfolio = new Portfolio(this.username, portName);
		portfolioList.add(newPortfolio);
	}
	public void deletePortfolio(String portName){
		for (int i = 0; i < portfolioList.size(); i++){
			if (portfolioList.get(i).getName().equals(portName)){
				portfolioList.remove(i);
			}
		}
	}
	public void deleteAccount(){
		
	}
	
	public void comparePortfolio(Portfolio A, Portfolio B){
		
	}
	public ArrayList<Portfolio> rankPortfolios(ArrayList<Portfolio> list){
		ArrayList<Portfolio> ranked = new ArrayList<Portfolio>();
		//use iterator on list
		
		return ranked;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Portfolio> getPortfolioList() {
		return portfolioList;
	}

	public void setPortfolioList(ArrayList<Portfolio> portfolioList) {
		this.portfolioList = portfolioList;
	}

}
