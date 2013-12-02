package cs4240;

import java.util.ArrayList;

public class Portfolio {
	
	private String user;
	private String name;
	private ArrayList<Security> securityList = new ArrayList<Security>();
	private int purchaseDate;
	
	public Portfolio(String username, String name){
		this.user = username;
		this.name = name;
	}
	
	public void addSecurity(Security securityToAdd){	
		securityList.add(securityToAdd);
	}
	
	public void removeSecurity(){
		
	}
	
	public double returnOnStock(String ticker){
		double stockReturn=0.0;
		return stockReturn;
	}
	
	public double returnOnIndex(String ticker){
		double indexReturn=0.0;
		return indexReturn;
	}
	
	public void industryPerformance(String industryName){
		
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Security> getSecurityList() {
		return securityList;
	}

	public void setSecurityList(ArrayList<Security> securityList) {
		this.securityList = securityList;
	}

	public int getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(int purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}
