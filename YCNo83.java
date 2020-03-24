/*
javac -encoding UTF-8 YCNo83.java
java YCNo83
*/
import java.util.*;

public class YCNo83{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int matchstick;
			do{
				matchstick = sc.nextInt();
			}while(isEnabled(matchstick));
			int[] array = new int[matchstick/2];
			boolean result = (matchstick % 2 == 0)? true:false;
			if(result){
				Arrays.fill(array,1);
			}else{
				array[0] = 7;
				Arrays.fill(array,1,array.length,1);
			}
			Arrays.stream(array).forEach(a -> System.out.print(a));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	*マッチ棒の本数が有効な範囲かの判定
	* @param マッチ棒の本数
	* @return 真偽値
	*/
	private static boolean isEnabled(int target){
		if( !(2 <= target && target <= Math.pow(10,5)) ){
			return true;
		}
		return false;
	}
}
