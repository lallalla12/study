package Share;

public class _7_ex1_Calculator {

	int num1;
    int num2;
    char operator;

    public _7_ex1_Calculator(int num1, int num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }
	
	public double getAdd() {
        return num1 + num2;
    }

    public double getSub() {
        return num1 - num2;
    }

    public double getMul() {
        return num1 * num2;
    }

    public double getDiv() {
        return (double) num1 / num2;
    }
	
	 public double calculate() {
	        switch (operator) {
	            case '+': return getAdd();
	            case '-': return getSub();
	            case '*': return getMul();
	            case '/': return getDiv();
	            default:
	                System.out.println("지원하지 않는 연산자입니다.");
	                return 0;
	        }
	    }
}