
public class OffByN implements CharacterComparator {

	int N;
	
	public OffByN(int n) {
		
			N=n;
			
	}
	
	
	// @override
	public boolean equalChars(char x, char y) {
		
		int diff = x-y;
		if (diff==N || diff ==-N) {
		
			return true;
	    }
		
		
		return false;
	}
	
	
}
