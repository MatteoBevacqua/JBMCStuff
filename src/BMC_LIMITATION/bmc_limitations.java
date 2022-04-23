public class bmc_limitations{
    

    public static void main(String[] args){
        Object o = new Object();
        for(int i = 0; i < 150; i++){
            if(i == 75) o = null;
            assert (o != null); 
        } 
     }
}