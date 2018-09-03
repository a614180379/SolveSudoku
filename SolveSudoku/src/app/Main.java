package app;

public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		SolveSudoku solve=new SolveSudoku();
		int[][] matrix=new int[][]{
			{0, 0,0,0, 0,0,0, 0,0,0,},
			
			{0, 0,0,9, 0,0,8, 0,4,0,},
			{0, 6,0,0, 0,0,0, 0,1,7,},
			{0, 0,1,0, 0,4,0, 0,0,0,},
			
			{0, 0,0,0, 0,0,0, 0,0,4,},
			{0, 4,8,0, 6,0,3, 0,2,1,},
			{3, 0,0,0, 0,0,0, 0,0,0,},
			
			{0, 0,0,0, 0,9,0, 0,8,0,},
			{0, 2,4,0, 0,0,0, 0,0,6,},
			{0, 0,5,0, 7,0,0, 1,0,0,},
			
		};
		solve.FillMatrix(matrix);
		long start=System.currentTimeMillis();
		System.out.println(""+start);
		solve.Solve();
		long end=System.currentTimeMillis();
		System.out.println(""+end+"  time:"+(end-start));
		System.out.println(""+solve.sum);
		System.out.println(""+solve.sum1);
		
	}

}
