import java.io.IOException;

public class ZKDaemon {



    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
//        thread.setDaemon(true);
        thread.start();
    }




}
class MyThread implements  Runnable{


    @Override
    public void run() {

        System.out.println("守护线程");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}