//JBMC fail due to nullpointer exeption
public class NullPointerException {
    public static void main(String[] args) {
        Object o = null;
        o.hashCode();
    }
}
