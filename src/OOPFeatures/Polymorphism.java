import java.util.Random;
class A {}
class B extends A {}
public class Polymorphism {
      

    public static void main(String[] args) {
        A object;
        int coinToss = new Random().nextInt(100);
        if(coinToss < 50)
            object = new A();
        else 
            object = new B();
        
        assert object instanceof B;
     }
}
