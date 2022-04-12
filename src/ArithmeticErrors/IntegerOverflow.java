package ArithmeticErrors;

public class IntegerOverflow {
    //Java 32 bits signed integer => [-2^31,2^31-1]
    public static void main(String[] args) {
        int n = (int) Math.floor(Math.pow(2, 31) - 1);
        n++;
        assert n > 0;

    }
}
