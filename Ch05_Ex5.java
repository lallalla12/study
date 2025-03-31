package programming;

public class Ch05_Ex5 {

	public static void main(String[] args) {
		int var1 = 10;
		int var2 = 10;
		String var3 = "AB";
		String var4 = "AB";
		String var5 = new String ("AB");
		
		System.out.println(var1 == var2);
		System.out.println(var1 != var2 );
		System.out.println(var3 == var4);
		System.out.println(var3 != var5);
		System.out.println(var4.equals(var5));
	}	

}
