/*
javac -encoding UTF-8 YCNo1041.java
java YCNo1041
*/
import java.util.*;

public class YCNo1041{
	private static final int MIN_N = 2,MIN_XY = 0;
	private static final int MAX_VALUE = 100;
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int n;
			do{
				n = sc.nextInt();
			}while( !isN(n) );
			
			int[][] xyArray = newArray(n,sc);
			
			System.out.println(result(xyArray));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* N個の値が有効な範囲か判定
	* @param n（ループ回数）
	* @return 真偽値
	*/
	private static boolean isN(int target){
		if(MIN_N <= target && target <= MAX_VALUE){
			return true;
		}
		return false;
	}
	/**
	* XYの値が有効な範囲か判定
	* @param X／Y
	* @return 真偽値
	*/
	private static boolean isXY(int target){
		if(MIN_XY <= target && target <= MAX_VALUE){
			return true;
		}
		return false;
	}
	/**
	* XYの配列生成
	* @param n（ループ回数）
	* @return xyの値が入った配列
	*/
	private static int[][] newArray(int n,Scanner sc){
		int[][] array = new int[n][n];
		int x,y;
		for(int i = 0 ; i < n ; i++){
			do{
				x = sc.nextInt();
			}while( !isXY(x) );
			
			array[i][0] = x;
			
			do{
				y = sc.nextInt();
			}while( !isXY(y) );
			
			array[i][1] = y;
		}
		return array;
	}
	/**
	* 同じ直線上にある点の数をカウントし返却
	* @param xyの値が入った配列
	* @return 点の数
	*/
	private static int result(int[][] array){
		int startPositionX = array[0][0];
		int startPositionY = array[0][1];
		int result = 1;
		if(startPositionX == startPositionY){
			int work = array[0][0];
			for(int i = 1 ; i < array.length ; i++){
				if(array[i][0] == array[i][1]){
					result += (work < array[i][0]) ? 1 : 0;
					work = array[i][0];
				}
			}
		}else{
			for(int i = 1 ; i < array.length ; i++){
				if(array[i][0] % startPositionX == 0 && array[i][1] % startPositionY == 0){
					result++;
				}
			}
		}
		return result;
	}
}