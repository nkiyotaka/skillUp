/*
javac -encoding UTF-8 YCNo799.java
java YCNo799
*/
import java.util.*;

public class YCNo799{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int redBox1 = onceSpot(sc), redBox2 = secondTime(sc,redBox1);
			int brackBox1 = onceSpot(sc), brackBox2 = secondTime(sc,brackBox1);
			int[] array1 = contentSet(redBox1,redBox2);
			int[] array2 = contentSet(brackBox1,brackBox2);
			result(array1,array2);
			
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
		int card1 = 0;
		while(flag){
			card1 = sc.nextInt();
			flag = noCheck(card1);
		}
		return card1;
	}
	/**
	* 取得したカードが適正値であるか判定
	* @param カード
	* @return
	*/
	private static boolean noCheck(int card){
		if(card >= 1 && card <= 100){return false;}
		return false;
	}
	/**
	* 二つ目の箱からカード取得（一つ目のカードより高いことが条件）
	* @param スキャナー変数、一つ目のカード
	* @return
	*/
	private static int secondTime(Scanner sc,int redBox1){
		int card2 = 0;
		while( !(redBox1 <= card2) ){
			card2 = onceSpot(sc);
		}
		return card2;
	}
	/**
	* 全部のカードをセット
	* @param 一つ目のカード、二つ目のカード
	* @return
	*/
	private static int[] contentSet(int box1,int box2){
		int[] array = new int[(box2-box1)+1];
		for(int i = box1,cnt = 0 ; i <= box2 ; i++,cnt++){
			array[cnt] = i;
		}
		return array;
	}
	/**
	* 結果表示
	* @param 赤の全カード、黒の全カード
	* @return
	*/
	private static void result(int[] array1,int[] array2){
		int counter = 0;
		for(int a : array1){
			for(int b : array2){
				if(a != b){
					counter++;
				}
			}
		}
		System.out.println(counter);
	}
}