//JBMC fail due to nullpointer exeption
public class NullPointerException {
    public static void main(String[] args) {
        Object o = null;
        try{
            o.hashCode();
        } catch(Exception e){
            if(o != null) assert false;
        }
    }
}
