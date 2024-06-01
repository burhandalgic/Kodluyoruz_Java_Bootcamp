package Restaurant_Simulator_Multithread;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class Table implements Runnable {
    public static String costomerName;
    public static String costomerName2;
    public static String WaiterName;
    Waiter waiter ;
    Chef chef;
    ExecutorService poolChef = Executors.newFixedThreadPool(2);
    ExecutorService poolWaiter = Executors.newFixedThreadPool(3);
private final Object LOCK = new Object();
    private final Object LOCK2 = new Object();
    private final Object LOCK3 = new Object();
static int emptyTable=5;

    public Table(Waiter waiter, Chef chef) {
        this.waiter = waiter;
        this.chef = chef;
    }
    @SneakyThrows
    @Override
    public void run() {

        String s = null;

        synchronized(LOCK) {
            if (emptyTable != 0 && Customer.isCostomerWaiting()) {
                s = Customer.costumerlist.poll();
                System.out.println(s + " masaya oturdu");
                emptyTable--;
            }
        }

                if (s!=null)
                {
                    synchronized (LOCK2) {
                        costomerName = s;
                        poolWaiter.execute(waiter);
                        poolWaiter.awaitTermination(1000, TimeUnit.MILLISECONDS);
                    }
                    Thread.sleep(500);

                    synchronized (LOCK3) {
                        costomerName2 = s;
                        poolChef.execute(chef);
                        poolChef.awaitTermination(1000, TimeUnit.MILLISECONDS);
                    }
                    Thread.sleep(500);

                    System.out.println( s  + " masadan kalktı ");
                    emptyTable++;
                }
    }

}
