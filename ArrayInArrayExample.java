package Chapter05;

public class ArrayInArrayExample {

	public static void main(String[] args) {
		// 2행 3열
		int[][] mathScroes = new int[2][3];
		for(int i = 0; i < mathScroes.length; i++) {
			for(int k=0; k<mathScroes[i].length; k++ ) {
				System.out.println("mathScroes[" + i + "][" + k + "]=" + mathScroes[i][k]);
			}
		}
		System.out.println();
		
		int[][] englishScores = new int[2][];
		// 0행은 2열
		englishScores[0] = new int[2];
		// 1행은 3열 int[2][3]과 같음
		englishScores[1] = new int[3];
		for(int i=0; i<englishScores.length; i++) {
			for(int k=0; k<englishScores[i].length; k++) {
				System.out.println("mathScroes[" + i + "][" + k + "]=" + mathScroes[i][k]);
			}
		}
		System.out.println();
		
		int[][] javaScores = {{95, 80}, {92, 96, 80} };
		for(int i=0; i<javaScores.length; i++) {
			for(int k=0; k<javaScores[i].length; k++) {
				System.out.println("javaScores[" + i + "][" + k + "]=" + javaScores[i][k]);
		

	}

		}
	}
}
