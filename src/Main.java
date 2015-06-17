import java.util.Random;


public class Main {
	public static void main (String args[]){
		int temp = -1;
		Random r = new Random();
		do{
			temp = r.nextInt(10)+1;
		}while(temp < 4);
		NodoAnchura.numQueens = temp;
		System.out.println("Number of Queens: " +temp);
		new NodoAnchura(-1, 0, null).dekuTree();
		
	}
}
