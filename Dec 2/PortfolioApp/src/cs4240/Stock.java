package cs4240;

import java.io.IOException;


public class Stock extends Security{
        public Stock(String ticker, float price, String currentdate, float month_price, 
        		float halfy_price, float y_price, long lastUpdated) {
                super(ticker, price, currentdate, month_price, 
                		halfy_price, y_price, lastUpdated);
                // TODO Auto-generated constructor stub
        }
        public Stock(){};
        private String industry;
        private String sector;
        public String getSec() {
            return sector;
        }
        public void setSec(String sector) {
            this.sector = sector;
        }
        public String getInd() {
            return industry;
        }
        public void setInd(String ind) {
            this.industry = ind;
        }
        public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        	Security  abstract_stock = SecurityDAO.getInstance().getStockPrice("GOOG"); //specify Stock here
        	Stock stock = (Stock) abstract_stock.getClass().newInstance();
        	StockSpecificDAO.getInstance().updateInd(stock);
        	stock.setPrice(abstract_stock.getPrice());
        	stock.setTicker(abstract_stock.getTicker());
        	stock.setDate(abstract_stock.getDate());
        	stock.setMonthPrice(abstract_stock.getMonthPrice());
        	stock.setHalfYPrice(abstract_stock.getHalfYPrice());
        	stock.setYPrice(abstract_stock.getYPrice());
        	
        }
        public Stock(String ticker) throws IOException, InstantiationException, IllegalAccessException {
        	Security  abstract_stock = SecurityDAO.getInstance().getStockPrice(ticker); //specify Stock here
        	//Stock stock = (Stock) abstract_stock.getClass().newInstance();
        	StockSpecificDAO.getInstance().updateInd((Stock) abstract_stock);
        	this.setPrice(abstract_stock.getPrice());
        	this.setTicker(abstract_stock.getTicker());
        	this.setDate(abstract_stock.getDate());
        	this.setMonthPrice(abstract_stock.getMonthPrice());
        	this.setHalfYPrice(abstract_stock.getHalfYPrice());
        	this.setYPrice(abstract_stock.getYPrice());
        	
        }
}

