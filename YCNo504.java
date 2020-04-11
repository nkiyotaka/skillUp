/*
javac -encoding UTF-8 YCNo504.java
java YCNo504
*/
import java.util.*;

public class YCNo504{
	private static final int lOWERLIMIT = 1;
	private static final int MAX_PLAYERNUMBER = 100000;
	private static final long MAX_SCORE = 1000000000L;
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			
			//プレイ人数取得
			int playerNumber;
			do{
				playerNumber = sc.nextInt();
			}while( !isPlayerNumber(playerNumber) );
			
			//プレイヤー人数分のスコア取得し、配列格納
			long[] scoreArray = new long[playerNumber];
			for(int i = 0 ; i < playerNumber ; i++){
				long score;
				do{
					score = sc.nextInt();
				}while( !isScore(score) );
				scoreArray[i] = score;
			}
			//出力
			result(scoreArray);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* プレイヤー人数の値が有効な範囲か判定
	* @param プレイヤー人数
	* @return 真偽値
	*/
	private static boolean isPlayerNumber(int target){
		if(lOWERLIMIT <= target && target <= MAX_PLAYERNUMBER){
			return true;
		}
		return false;
	}
	/**
	* スコアの値が有効な範囲か判定
	* @param スコア
	* @return 真偽値
	*/
	private static boolean isScore(long target){
		if(lOWERLIMIT <= target && target <= MAX_SCORE){
			return true;
		}
		return false;
	}
	/**
	* スコアに応じて現在の順位出力
	* @param スコア配列
	*/
	private static void result(long[] scoreArray){
		int rank = 1;
		for(int i = 0 ; i < scoreArray.length ; i++){
			if(scoreArray[0] < scoreArray[i]){
				System.out.println(++rank);
			}else{
				System.out.println(rank);
			}
		}
	}
}