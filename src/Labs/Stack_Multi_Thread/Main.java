package Labs.Stack_Multi_Thread;

import java.util.Stack;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Stack<Integer> list = new Stack<>();
        list.add(1);
        list.add(2);
        list.add(3);


        Semaphore semaphore = new Semaphore(1,true);
        StackAdd stackAdd = new StackAdd(list,semaphore);
        StackGet stackGet = new StackGet(list,semaphore);

        Thread thread1 = new Thread(stackAdd);
        Thread thread2 = new Thread(stackGet);

        thread2.start();
        thread1.start();


        thread1.join();
        thread2.join();
        System.out.println("end");








    }
}
