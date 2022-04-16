import java.util.concurrent.Semaphore;

public class SemaphoreSyncThread extends Thread {
        public static boolean[] inCritical; 
        private static Semaphore semaphore;
        private final int id;

        public SemaphoreSyncThread(int i){
            id = i;
        }


        public void run() {
            try{
                semaphore.acquire();
            } catch (Exception e) {
                
            }
            inCritical[id] = true;
            assert !(inCritical[0] && inCritical[1]);
            inCritical[id] = false;
            semaphore.release();
        }
   

    public static void main(String[] args) throws Exception {
        inCritical = new boolean[2];
        inCritical[0] = false;
        inCritical[1] = false; 
        semaphore = new Semaphore(1);
        SemaphoreSyncThread r1 = new SemaphoreSyncThread(0); SemaphoreSyncThread r2 = new SemaphoreSyncThread(1);
        r1.start();
        r2.start();
        
        r1.join();
        r2.join();
        
    }

 }
