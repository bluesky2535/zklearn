import java.util.concurrent.*;

public class MyThreadPool {


    public static void main(String[] args) throws Exception {
        MyCallable myCallable=new MyCallable();
        myCallable.call();

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName());
                return "王五";
            }
        };
        ExecutorService executorService= Executors.newFixedThreadPool(3);//固定大小的线程池


        Future<String> s=executorService.submit(callable);

        System.out.println(s.get());
        executorService.shutdown();
    }
}
