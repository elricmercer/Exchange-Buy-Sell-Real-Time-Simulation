package SIM02;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Display
{
    public static void main(String[] args) throws IOException, TimeoutException
    {
        String exName = "Finance";
        ConnectionFactory fact = new ConnectionFactory();
        Connection conn = fact.newConnection();
        Channel chn = conn.createChannel();
        chn.exchangeDeclare(exName, "fanout");
        String queueName = chn.queueDeclare().getQueue();
        chn.queueBind(queueName, exName, "");
        while(true)
        {
            try
            {
                Thread.sleep(5000);
            }
            catch(Exception e)
            {
                
            }
            chn.basicConsume(queueName, true, (x,message)->{
            String m = new String(message.getBody(),"UTF-8");
            System.out.println(m);
            },x->{});
        }
        
//        ScheduledExecutorService schThread = Executors.newScheduledThreadPool(1);
//        output out = new output();
//        try
//        {
//            Thread.sleep(5000);
//        }
//        catch(Exception e)
//        {
//            
//        }
//        schThread.scheduleAtFixedRate(out, 0, 5, TimeUnit.SECONDS);
    }
}

//class output implements Runnable
//{
//    @Override
//    public void run()
//    {
//        try {
//            String exName = "Finance";
//            ConnectionFactory fact = new ConnectionFactory();
//            Connection conn = fact.newConnection();
//            Channel chn = conn.createChannel();
//            chn.exchangeDeclare(exName, "fanout");
//            String queueName = chn.queueDeclare().getQueue();
//            chn.queueBind(queueName, exName, "");
//            chn.basicConsume(queueName, true, (x,message)->{
//                String m = new String(message.getBody(),"UTF-8");
//                System.out.println(m);
//            },x->{});
//        } catch (IOException | TimeoutException ex) {
//            Logger.getLogger(output.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//}
