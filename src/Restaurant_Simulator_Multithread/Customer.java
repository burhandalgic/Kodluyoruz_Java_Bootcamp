package Restaurant_Simulator_Multithread;
import java.util.LinkedList;
import java.util.Queue;
public class Customer {
    public static Queue<String> costumerlist = new LinkedList<>();
    static {
        costumerlist.add("Müşteri 1");
        costumerlist.add("Müşteri 2");
        costumerlist.add("Müşteri 3");
        costumerlist.add("Müşteri 4");
        costumerlist.add("Müşteri 5");
        costumerlist.add("Müşteri 6");
        costumerlist.add("Müşteri 7");
        costumerlist.add("Müşteri 8");
        costumerlist.add("Müşteri 9");
        costumerlist.add("Müşteri 10");
    }
    public static boolean isCostomerWaiting (){
        return costumerlist.isEmpty() ? false : true;
    }
}
