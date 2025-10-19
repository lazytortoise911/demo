package concurrent;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerDemo {

    private static final int size = 100;

    private static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(size);

    private static volatile boolean stop = false;

    public static void main(String[] args) {
        Thread consumer1 = new Thread(new Consumer(), "consumer1");
        Thread consumer2 = new Thread(new Consumer(), "consumer2");
        Thread producer = new Thread(new Producer(), "producer");

        producer.start();
//        consumer1.start();
//        consumer2.start();
    }

    static class Consumer implements Runnable{


        @Override
        public void run() {
            while (!stop) {
                try {
                    Thread.sleep(1000);
                    String take = queue.take();
                    System.out.println(Thread.currentThread().getName() + "|" + take + "|" + queue.size());
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    static class Producer implements Runnable{


        @Override
        public void run() {
            while (!stop) {
                try {
                    Thread.sleep(10);
                    String value = "" + Math.random();
                    queue.put(value);
                    System.out.println(Thread.currentThread().getName() + "|" + value);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
