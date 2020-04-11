/*
javac -encoding UTF-8 YCNo123.java
java YCNo123
*/
import java.util.*;
import java.util.stream.IntStream;

public class YCNo123{
	private static final int lOWERLIMIT = 1;
	private static final int MAX_CARD = 50,MAX_SHUFFLETIMES = 100000;
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			
			//カードの最大の数字取得
			int card;
			do{
				card = Integer.parseInt(sc.next());
			}while( !isCard(card) );
			
			//シャッフルする回数取得
			int shuffleTimes;
			do{
				shuffleTimes = Integer.parseInt(sc.next());
			}while( !isShuffleTimes(shuffleTimes) );
			
			//シャッフルの回数分、カードを引き抜く場所（番目）を取得し配列に格納
			int shuffleNumber;
			int[] shuffleArray = new int[shuffleTimes];
			for(int i = 0 ; i < shuffleTimes ; i++){
				do{
					shuffleNumber = Integer.parseInt(sc.next());
				}while( !isSHUFFLE(shuffleNumber,card) );
				shuffleArray[i] = shuffleNumber;
			}
			
			//全カードの配列生成
			int[] cardArray = IntStream.rangeClosed(lOWERLIMIT,card).toArray();
			
			//全カードの配列をリスト化
			List<Integer> cardList = new ArrayList<Integer>();
			for(int i : cardArray){
				cardList.add(Integer.valueOf(i));
			}
			
			//出力
			System.out.println(result(cardList,shuffleArray));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* カードの最大値数が有効な範囲か判定
	* @param カードの値
	* @return 真偽値
	*/
	private static boolean isCard(int target){
		if(lOWERLIMIT <= target && target <= MAX_CARD){
			return true;
		}
		return false;
	}
	/**
	* シャッフルの回数の値が有効な範囲か判定
	* @param シャッフルの回数の値
	* @return 真偽値
	*/
	private static boolean isShuffleTimes(int target){
		if(lOWERLIMIT <= target && target <= MAX_SHUFFLETIMES){
			return true;
		}
		return false;
	}
	/**
	* シャッフルの値が有効な範囲か判定
	* @param シャッフル時の値
	* @return 真偽値
	*/
	private static boolean isSHUFFLE(int target,int card){
		if(lOWERLIMIT <= target && target <= card){
			return true;
		}
		return false;
	}
	/**
	* シャッフルが行われた後にいちばん上にあるカードの数字出力
	* @param カードリスト、シャッフルする番号の配列
	* @return 一番上のカードナンバー
	*/
	private static int result(List<Integer> cardList,int[] shuffleArray){
		for(int number : shuffleArray){
			int work = cardList.get(number-1);
			cardList.remove(cardList.indexOf(cardList.get(number-1)));
			cardList.add(0,work);
		}
		return cardList.get(0);
	}
}