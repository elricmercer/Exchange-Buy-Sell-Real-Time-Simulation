package SIM01;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) 
    {
        try
        {
            Thread.sleep(10000);
        }
        catch(Exception e)
        {
            
        }
        ScheduledExecutorService schThread = Executors.newScheduledThreadPool(1);
        UptoPrice up  = new UptoPrice();
        schThread.scheduleAtFixedRate(up, 0, 5, TimeUnit.SECONDS);
        try
        {
            Thread.sleep(3000);
        }
        catch(Exception e)
        {
            
        }
        ExecutorService xThread = Executors.newCachedThreadPool();
        People p[] = new People[100];
        Random rand = new Random();
        //BTC=0,ETH=1,ADA=2,XRP=3,DOGE=4
        for(int i=0;i<p.length;i++)
        {
            try
            {
                Thread.sleep(1000);
            }
            catch(Exception e)
            {
                
            }
            String name = "Person "+(i+1);
            int chBuySell= rand.nextInt(2);
            if(chBuySell==0)//buy
            {
                Cryptos c = new Cryptos(0,0,0,0,0); 
                int dollar = rand.nextInt(1000);
                Wallet w = new Wallet(dollar,c);
                CryptoX cx = new CryptoX();
                int chCoin = rand.nextInt(5);
                p[i] = new People(name,w,chCoin,0,cx);
                xThread.submit(p[i]);
            }
            else if(chBuySell==1)//sell
            {
                double btc=0.0, eth=0.0, ada=0.0, xrp=0.0, doge=0.0; 
                int chCoin = rand.nextInt(5);
                if(chCoin==0)
                    btc = rand.nextInt(10)+1;
                else if(chCoin==1)
                    eth = rand.nextInt(10)+1;
                else if(chCoin==2)
                    ada = rand.nextInt(10)+1;
                else if(chCoin==3)
                    xrp = rand.nextInt(10)+1;
                else if(chCoin==4)
                    doge = rand.nextInt(10)+1;
                Cryptos c = new Cryptos(btc,eth,ada,xrp,doge);
                int dollar = rand.nextInt(1000);
                Wallet w = new Wallet(dollar,c);
                CryptoX cx = new CryptoX();
                p[i] = new People(name,w,chCoin,1,cx);
                xThread.submit(p[i]);
            }
        }
    }
}
