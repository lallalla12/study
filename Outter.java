package Chapter09;

public class Outter {
	
	public void method2(int arg) {
		int localVarialble = 1;
		//arg = 100;
		// localVarialbe = 100;
		class Inner{
			public void method() {
				int result = arg + localVarialble;
			}
		}
	}
}
