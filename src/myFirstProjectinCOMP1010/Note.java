package myFirstProjectinCOMP1010;

public class Note {
	
	String text, author, date;
	int n;
	
	int numberOfCharacters() {
		return text.length();
	}
	
	public Note(String s, String a) {  
		text = s;
		author = a;
	}
	
	public String toString() {
	    return text + "/" + author+ "/" + date + "/" + n  ;
	}
	
	public static void main(String[] args) {
		
		Note classNotes = new Note("was good", "me");  // If you do not create a constructor 
													   // you cannot write "was good" and "me' like 
													   //this inside of the new object, please look
													   // below;  classNotes.text and classNotes.author to do so
		
		//classNotes.text = "was good";
		//classNotes.author = "me" ;
		
		classNotes.date = "2023";
		classNotes.n = 50;
		
		int textLength = classNotes.numberOfCharacters();
	
		System.out.println(textLength);
		System.out.println(classNotes);  // just sampling to see toString()

	}

}
