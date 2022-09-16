package MineSweeper;

import java.util.Arrays;
import java.util.Scanner;

public class MineSweeper {
	int count=0;
	int R=3;
	int C=3;
	int[][] backBoard=new int[this.R][this.C];
		
	public void setCount() {
		this.count=0;
	}	
	public void check(int r,int c) {
		if((r>=0 && r<this.R) && (c>=0 && c<this.C) && backBoard[r][c]!=0) {
			this.count++;
		}	
	}	
	public void run() {
		Scanner scan=new Scanner(System.in);
		int row,col,i,j,k;
		int flag=0;
		int cellCount=0;
		char[][] gameBoard= new char[this.R][this.C];		
		int mineNumber=(gameBoard.length)*(gameBoard[0].length)/4;
		double[] mineRow=new double[mineNumber];
		double[] mineCol=new double[mineNumber];
		// creating a zero matrix named backBoard
		for(i=0;i<this.backBoard.length;i++) {					
			Arrays.fill(backBoard[i],0);
		}
		for(i=0;i<gameBoard.length;i++) {
			Arrays.fill(gameBoard[i], '-');
		}
		for(i=0;i<mineNumber;i++) {
			mineRow[i]=Math.ceil((double)Math.random()*(this.R-1));
		}
		System.out.println(Arrays.toString(mineRow));
		for(i=0;i<mineNumber;i++) {
			mineCol[i]=Math.ceil((double)Math.random()*(this.C-1));
		}
		System.out.println(Arrays.toString(mineCol));
		// putting bombs into backBoard
		for(i=0;i<mineNumber-1;i++) {							
			backBoard[(int)mineRow[i]][(int)mineCol[i]]=1;
		}
		
		do{
			System.out.print("Satir giriniz:");
			row=scan.nextInt();
			System.out.println();
			System.out.print("Sutun giriniz:");
			col=scan.nextInt();
			for(i=0;i<mineNumber;i++) {
				if(row==mineRow[i] && col==mineCol[i]) {
					//there's a bomb				
					flag=1;									
				}
			}		
			for(j=row-1;j<row+2;j++) {
				for(k=col-1;k<col+2;k++) {
					if(j==row && k==col) {
						continue;
					}else {
						check(j,k);	
					}														
				}
			}
			gameBoard[row][col]=(char) ((this.count)+'0');
			cellCount++;	
			this.setCount();
			for(i=0;i<gameBoard.length;i++) {
				for(j=0;j<gameBoard[0].length;j++) {
					System.out.print(gameBoard[i][j]);
				}
				System.out.println();
			}
					
		}while(flag==0 && cellCount<(this.R*this.C)-mineNumber);
		if(flag==1) {
			System.out.println("Game Over!");
		}else {
			System.out.println("You Win!");
		}
			
		

	}
	
		

}
