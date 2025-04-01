package programming;

public class Ch05_2_Ex04 {

	public static void main(String[] args) {
		int max = 0;
		int[] array = {1,5,3,8,2};
		
		for(int i=1;i<array.length; i++) {
			if(array[i-1]<array[i]) {
				max = array[i];
			}
			
		}
		System.out.println("max:" + max);
	}

}
