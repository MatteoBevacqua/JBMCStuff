class A1 {
    int firstInt;
    public A1() {
        firstInt = 1;
    }
}

class B2 extends A1 {
    int secondInt;
    public B2() {
        super();
        secondInt = 2;
    }
}

class C3 extends B2 {
    int thirdInt;
    public C3() {
        super();
        thirdInt = 3;
    }
}

public class ConstructorChaining {
    public static void main(String[] args) {
        C3 anObject = new C3();
        assert anObject.firstInt == 1 && anObject.secondInt == 2 && anObject.thirdInt == 3;
    }
}