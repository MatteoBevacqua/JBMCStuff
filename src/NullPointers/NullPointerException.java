//JBMC fail due to nullpointer exeption
import java.util.Random;
public class NullPointerException {
    public static void main(String[] args) {
        Object o = null;
        int coinToss = new Random().nextInt(100);
        if(coinToss < 50) o = new Object();
        o.hashCode();
    }
}
