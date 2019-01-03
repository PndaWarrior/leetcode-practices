
public class Playground {

	public static void main(String[] args) {
		
	String temp = "HELLO";
	
	StringBuilder b = new StringBuilder(temp);
	
	b.setCharAt(2, 'X');
	
	System.out.println(b);
		
	}

}
