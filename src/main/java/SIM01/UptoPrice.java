package SIM01;

import java.util.Date;

public class UptoPrice implements Runnable
{
    
    GettingPrices gp = new GettingPrices("");
    
    @Override()
    public void run()
    {
        Date d = new Date();
        String coinName = "";
        coinName = "bitcoin";
        gp.coinName = coinName;
        double btcPrice = gp.Crypto();
        coinName = "ethereum";
        gp.coinName = coinName;
        double ethPrice = gp.Crypto();
        coinName = "cardano";
        gp.coinName = coinName;
        double adaPrice = gp.Crypto();
        coinName = "xrp";
        gp.coinName = coinName;
        double xrpPrice = gp.Crypto();
        System.out.println();
        coinName = "dogecoin";
        gp.coinName = coinName;
        double dogePrice = gp.Crypto();
        System.out.println("BTC: $"+btcPrice+", ETH: $"+ethPrice+", ADA: $"+adaPrice+", XRP: $"+xrpPrice+", DODGE: $"+dogePrice+" **|** TIME: "+d.toString());
    }
}
