package SIM02;

public class People implements Runnable
{
    String name;
    Wallet coin;
    int chCoin;
    int chBuySell;
    CryptoX cx;

    public People(String name, Wallet coin, int chCoin, int chBuySell, CryptoX cx) 
    {
        this.name = name;
        this.coin = coin;
        this.chCoin = chCoin;
        this.chBuySell = chBuySell;
        this.cx = cx;
    }
    
    @Override
    public void run()
    {
        //BTC=0,ETH=1,ADA=2,XRP=3,DODGE=4
        if(chCoin==0)
            cx.BTC(this);
        else if(chCoin==1)
            cx.ETH(this);
        else if(chCoin==2)
            cx.ADA(this);
        else if(chCoin==3)
            cx.XRP(this);
        else if(chCoin==4)
            cx.DOGE(this);
    }
}
