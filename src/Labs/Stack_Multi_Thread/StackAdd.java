package Labs.Stack_Multi_Thread;

import java.util.Stack;
import java.util.concurrent.Semaphore;

public class StackAdd implements Runnable {
    private Stack stack;
    private Semaphore semaphore;
    private int intValue=10;

    public StackAdd(Stack stack, Semaphore semaphore) {
        this.stack = stack;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        for (int i = 0 ; i<3 ; i++) {

            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            stack.add(intValue);
            System.out.println("Added " + intValue++);
            semaphore.release();

        }
    }
}
