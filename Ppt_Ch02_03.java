package programming;

public class Ppt_Ch02_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double score1 = 88.7;
		double score2 = 91.4;
		double score3 = 79.5;
		
		int Intsocre1 = (int)score1;
		int Intsocre2 = (int)score2;
		int Intsocre3 = (int)score3;
		
		System.out.println(Intsocre1);
		System.out.println(Intsocre2);
		System.out.println(Intsocre3);
		
		double sum1 =  score1 + score2 + score3;
		double sum2 = sum1 / 3;
		
		System.out.println("총합 : " + sum1);
		System.out.printf("평균 : %.2f " , sum2);
		
	}

}
