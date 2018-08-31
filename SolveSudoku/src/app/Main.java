package app;

public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		SolveSudoku solve=new SolveSudoku();
		solve.setItem(5, 1, 9);
		solve.setItem(7, 1, 7);
		solve.setItem(8, 1, 1);
		
		solve.setItem(7, 2, 4);
		solve.setItem(1, 3, 8);
		solve.setItem(4, 3, 3);
		
		solve.setItem(6, 4, 5);
		solve.setItem(9, 4, 6);
		solve.setItem(2, 5, 2);
		solve.setItem(3, 5, 5);
		solve.setItem(2, 6, 1);
		solve.setItem(3, 6, 4);
		solve.setItem(5, 6, 7);
		
		solve.setItem(2, 7, 7);
		solve.setItem(5, 7, 4);
		solve.setItem(7, 7, 9);
		solve.setItem(1, 8, 5);
		solve.setItem(6, 8, 8);
		solve.setItem(4, 9,6);
		solve.setItem(9, 9, 2);
		long start=System.currentTimeMillis();
		System.out.println(""+start);
		solve.Solve();
		long end=System.currentTimeMillis();
		System.out.println(""+end+"  time:"+(end-start));
		System.out.println(""+solve.sum);
		System.out.println(""+solve.sum1);
		
	}

}
