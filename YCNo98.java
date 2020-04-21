/*
javac -encoding UTF-8 YCNo98.java
java YCNo98
*/
import java.util.*;

public class YCNo98{
	private static final int MIN_YX = -10000,MAX_YX = 10000;
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int y;
			do{
				y = sc.nextInt();
			}while( !isChecked(y) );
			
			int x;
			do{
				x = sc.nextInt();
			}while( !isChecked(x) );
			
			System.out.println(result(y,x));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* y軸x軸が有効な範囲化のチェック
	* @param y軸／x軸
	* @return 真偽値
	*/
	private static boolean isChecked(int target){
		if(MIN_YX <= target && target <= MAX_YX){
			return true;
		}
		return false;
	}
	/**
	* 描ける円の最小の直径出力
	* @param ｙ軸、ｘ軸
	* @return 結果
	*/
	private static int result(int y,int x){
		double sqrt = Math.sqrt(Math.pow(y,2) + Math.pow(x,2));
		return (int)(sqrt * 2) + 1;
	}
}