package Labs.Generic_Blocking_Queue;

public class Queue <T> implements QueueInterface<T> {

    private Node<T> head;
    private Node<T> tail;

    @Override
    public void add(T obj) {
     Node<T> node=new Node<T>(obj);
     if(head==null){
         head=node;
         tail=node;
     }else{
         tail.setNext(node);
         tail=node;
     }

    }

    @Override
    public T poll() {
        T value=null;
        if(head!=null){
            Node<T> node=head;
            head=head.getNext();
            value=node.getObj();
        }
        return value;

    }

    @Override
    public T peek() {
        if (head != null) {
            return head.getObj();
        }
        return null;
    }

}
