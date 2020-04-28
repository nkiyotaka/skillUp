/*
javac -encoding UTF-8 YCNo445.java
java YCNo445
*/
import java.util.*;

public class YCNo445{
	private static final int MIN_NK = 1;
	private static final int MAX_N = 6,MAX_K = 10000;
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			double N;
			do{
				N = sc.nextDouble();
			}while( !isN(N) );
			
			double K;
			do{
				K = sc.nextDouble();
			}while( !isK(K) );
			
			System.out.println(result(N,K));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* 問題数Nが有効な範囲か判定
	* @param 問題数
	* @return 真偽値
	*/
	private static boolean isN(double target){
		if(MIN_NK <= target && target <= MAX_N){
			return true;
		}
		return false;
	}
	/**
	* 解いた時の番号Kが有効な範囲か判定
	* @param 解いた番号
	* @return 真偽値
	*/
	private static boolean isK(double target){
		if(MIN_NK <= target && target <= MAX_K){
			return true;
		}
		return false;
	}
	/**
	* 得点結果出力
	* @param 問題数、解いた番号
	* @return 得点
	*/
	private static int result(double N,double K){
		double work = (0.2 * K) + 0.8;
		double temp = 50 * N;
		return (int)temp + (int)(temp / work);
	}
}