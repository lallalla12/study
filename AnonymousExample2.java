package programming.Ch09;

public class AnonymousExample2 {

	public static void main(String[] args) {
		Anonymous2 anony = new Anonymous2();
		anony.field.run();
		anony.method1();
		anony.method2(
				new Vehicle() {
					public void run() {
						System.out.println("트럭이 달립니다.");
					}
				});

	}

}
