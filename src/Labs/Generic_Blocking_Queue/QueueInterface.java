package Labs.Generic_Blocking_Queue;

public interface QueueInterface<T> {
    void add(T obj);
    T poll();
    T peek();

}
