import java.util.Random;
class A{
	 int i;

	A (int t){
		i = t;
	}
}
public class PartialLoops{


	public static void main(String[] args) {
		A o = new A(1);
		Random r = new Random();
		int ran;
		for(int i = 0;i<100;i++){
			if (i == 76) o.i = 4;
		}		
		assert(o.i == 1);
	}		
		
	
}