package ThreadSafety;


import java.util.concurrent.TimeUnit;
 

public class CriticalSection { //UNSAFE
    public final static boolean[] inCritical = new boolean[2]; 


    public static void main(String[] args) throws InterruptedException {
        MyThread r1 = new MyThread(0), r2 = new MyThread(1);
        r1.start();
        r2.start();
        r1.join();
        r2.join(); 

    }


static class MyThread extends Thread {
    public MyThread(int id) {
        this.id = id;
    }

    private final int id;

    public void run() {
        inCritical[id] = true;
        assert !(inCritical[0] && inCritical[2]);
        inCritical[id] = false;
    }
}
}