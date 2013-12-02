package cs4240;

public abstract class Security{
	private int weight;
	private int purchaseDate;
	private double currentPrice;
	private double historicalPrice;
	private String ticker;
	private String name;
	private String chartURL;
	
	public Security(String name, String ticker, int purchaseDate, int weight){
		this.name = name;
		this.ticker = ticker;
		
		//make the weight to automatically equal out
		this.weight = weight;
		this.historicalPrice = getHistoricalPrice(ticker, purchaseDate);
		this.currentPrice = getCurrentPrice(ticker);
	}
	
	public String getChartURL() {
		return "http://chart.finance.yahoo.com/w?s="+this.getTicker();
	}
	
	public void updateWeight(){
		
	}
	
	public void calculateReturn(){
		
	}

	public double getHistoricalPrice(String ticker, int purchaseDate){
		double price = 0.0;
		//get form api
		return price;
	}
	public double getCurrentPrice(String ticker){
		double price = 0.0;
		//get form api
		return price;
		
	}
	public String getName(){
		return name;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(int purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public double getHistoricalPrice() {
		return historicalPrice;
	}

	public void setHistoricalPrice(double historicalPrice) {
		this.historicalPrice = historicalPrice;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public void setName(String name) {
		this.name = name;
	}
}
