package SIM01;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class CryptoX 
{
    //BTC=0,ETH=1,ADA=2,XRP=3,DOGE=4
    
    GettingPrices gp = new GettingPrices("");
    
    LinkedBlockingQueue<String> BTC = new LinkedBlockingQueue(1);
    LinkedBlockingQueue<String> ETH = new LinkedBlockingQueue(1);
    LinkedBlockingQueue<String> ADA = new LinkedBlockingQueue(1);
    LinkedBlockingQueue<String> XRP = new LinkedBlockingQueue(1);
    LinkedBlockingQueue<String> DOGE = new LinkedBlockingQueue(1);
    
    DecimalFormat deno = new DecimalFormat("#0.00000000");
    
    Date d = new Date();
    
    Random rand = new Random();
    
    public void BTC(People p)
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            
        }
        gp.coinName = "bitcoin";
        double btcPrice = gp.Crypto();
        try
        {
            BTC.put(p.name);
        }
        catch(Exception e)
        {
            
        }
        if(p.chBuySell==0)
        {
            p.coin.cp.btc = p.coin.USD/btcPrice;
            System.out.println("USER: "+p.name+" bought BTC "+deno.format(p.coin.cp.btc)+", with $"+p.coin.USD+" @ $"+btcPrice+" | TIME: "+d.toString());
            try
            {
                BTC.take();
            }
            catch(Exception e)
            {
                
            }
        }
        else if(p.chBuySell==1)
        {
            
            p.coin.USD = p.coin.cp.btc*btcPrice;
            System.out.println("USER: "+p.name+" sold BTC "+deno.format(p.coin.cp.btc)+", received $"+p.coin.USD+" @ $"+btcPrice+" | TIME: "+d.toString());
            try
            {
                BTC.take();
            }
            catch(Exception e)
            {
                
            }
        }
        else
            System.out.println("PERSON: "+p.name+" has faced an ERROR...!!");
        int time = rand.nextInt(5);
        try
        {
            Thread.sleep(1000*time);
        }
        catch(Exception e)
        {
            
        }
    }
    
    public void ETH(People p)
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            
        }
        gp.coinName = "ethereum";
        double ethPrice = gp.Crypto();
        try
        {
            ETH.put(p.name);
        }
        catch(Exception e)
        {
            
        }
        if(p.chBuySell==0)
        {
            p.coin.cp.eth = p.coin.USD/ethPrice;
            System.out.println("USER: "+p.name+" bought ETH "+deno.format(p.coin.cp.eth)+", with $"+p.coin.USD+" @ $"+ethPrice+" | TIME: "+d.toString());
            try
            {
                ETH.take();
            }
            catch(Exception e)
            {
                
            }
        }
        else if(p.chBuySell==1)
        {
            
            p.coin.USD = p.coin.cp.eth*ethPrice;
            System.out.println("USER: "+p.name+" sold ETH "+deno.format(p.coin.cp.eth)+", received $"+p.coin.USD+" @ $"+ethPrice+" | TIME: "+d.toString());
            try
            {
                ETH.take();
            }
            catch(Exception e)
            {
                
            }
        }
        else
            System.out.println("PERSON: "+p.name+" has faced an ERROR...!!");
        int time = rand.nextInt(5);
        try
        {
            Thread.sleep(1000*time);
        }
        catch(Exception e)
        {
            
        }
    }
    
    public void ADA(People p)
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            
        }
        gp.coinName = "cardano";
        double adaPrice = gp.Crypto();
        try
        {
            ADA.put(p.name);
        }
        catch(Exception e)
        {
            
        }
        if(p.chBuySell==0)
        {
            p.coin.cp.ada = p.coin.USD/adaPrice;
            System.out.println("USER: "+p.name+" bought ADA "+deno.format(p.coin.cp.ada)+", with $"+p.coin.USD+" @ $"+adaPrice+" | TIME: "+d.toString());
            try
            {
                ADA.take();
            }
            catch(Exception e)
            {
                
            }
        }
        else if(p.chBuySell==1)
        {
            
            p.coin.USD = p.coin.cp.ada*adaPrice;
            System.out.println("USER: "+p.name+" sold ADA "+deno.format(p.coin.cp.ada)+", received $"+p.coin.USD+" @ $"+adaPrice+" | TIME: "+d.toString());
            try
            {
                ADA.take();
            }
            catch(Exception e)
            {
                
            }
        }
        else
            System.out.println("PERSON: "+p.name+" has faced an ERROR...!!");
        int time = rand.nextInt(5);
        try
        {
            Thread.sleep(1000*time);
        }
        catch(Exception e)
        {
            
        }
    }
    
    public void XRP(People p)
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            
        }
        gp.coinName = "xrp";
        double xrpPrice = gp.Crypto();
        try
        {
            XRP.put(p.name);
        }
        catch(Exception e)
        {
            
        }
        if(p.chBuySell==0)
        {
            p.coin.cp.xrp = p.coin.USD/xrpPrice;
            System.out.println("USER: "+p.name+" bought XRP "+deno.format(p.coin.cp.xrp)+", with $"+p.coin.USD+" @ $"+xrpPrice+" | TIME: "+d.toString());
            try
            {
                XRP.take();
            }
            catch(Exception e)
            {
                
            }
        }
        else if(p.chBuySell==1)
        {
            
            p.coin.USD = p.coin.cp.xrp*xrpPrice;
            System.out.println("USER: "+p.name+" sold XRP "+deno.format(p.coin.cp.xrp)+", received $"+p.coin.USD+" @ $"+xrpPrice+" | TIME: "+d.toString());
            try
            {
                XRP.take();
            }
            catch(Exception e)
            {
                
            }
        }
        else
            System.out.println("PERSON: "+p.name+" has faced an ERROR...!!");
        int time = rand.nextInt(5);
        try
        {
            Thread.sleep(1000*time);
        }
        catch(Exception e)
        {
            
        }
    }
    
    public void DOGE(People p)
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            
        }
        gp.coinName = "dogecoin";
        double dodgePrice = gp.Crypto();
        try
        {
            DOGE.put(p.name);
        }
        catch(Exception e)
        {
            
        }
        if(p.chBuySell==0)
        {
            p.coin.cp.doge = p.coin.USD/dodgePrice;
            System.out.println("USER: "+p.name+" bought DODGE "+deno.format(p.coin.cp.doge)+", with $"+p.coin.USD+" @ $"+dodgePrice+" | TIME: "+d.toString());
            try
            {
                DOGE.take();
            }
            catch(Exception e)
            {
                
            }
        }
        else if(p.chBuySell==1)
        {
            
            p.coin.USD = p.coin.cp.doge*dodgePrice;
            System.out.println("USER: "+p.name+" sold DODGE "+deno.format(p.coin.cp.doge)+", received $"+p.coin.USD+" @ $"+dodgePrice+" | TIME: "+d.toString());
            try
            {
                DOGE.take();
            }
            catch(Exception e)
            {
                
            }
        }
        else
            System.out.println("PERSON: "+p.name+" has faced an ERROR...!!");
        int time = rand.nextInt(5);
        try
        {
            Thread.sleep(1000*time);
        }
        catch(Exception e)
        {
            
        }
    }
}
