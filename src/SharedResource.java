import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer> sharedBuffer ;
    private int bufferSize ;

    public SharedResource(int sz){
        this.bufferSize = sz ;
        sharedBuffer = new LinkedList<>();
    }

    public synchronized void produce(int item) throws Exception{
        while(sharedBuffer.size() == bufferSize){
            System.out.println("Queue is full , producer is waiting for consumer to consume");
            wait();
        }
        sharedBuffer.add(item);
        System.out.println("Producer Added item in queue : " + item);
        notify();
    }

    public synchronized int consume() throws Exception{
        while(sharedBuffer.isEmpty()){
            System.out.println("Queue is empty , consumer is waiting for producer to add");
            wait();
        }
        int item = sharedBuffer.poll();
        System.out.println("Consumed" + item);
        notify();
        return item;
    }

}
