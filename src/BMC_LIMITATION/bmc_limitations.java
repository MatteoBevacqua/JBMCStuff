// run with: jbmc bmc_limitations --unwind 10  => successful: not enough checks
public class bmc_limitations{
    public static void main(String[] args){
        Object o = new Object();
        for(int i = 0; i < 100000000; i++){
            if(i == 1000000) o = null;
        }
        System.out.println(o.getClass());
    }
}