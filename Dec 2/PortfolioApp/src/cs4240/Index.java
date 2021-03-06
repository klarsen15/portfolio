package cs4240;

public class Index extends Security{

	public Index(String ticker, float price, String currentdate, float month_price, 
    		float halfy_price, float y_price, long lastUpdated) {
            super(ticker, price, currentdate, month_price, 
            		halfy_price, y_price, lastUpdated);
            // TODO Auto-generated constructor stub
    }
	public Index(){};
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException{
		Security  abstract_stock = SecurityDAO.getInstance().getStockPrice("%5Egspc"); //specify Index here
		Index i = new Index();
		i.setPrice(abstract_stock.getPrice());
    	i.setTicker(abstract_stock.getTicker());
    	i.setDate(abstract_stock.getDate());
    	i.setMonthPrice(abstract_stock.getMonthPrice());
    	i.setHalfYPrice(abstract_stock.getHalfYPrice());
    	i.setYPrice(abstract_stock.getYPrice());
    	System.out.println(i.getPrice());
    	System.out.println(i.getTicker());
    	System.out.println(i.getDate());
    	System.out.println(i.getMonthPrice());
    	System.out.println(i.getHalfYPrice());
    	System.out.println(i.getYPrice());
	}
	
	public Index(String ticker) throws InstantiationException, IllegalAccessException{
		Security  abstract_stock = SecurityDAO.getInstance().getStockPrice("%5E"+ticker); //specify Index here
		//Index i = new Index();
		this.setPrice(abstract_stock.getPrice());
    	this.setTicker(abstract_stock.getTicker());
    	this.setDate(abstract_stock.getDate());
    	this.setMonthPrice(abstract_stock.getMonthPrice());
    	this.setHalfYPrice(abstract_stock.getHalfYPrice());
    	this.setYPrice(abstract_stock.getYPrice());
    	
	}

}
