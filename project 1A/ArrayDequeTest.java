
public class ArrayDequeTest {
	public static void main(String[] args) {
		ArrayDeque<Integer> test = new ArrayDeque<>();
		test.addFirst(20);
		//test.addLast(40);
		test.addFirst(60);
		//test.addLast(65);
		//test.addLast(70);
		test.addFirst(35);
		//test.removeLast();
		//test.addLast(51);
		//test.addLast(17);
		test.addFirst(77);
		test.addFirst(16);
		test.addFirst(43);
		test.addFirst(55);
		test.addFirst(30);
		//System.out.println(test.size());
		test.addFirst(9);
		test.addLast(11);
		//System.out.println(test.get(3));
		//System.out.println("----------");

		test.printDeque();
		
	}
}
