//JBMC fail due to nullpointer exeption
public class NullPointerException {
    public static void main(String[] args) {
        Object o = null;
        try {
            o.hashCode();
        } catch (java.lang.NullPointerException e) {
            assert true;
        }
    }

}
