package SIM02;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GettingPrices 
{
    String coinName;

    public GettingPrices(String coinName) 
    {
        this.coinName = coinName;
    }
    
    public double Crypto()
    {
        double coinPrice=0;
        try
        {
            Document coin = Jsoup.connect("https://coinmarketcap.com/currencies/"+coinName+"/").get();
            String tempPrice = coin.select("div.priceValue___11gHJ").text();
            String tempPrice2 = "";
            for(int i=0;i<tempPrice.length();i++)
            {
                char c = tempPrice.charAt(i);
                if(Character.compare(c, '0')==0 || Character.compare(c, '1')==0 || Character.compare(c, '2')==0 || Character.compare(c, '3')==0 || Character.compare(c, '4')==0 || Character.compare(c, '5')==0 || Character.compare(c, '6')==0 || Character.compare(c, '7')==0 || Character.compare(c, '8')==0 || Character.compare(c, '9')==0 || Character.compare(c, '.')==0)
                    tempPrice2 = tempPrice2+c;
            }
            coinPrice = Double.parseDouble(tempPrice2);
        }
        catch(Exception e)
        {
            
        }
        return coinPrice;
    }
}
