 
public class BoundsViolation {
    private static String[] strings = {"formal", "methods", "jbmc"};

    public static void main(String[] args) {
        for (int i = 0; i < strings.length; i++) {
            i++;
            System.out.println(strings[i]);
        }
    }
}
