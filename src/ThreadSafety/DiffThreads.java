package ThreadSafety;

import java.util.concurrent.Semaphore;

public class DiffThreads {
    public static boolean inFirst = false ,inSecond = false;
    private static Semaphore semaphore = new Semaphore(1);

    static class First extends Thread {
        

        private final int id = 0;

        public void run() {
            try {
                semaphore.acquire();
            } catch (Exception e) {
                return;
            } 
            inFirst = true;
            assert !(inFirst && inSecond);
            inFirst = false;
            semaphore.release();
        }
    }
    static class Second extends Thread {
        

        private final int id = 1;

        public void run() {
            try {
                semaphore.acquire();
            } catch (Exception e) {
                return;
            } 
            inSecond = true;
            assert !(inFirst && inSecond);
            inSecond = false;
            semaphore.release();
        }
    }


    public static void main(String[] args) {
        Thread r1 = new First(), r2 = new Second( );
        r1.start();
        r2.start();

    }

}
