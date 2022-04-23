class A {

}

class B extends A {

}

public class IllegalCasting {
    public static void main(String[] args) {
        A objC = new A();
        B otherObj = (B) objC;
    }
}
