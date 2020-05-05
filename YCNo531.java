/*
javac -encoding UTF-8 YCNo531.java
java YCNo531
*/
import java.util.*;

public class YCNo531{
	private static final int MIN_NM = 2;
	private static final int MAX_N = 100000,MAX_M = 50;
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int n;
			do{
				n = sc.nextInt();
			}while( !isChecked(n,0) );
			int m;
			do{
				m = sc.nextInt();
			}while( !isChecked(m,1) );
			
			System.out.println(result(n,m));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* 動物の数／船に乗れる数が有効な範囲かチェック
	* @param 動物の数／船に乗れる数、チェックナンバー
	* @return 真偽値
	*/
	private static boolean isChecked(int target,int check){
		switch(check){
			case 0:
				if(MIN_NM <= target && target <= MAX_N){
					return true;
				}
			case 1:
				if(MIN_NM <= target && target <= MAX_M){
					return true;
				}
			default :
				return false;
		}
	}
	/**
	* 引っ越しするための最短日数を出力
	* @param 動物の数、船に乗れる数
	* @return 判定結果
	*/
	private static int result(int n,int m){
		int result = 0;
		if(n <= m) {
			result = 1;
		}else {
			if(n % 2 == 0 && 2 * m >= n) {
				result = 2;
			}else {
				result = -1;
			}
		}
		return result;
	}
} 