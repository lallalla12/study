package programming;

public class Ppt_Ch03_05 {

	public static void main(String[] args) {
		int num = '%'  ;	// 48~122
		boolean b = false ;
		if((num>=65 && num <= 90) || (num>=97 && num<= 122) || !(num<48 && num > 57))  {
			b = true;
		}
		
		System.out.println(b);
	}

}
