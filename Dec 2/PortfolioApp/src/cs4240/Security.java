package cs4240;

public abstract class Security {
    String ticker;
    float price;
    String currentdate;
    float month_price; //price 1 month ago
    float halfy_price; //price 6 months ago
    float y_price; //price 1 year ago
    long lastUpdated;
    
    public Security(){};
    public Security(String ticker, float price, String currentdate, float month_price, 
        		float halfy_price, float y_price, long lastUpdated) {
    	this.ticker = ticker;
    	this.price = price;
    	this.currentdate = currentdate;
    	this.month_price = month_price;
    	this.halfy_price = halfy_price;
    	this.y_price = y_price;
    	this.lastUpdated = lastUpdated;
    		   	
    }
    public long getLastUpdated(){
    	return lastUpdated;
    }
 
    public String getDate(){
        return currentdate;
    }
    public void setDate(String currentdate){
        this.currentdate = currentdate;
    }
    
    public String getTicker(){
        return ticker;
    }
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
    public float getMonthPrice() {
        return month_price;
    }
    public void setMonthPrice(float month_price) {
        this.month_price = month_price;
    }
    public float getHalfYPrice() {
        return halfy_price;
    }
    public void setHalfYPrice(float hy_price) {
        this.halfy_price = hy_price;
    }
    public float getYPrice() {
        return y_price;
    }
    public void setYPrice(float y_price) {
        this.y_price = y_price;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}