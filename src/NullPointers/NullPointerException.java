package NullPointers;

import static common.CommonMethods.assertLineUnreachable;
//JBMC fail
public class NullPointerException {
    public static void main(String[] args) {
        Object o = null;
        try {
            o.hashCode();
            assertLineUnreachable(); //???
        } catch (java.lang.NullPointerException e) {
            assert true;
        }
    }

}
