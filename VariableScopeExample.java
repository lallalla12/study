package sec03.exam01;

public class VariableScopeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v1 = 15; // 로컬 변수
		int v2 = 0; // if문안에서 선언되면 밖에서 사용 못함
		if(v1>10) {
			
			v2 = v1 - 10;
		}
		int v3 = v1 + v2 + 5;
		System.out.println(v3);
	}

}
