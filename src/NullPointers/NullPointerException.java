 
 
//JBMC fail
public class NullPointerException {
    public static void main(String[] args) {
        Object o = null;
        try {
            o.hashCode();
            assert false; //???
        } catch (java.lang.NullPointerException e) {
            assert true;
        }
    }

}
