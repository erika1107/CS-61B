
public class DrawTriangle {
	public static void drawTriangle(int N) {
		int row = 1;
		while (row<=N) {
			int col=1;
			while(col<row) {
				System.out.print("*");
				col++;
			}
		System.out.println("*");
		row++;
		}
	}
	
	
	public static void main(String [] args) {
		drawTriangle(10);
		
	}
}
