package programming;

public class Ch04_2_Ex5 {

	public static void main(String[] args) {
		
		for(int i=1; i<5; i++) {
			for(int j=4; j>0; j--) {
				if(i<j) {
					System.out.printf("");
				}else {
					System.out.printf("*");
				}
			}
			System.out.println();
		}

	}

}
