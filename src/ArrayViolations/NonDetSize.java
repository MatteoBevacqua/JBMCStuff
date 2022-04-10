package ArrayViolations;

import java.util.Random;



public class NonDetSize {
    public static void main(String[] args) {
        int n = new Random().nextInt(100);
        int size = Math.random() < 0.5 ? -n : n;
        boolean[] array = new boolean[size];

    }
}
