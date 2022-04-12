package ThreadSafety;


public class CritSectionOk {
    public final static boolean[] inCritical = {false, false, false};

    static class MySafeThread extends Thread {
        public MySafeThread(int id) {
            this.id = id;
        }

        private final int id;

        public void run() {
            synchronized (CritSectionOk.class) {
                inCritical[id] = true;
                assert !(inCritical[0] && inCritical[1] && inCritical[2]);
                inCritical[id] = false;
            }
        }
    }

    public static void main(String[] args) {
        Thread r1 = new MySafeThread(0), r2 = new MySafeThread(1), r3 = new MySafeThread(2);
        r1.start();
        r2.start();
        r3.start();

    }
}