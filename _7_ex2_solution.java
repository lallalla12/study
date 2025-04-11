package Share;

public class _7_ex2_solution {
	
	
	int sum;
	
	int solution(int num1, int num2) {
		for(int i=num1; i<=num2; i++) {
			sum += i;
		}
		System.out.println(sum);
		return sum;
	}

}
