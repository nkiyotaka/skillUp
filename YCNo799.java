/*
javac -encoding UTF-8 YCNo799.java
java YCNo799
*/
import java.util.*;

public class YCNo799{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int redCard1 = onceSpot(sc), redCard2 = secondTime(sc,redCard1);
			int brackCard1 = onceSpot(sc), brackCard2 = secondTime(sc,brackCard1);
			int[] redBox = contentSet(redCard1,redCard2);
			int[] brackBox = contentSet(brackCard1,brackCard2);
			result(redBox,brackBox);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* 一つ目の箱からカード取得
	* @param スキャナー変数
	* @return
	*/
	private static int onceSpot(Scanner sc){
		boolean flag = true;
		int card = 0;
		while(flag){
			card = sc.nextInt();
			flag = cardCheck(card);
		}
		return card;
	}
	/**
	* 取得したカードが適正値であるか判定
	* @param カード
	* @return
	*/
	private static boolean cardCheck(int card){
		if(card >= 1 && card <= 100){return false;}
		return true;
	}
	/**
	* 二つ目の箱からカード取得（一つ目のカードより高いことが条件）
	* @param スキャナー変数、一つ目のカード
	* @return
	*/
	private static int secondTime(Scanner sc,int card1){
		int card2 = 0;
		while( !(card1 <= card2) ){
			card2 = onceSpot(sc);
		}
		return card2;
	}
	/**
	* 全部のカードをセット
	* @param 一つ目のカード、二つ目のカード
	* @return
	*/
	private static int[] contentSet(int card1,int card2){
		int[] box = new int[(card2-card1)+1];
		for(int i = card1,cnt = 0 ; i <= card2 ; i++,cnt++){
			box[cnt] = i;
		}
		return box;
	}
	/**
	* 結果表示
	* @param 赤の全カード、黒の全カード
	* @return
	*/
	private static void result(int[] redBox,int[] brackBox){
		int counter = 0;
		for(int a : redBox){
			for(int b : brackBox){
				if(a != b){
					counter++;
				}
			}
		}
		System.out.println(counter);
	}
}