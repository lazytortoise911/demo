package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SubmitExceptionDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
//        executor.submit(()-> {
//           new Print();
//        });
//        executor.shutdown();
        executor.execute(()-> {
            String s = null;
            System.out.println(s.toString());
            s.substring(0);
        });
    }

    static class Print implements Runnable {

        @Override
        public void run() {
            String s = null;
            System.out.println(s.toString());
            s.substring(0);
        }
    }
}
