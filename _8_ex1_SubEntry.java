package Share;

public class _8_ex1_SubEntry extends _8_ex1_Entry {
	// 필드
	String definition;
	int year;
	
	// 생성자
	
	// 메소드
	_8_ex1_SubEntry(String word){
		printView();
	}
	
	_8_ex1_SubEntry(String word, String definition, int year){
		this.word = word;
		this.definition = definition;
		this.year = year;
		super.printView();
		printView();
		
		
		
		
	}
	
	public void printView() {
		System.out.println("원어 : " + definition);
		System.out.println("시기 : " + year + "년");
	}
	
	
	
}
