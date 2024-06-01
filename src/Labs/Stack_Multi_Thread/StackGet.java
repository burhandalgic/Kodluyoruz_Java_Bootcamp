package Labs.Stack_Multi_Thread;

import java.util.Stack;
import java.util.concurrent.Semaphore;

public class StackGet implements Runnable {
    private Stack stack;
    private Semaphore semaphore;

    public StackGet(Stack stack, Semaphore semaphore) {
        this.stack = stack;
        this.semaphore = semaphore;
    }


    @Override
    public void run() {

        for (int i = 0 ; i<5 ; i++) {

            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(stack.pop());
            semaphore.release();

        }
    }
}
