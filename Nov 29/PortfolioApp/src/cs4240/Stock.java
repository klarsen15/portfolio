package cs4240;

import cs4240.finance.StockTickerDAO;

public class Stock extends Security{
	public Stock(String name, String ticker, int purchaseDate, int weight) {
		super(name, ticker, purchaseDate, weight);
		// TODO Auto-generated constructor stub
	}	
	
	private String industryName;
	private String sector;
	private boolean current;
	private String chartURL;
	
	StockTickerDAO stockDAO = new StockTickerDAO();
	
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public boolean isCurrent() {
		return current;
	}
	public void setCurrent(boolean current) {
		this.current = current;
	}
	
	public void setChartURL(String chartURL) {
		this.chartURL = chartURL;
	}

	
	
	
}
