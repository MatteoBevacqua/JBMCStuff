//JBMC fail due to nullpointer exeption
public class NullPointerException {
    public static void main(String[] args) {
         
        try{
            throw new IllegalArgumentException();
        } catch(Exception e){
            assert true;
        }
    }
}
