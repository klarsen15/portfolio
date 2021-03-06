package cs4240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class StockSpecificDAO {
	private static final StockSpecificDAO ssDAO = new StockSpecificDAO();
	private StockSpecificDAO() {}
	 
    public static StockSpecificDAO getInstance() {
        return ssDAO;
    }
    
    public Stock updateInd(Stock s) throws IOException{
      URL url = new URL("http://finance.yahoo.com/q?s=c");
  	  URLConnection spoof = url.openConnection();
  	 
  	  //Spoof the connection so we look like a web browser
  	  spoof.setRequestProperty( "User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)" );
  	  BufferedReader in = new BufferedReader(new InputStreamReader(spoof.getInputStream()));
  	  String strLine = "";
  	  while ((strLine = in.readLine()) != null){
  		  if(strLine.contains("Sector</span><ul><li><a href=")){
  			  int loc = strLine.indexOf("conameu.html") + 14; //beginning index of sector name
  			  int loc2 = strLine.indexOf("Industry") - 43;
  			  String sectorname = strLine.substring(loc,loc2);
  			  int loc3 = strLine.indexOf("biz.yahoo.com/ic/") + 27;
  			  int loc4 = strLine.indexOf("yfi_key_stats") - 51;
  			  String industryname = strLine.substring(loc3,loc4);
  			  s.setSec(sectorname);
  			  s.setInd(industryname);
  			  }
  	  }
    	return s;
    }
    
    
}

