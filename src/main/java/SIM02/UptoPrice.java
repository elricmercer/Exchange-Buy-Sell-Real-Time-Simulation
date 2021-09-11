package SIM02;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UptoPrice implements Runnable
{
    
    GettingPrices gp = new GettingPrices("");
    
    @Override()
    public void run()
    {
        String exName = "Finance";
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
        String msg = "BTC: $"+btcPrice+", ETH: $"+ethPrice+", ADA: $"+adaPrice+", XRP: $"+xrpPrice+", DODGE: $"+dogePrice+" **|** TIME: "+d.toString();
        ConnectionFactory fact = new ConnectionFactory();
        try(Connection conn = fact.newConnection()){
            Channel chn = conn.createChannel();
            chn.exchangeDeclare(exName, "fanout");
            chn.basicPublish(exName, "", false, null, msg.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(UptoPrice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            Logger.getLogger(UptoPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("BTC: $"+btcPrice+", ETH: $"+ethPrice+", ADA: $"+adaPrice+", XRP: $"+xrpPrice+", DODGE: $"+dogePrice+" **|** TIME: "+d.toString());
    }
}
