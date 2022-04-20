class A {}
class B  extends A {}

public class LegalCasting {
    public static void main(String[] args) {
        B object = new B();
        A otherObj = (A) object;
    }
}
