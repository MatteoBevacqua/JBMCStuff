 
class A1 {
    int firstInt;

    public A1() {
        firstInt = 1;
    }
}

class B2 extends A1 {
    int anotherInt;

    public B2() {
        anotherInt = 2;
    }
}

class C3 extends B2 {
    int lastInt;

    public C3() {
        lastInt = 3;
    }
}

public class ConstructorChaining {
    public static void main(String[] args) {
        C3 anObject = new C3();
        assert anObject.firstInt == 1;
        assert anObject.anotherInt == 2;
        assert anObject.lastInt == 3;
    }

}
