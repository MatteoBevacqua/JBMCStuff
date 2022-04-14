package ThreadSafety;

import java.util.concurrent.Semaphore;

public class SafeCritSemaphore {
    public final static boolean[] inCritical = {false, false,false}; 
    private static Semaphore semaphore = new Semaphore(1);

    static class MySafeThread extends Thread {
        public MySafeThread(int id) {
            this.id = id;
        }

        private final int id;

        public void run() {
            try {
                semaphore.acquire();
            } catch (Exception e) {
                return;
            }
            if(id >= inCritical.length) return; //JBMC boilerplate
            inCritical[id] = true;
            assert !(inCritical[0] && inCritical[1]);
            inCritical[id] = false;
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        Thread r1 = new MySafeThread(0), r2 = new MySafeThread(1);
        r1.start();
        r2.start();

    }

}
