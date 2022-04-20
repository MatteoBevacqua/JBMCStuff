class C {

}

class D extends C {

}

public class IllegalCasting {
    public static void main(String[] args) {
        C objC = new C();
        D otherObj = (D) objC;
    }
}
