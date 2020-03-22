/*
javac -encoding UTF-8 YCNo51.java
java YCNo51
*/
import java.util.*;
import java.lang.Math;

public class YCNo51{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int W;
			do{
				W = sc.nextInt();
			}while(isEnabled(W));
			int D;
			do{
				D = sc.nextInt();
			}while(isEnabled(D));
			int result = W;
			for(int i = D ; i > 1 ; i--){
				result -= Math.floor(result / Math.pow(i,2));
			}
			System.out.println(result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	*作業量／納期が有効な範囲かの判定
	* @param 作業量／納期
	* @return 真偽値
	*/
	private static boolean isEnabled(int target){
		if( !(1 <= target && target <= Math.pow(10,5)) ){
			return true;
		}
		return false;
	}
}