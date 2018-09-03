package app;

import java.util.Arrays;

/**
 * 2018.08.30
 * 解数独
 */


/**
 * @author cuida
 *
 */
public class SolveSudoku {
	//[x][y]=val;
	public int[][] sudoku;
	
	//[y][val]=x;	
	public int[][] rowOccupy;//每行占用情况
	
	//[x][val]=y;
	public int[][] columnOccupy;//每列占用情况
	
	//[shiftcoord[x][y]][val]; 
	public boolean[][] occupy;//3x3格内占用情况
	
	public int sum=0;//正确解数量
	public int sum1=0;

	//转换下标用
	final static int[][] shiftcoord=new int[][]{
		{0, 0,0,0, 0,0,0, 0,0,0,},
		
		{0, 1,1,1, 2,2,2, 3,3,3,},
		{0, 1,1,1, 2,2,2, 3,3,3,},
		{0, 1,1,1, 2,2,2, 3,3,3,},
		
		{0, 4,4,4, 5,5,5, 6,6,6,},
		{0, 4,4,4, 5,5,5, 6,6,6,},
		{0, 4,4,4, 5,5,5, 6,6,6,},
		
		{0, 7,7,7, 8,8,8, 9,9,9,},
		{0, 7,7,7, 8,8,8, 9,9,9,},
		{0, 7,7,7, 8,8,8, 9,9,9,},
		
		
	};
	
	public SolveSudoku(){
		Init();
		
		

	}
	
	public void Init(){
		sudoku=new int[9+1][9+1];
		rowOccupy =new int[9+1][9+1];
		columnOccupy =new int[9+1][9+1];
		occupy =new boolean[9+1][9+1];
		for(int x=1;x<=9;x++){
			Arrays.fill(occupy[x], false);
		}
	}
	
	public void FillMatrix(int[][] matrix){
		for(int y=1;y<=9;y++){
			for(int x=1;x<=9;x++){
				if(matrix[x][y]!=0){
					setItem(x, y, matrix[x][y]);
				}
			}
		}
	}
	

	/**
	 * 设置一个格里的内容
	 * @param x 
	 * @param y
	 * @param val
	 */
	public void setItem(int x,int y,int val){
		sudoku[x][y]=val;
		columnOccupy[x][val]=y;
		rowOccupy[y][val]=x;
		occupy[shiftcoord[x][y]][val]=true;
		sum1++;//统计探索次数用
	}
	
	
	/**
	 * 删除一个格里的内容
	 * @param x
	 * @param y
	 */
	public void delItem(int x,int y){
		int val=sudoku[x][y];
		if(val!=0){			
			columnOccupy[x][val]=0;
			rowOccupy[y][val]=0;
			occupy[shiftcoord[x][y]][val]=false;
			sudoku[x][y]=0;

		}
		

	}
	
	/**
	 * 解程序
	 */
	public void Solve(){
		xun(1,1,true);	
	} 
	
	/**
	 * @param val
	 * @param y
	 * @param flag true 第一次 调用 ， false 不是第一次调用
	 */
	public void xun(int val,int y,boolean flag){
		//找到1个解就停止，
		if(sum>=1)return;
		
		if(flag==false){
			if(++y>9){
				y=1;
				if(++val>9){
					sum++;
					//此处需添加保存正确解的程序，
					print();
					
					System.out.println("sum++");
					return;
				}
			}

		}

		if(rowOccupy[y][val]!=0){//同行无重复
			xun(val, y, false);
			return ;
		}
		for(int x=1;x<=9;x++){
			if(sudoku[x][y]!=0)continue;//该单元格有没有数据
			if(columnOccupy[x][val]!=0)continue;//通列无重复
			if(occupy[shiftcoord[x][y]][val]==true)continue;//通3x3个内无重复
			setItem(x, y, val);
			xun(val, y, false);
			delItem(x, y);
		}
	}
	
	
	/**
	 * 输出当前解
	 */
	void print(){
		System.out.println("Solve "+sum);
		for(int y=1;y<=9;y++){
			for(int x=1;x<=9;x++){
				System.out.print(sudoku[x][y]+",");
			}
			System.out.println("");
		}
	}

}
