/*
javac -encoding UTF-8 YCNo172.java
java YCNo172
*/
import java.util.*;

public class YCNo172{
	private static final int MIN_XY = -100,MAX_XYR = 100;
	private static final int MIN_R = 1;
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int x;
			do{
				x = sc.nextInt();
			}while( !isChecked(x) );
			
			int y;
			do{
				y = sc.nextInt();
			}while( !isChecked(y) );
			
			int r;
			do{
				r = sc.nextInt();
			}while( !isR(r) );
			
			double work = 1.42 * r;
			int result = (int)Math.ceil((Math.abs(x) + Math.abs(y)) + work);
			System.out.println(result);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* X軸、Y軸の値が有効な範囲かを判定
	* @param X軸、Y軸
	* @return 真偽値
	*/
	private static boolean isChecked(int target){
		if(MIN_XY <= target && target <= MAX_XYR){
			return true;
		}
		return false;
	}
	/**
	* 半径rの値が有効な範囲かを判定
	* @param 半径r
	* @return 真偽値
	*/
	private static boolean isR(int target){
		if(MIN_R <= target && target <= MAX_XYR){
			return true;
		}
		return false;
	}
}