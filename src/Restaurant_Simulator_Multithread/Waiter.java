package Restaurant_Simulator_Multithread;

public class Waiter implements Runnable{
    @Override
    public synchronized void run() {
        String x="";
        if (Thread.currentThread().getName().equals("pool-2-thread-1"))
            x="Garson1";
        if (Thread.currentThread().getName().equals("pool-2-thread-2"))
            x="Garson2";
        if (Thread.currentThread().getName().equals("pool-2-thread-3"))
            x="Garson3";
        System.out.println( x + " " +  Table.costomerName + " den sipariş aldı" );
    }


}
