package Restaurant_Simulator_Multithread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Waiter waiter = new Waiter();
        Chef chef = new Chef();
        Table table = new Table(waiter,chef);

        ExecutorService poolCustomer = Executors.newFixedThreadPool(5);



        while (Customer.isCostomerWaiting() || Table.emptyTable!=0){
            poolCustomer.execute(table);
        }
        poolCustomer.close();
        System.out.println("program bitti");
    }
}