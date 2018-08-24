import java.lang.reflect.Array;

public class Transform <Item> {
	public static void Rotate90 (Object[][] data) {
		int N = data.length;
		int l = N-1;
		
		for (int r = 0; 2*r < N; r++) {
			for (int c = r; c < l-r; c++) {
				Point[] points = new Point[4];
				if (r == c) {
					points[0] = new Point(r, c);
					
					int r2 = c;
					int c2 = l-r;
					points[1] = new Point(r2, c2);
					
					int r3 = l-c;
					int c3 = c2;
					points[2] = new Point(r3, c3);
					
					int r4 = r3;
					int c4 = c;
					points[3] = new Point(r4, c4);
					
					exch(data, points);
				} else {
					points[0] = new Point(r, c);
					
					int r2 = c;
					int c2 = l-r;
					points[1] = new Point(r2, c2);
					
					int r3 = l-r;
					int c3 = l-c;
					points[2] = new Point(r3, c3);
					
					int r4 = l-c;
					int c4 = r;
					points[3] = new Point(r4, c4);
					
					exch(data, points);
				}
			}
		}
	}
	
	private static class Point {
		int r;
		int c;
		
		private Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	private static void exch(Object[][] data, Point[] points) {
		Point s1 = points[0];
		Point s2 = points[1];
		Point s3 = points[2];
		Point s4 = points[3];
		
		Object swap1 = data[s1.r][s1.c];
		Object swap2 = data[s2.r][s2.c];
		Object swap3 = data[s3.r][s3.c];
		Object swap4 = data[s4.r][s4.c];
		
		data[s1.r][s1.c] = swap4;
		data[s2.r][s2.c] = swap1;
		data[s3.r][s3.c] = swap2;
		data[s4.r][s4.c] = swap3;
	}
	
	public static void printMatrix(Object[][] data) {
		int N = data.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main (String[] args) {
		int[] nums = {
				1,2,2,2,2,2,2,3,
				8,9,9,9,9,9,9,4,
				8,0,0,0,0,0,0,4,
				8,9,9,9,9,9,9,4,
				8,0,0,0,0,0,0,4,
				8,9,9,9,9,9,9,4,
				8,0,0,0,0,0,0,4,
				7,6,6,6,6,6,6,5
			};
		int N = 8;
		
		Object[][] data = new Object[N][N];
		int c = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {				
				data[i][j] = nums[c++];
			}
		}
		
		Transform.printMatrix(data);
		
		Transform.Rotate90(data);
		
		Transform.printMatrix(data);

	}
}
