package programming;

public class Ppt_Ch03_01 {

	public static void main(String[] args) {
		int x = 2;
		int y = 5;
		char c = 'A'; // 유니코드 65
		
		System.out.println(1+x<<33);
		System.out.println(y>=5 || x<0 && x>2);
		//System.out.println(y += 10 = x++);
		System.out.println(x+=2);
		System.out.println(!('A' <= c && c <= 'Z'));
		System.out.println('C'-c); 						// 65 - 67
		System.out.println('5'-'0');
		System.out.println(c+1); 						// 66 + 1
		System.out.println(++c);						// 66 B의 아스키코드
		System.out.println(c++);
		System.out.println(c);
	}

}
