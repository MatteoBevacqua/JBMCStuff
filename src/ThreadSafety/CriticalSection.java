package ThreadSafety;


import java.util.concurrent.TimeUnit;

import static ThreadSafety.CriticalSection.inCritical;

public class CriticalSection {
    public static boolean[] inCritical = {false, false,false};


    public static void main(String[] args) throws InterruptedException {
        Thread r1 = new MyThread(0), r2 = new MyThread(1), r3 = new MyThread(2);
        r1.start();
        r2.start();
        r3.start();
        r1.join();
        r2.join();
        r3.join();

    }
}

class MyThread extends Thread {
    public MyThread(int id) {
        this.id = id;
    }

    private final int id;

    public void run() {
        inCritical[id] = true;
        assert !(inCritical[0] && inCritical[1] && inCritical[2]);
        inCritical[id] = false;
    }
}