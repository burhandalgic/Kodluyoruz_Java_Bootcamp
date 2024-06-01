package Restaurant_Simulator_Multithread;

public class Chef implements Runnable{

    @Override
    public void run() {
        String x="";
        if (Thread.currentThread().getName().equals("pool-1-thread-1"))
            x="Şef1";
        if (Thread.currentThread().getName().equals("pool-1-thread-2"))
            x="Şef2";
        System.out.println( x + " " +  Table.costomerName2 + " e siparişi verdi" );
    }
}
