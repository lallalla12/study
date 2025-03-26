package sec03.exam01;

public class VariableUseExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hour = 3;	// hour에 3 대입
		int minute = 5;	// minute에 5 대입
		System.out.println(hour + "시간" + minute + "분"); // 3 + "시간' + 5 + "분" 출력 
		
		int totalMinute = (hour*60) + minute;	//totalMinute에 (3*60)+5 대입
		System.out.println("총" + totalMinute + "분"); // "총" + 185 + "분" 출력
	}

}
