
public class Palindrome {
	public Deque<Character> wordToDeque(String word){
		Deque<Character> d = new LinkedListDeque<> ();
		
		for (int i=0; i<word.length(); i++) {    //length( ) ???
			char ch = word.charAt(i);
			d.addLast(ch);
		}
		
		return d;
	}
	
	
	public boolean isPalindrome(String word) {
		
		Deque<Character> d = wordToDeque(word);
		
		if (d.size()==1) {
			return true;
		}else if(d.size()==0) {
			return true;
		}else {
			Character first=d.removeFirst();
			Character last=d.removeLast();
			
			if(!first.equals(last)) {
			
			 return false;
			}
		}
		return true;
	}
	
	public boolean isPalindrome(String word, CharacterComparator cc) {
		Deque<Character> d = wordToDeque(word);
		
		Character first=d.removeFirst();
		Character last=d.removeLast();
		
		while(d.size()>1) {
			if(!cc.equalChars(first, last)) {
				return false;
			}
		}
		return true;
	}
	
	
}
