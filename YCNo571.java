/*
javac -encoding UTF-8 YCNo571.java
java YCNo571
*/
import java.util.*;

public class YCNo571{
	private static final int MIN_HEIGHT = 150,MAX_HEIGHT = 200;
	private static final int MIN_WEIGHT = 50,MAX_WEIGHT = 100;
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			/**
			* [n][0]：人物を特定するキー
			* [n][1]：身長
			* [n][2]：体重
			*/
			int[][] array = new int[3][3];
			for(int i = 0 ; i < 3 ; i++){
				array[i][0] = i;
				do{
					array[i][1] = sc.nextInt();
				}while( !isHeight(array[i][1]) );
				
				do{
					array[i][2] = sc.nextInt();
				}while( !isWeight(array[i][2]) );
			}
			
			rankSort(array);
			result(array);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* 身長が有効な範囲かを判定
	* @param 身長
	* @return 真偽値
	*/
	private static boolean isHeight(int target){
		if(MIN_HEIGHT <= target && target <= MAX_HEIGHT){
			return true;
		}
		return false;
	}
	/**
	* 体重が有効な範囲かを判定
	* @param 体重
	* @return 真偽値
	*/
	private static boolean isWeight(int target){
		if(MIN_WEIGHT <= target && target <= MAX_WEIGHT){
			return true;
		}
		return false;

	}
	/**
	* 身長と体重から順位を特定しセット
	* @param 身長体重の配列
	*/
	private static void rankSort(int[][] array){
		Arrays.sort(array, (a, b) -> Integer.compare(b[1], a[1]));
		if(array[0][1] == array[1][1] && array[1][1] == array[2][1]){
			Arrays.sort(array, (a, b) -> Integer.compare(a[2], b[2]));
		}
		int[][] work = new int[1][3];
		for(int i = 0 ; i < array.length-1 ; i++){
			if(array[i][1] == array[i+1][1]){
				if(array[i][2] > array[i+1][2]){
					work[0][0] = array[i][0];
					work[0][1] = array[i][1];
					work[0][2] = array[i][2];
					
					array[i][0] = array[i+1][0];
					array[i][1] = array[i+1][1];
					array[i][2] = array[i+1][2];
					
					array[i+1][0] = work[0][0];
					array[i+1][1] = work[0][1];
					array[i+1][2] = work[0][2];
				}
			}
		}
	}
	/**
	* 順位に応じて結果出力
	* @param 身長体重の配列
	*/
	private static void result(int[][] array){
		for(int i = 0 ; i < array.length ; i++){
			switch(array[i][0]){
				case 0:
					System.out.println("A");
					break;
				case 1:
					System.out.println("B");
					break;
				default :
					System.out.println("C");
			}
		}
	}
}