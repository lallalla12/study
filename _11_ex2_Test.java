package Share;

public class _11_ex2_Test {

	public static void main(String[] args) {
		_11_ex2_Animal a = new _11_ex2_Cat();
        a.speak();
        a.move();
        a = new _11_ex2_Dog();
        a.speak();
        a.move();
        a = new _11_ex2_Bird();
        a.speak();
        a.move();

	}

}
