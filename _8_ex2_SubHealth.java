package Share;

public class _8_ex2_SubHealth extends _8_ex2_Health {
	
	double s_weight = 0.0;
	double fat = 0.0;
	String result = null;
	
	
	void calculate(){
		this.gender = gender;
		this.tall = tall;
		this.weight = weight;
		
		if(gender == 'M') {
			s_weight = (tall-100) * 0.9;
		}else if( gender == 'F') {
			s_weight = (tall-100) * 0.85;
		}
		
		// 비만도 계산
		fat = weight/s_weight*100;
		
		if(fat<=90) {
			result = "저체중";
		}else if(91<=fat && fat<=110) {
			result = "정상(표준체중)";
		}else if(111<=fat && fat<=120) {
			result = "과체중";
		}else if(121<=fat && fat<=130) {
			result = "경도비만";
		}else if(131<=fat && fat<=150) {
			result = "중도비만";
		}else if(150<=fat) {
			result = "고도비만";
		}
		
		
	}
	
	void output2() {
		System.out.println("당신은 비만도 " + fat + "이고, " + result +"입니다.");
	}
	
}
