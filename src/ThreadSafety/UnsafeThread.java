
public class UnsafeThread extends Thread {
    public final static boolean[] inCritical = new boolean[2]; 


    public static void main(String[] args)  {
        UnsafeThread r1 = new UnsafeThread(0), r2 = new UnsafeThread(1);
        r1.start();
        r2.start();
        try{
            r1.join();
            r2.join();
        } catch (Exception e) {
            System.out.println(e); 
        }
    }


   
    public UnsafeThread(int id) {
        this.id = id;
    }

    private final int id;

    public void run() {
        
            inCritical[id] = true;
            assert !(inCritical[0] && inCritical[1]);
            inCritical[id] = false;}
    

}