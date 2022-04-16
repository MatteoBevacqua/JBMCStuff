
public class MySafeThread extends Thread {
        private static int inCrit = 0;
        public static boolean[] inCritical = {false, false}; 
        public final static Object lock = new Object();    
        public MySafeThread(int id) {
            this.id = id;
        }

        private final int id;

        public void run() {
            synchronized (lock) {
                inCritical[id] = true;
                assert !(inCritical[0] && inCritical[1]);
                inCritical[id] = false;
            }

        }    
        public static void main(String[] args) {
            inCritical = new boolean[2];
            inCritical[0] = false;
            inCritical[1] = false;
            MySafeThread r1 = new MySafeThread(0); 
            MySafeThread r2 = new MySafeThread(1);
            r1.start();
            r2.start();
            try{
                r1.join();
                r2.join();
            } catch (Exception e) {
                
            }

        }
    
    }

