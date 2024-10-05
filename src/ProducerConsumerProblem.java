public class ProducerConsumerProblem {

       public static void main(String[] args){
           SharedResource sharedBuffer = new SharedResource(5);

           Thread producerThread = new Thread(()->{
                  try{
                      for(int i = 0 ; i < 10 ; ++i){
                          sharedBuffer.produce(i);
                      }
                  }catch (Exception ex){
                      // logging exception
                  }
           });

           Thread consumerThread = new Thread(() -> {
               try{
                   for(int i = 0 ; i < 10 ; ++i){
                       sharedBuffer.consume();
                   }
               }catch (Exception ex){
                   // logging exception
               }
           });

           producerThread.start();
           consumerThread.start();

       }
}
