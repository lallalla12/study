package Chapter09;

public class OutterExample {

	public static void main(String[] args) {
		Outter2 outter = new Outter2();
		Outter2.Nested nested = outter.new Nested();
		nested.print();

	}

}
