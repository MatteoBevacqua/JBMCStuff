package OOPFeatures;

import static common.CommonMethods.assertLineUnreachable;

class A {

}

class B  extends A {

}
 public class LegalCasting {
    public static void main(String[] args) {
        B object = new B();
        try {
           A otherObj = (A) object;
        } catch (ClassCastException e) {
            assertLineUnreachable();
        }
    }
}
