/*
javac -encoding UTF-8 YCNo47.java
java YCNo47
*/
import java.util.*;

public class YCNo47{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int biscuit = 0;
			while(numCheck(biscuit)){
				biscuit = sc.nextInt();
			}
			int magicCnt = 0;
			while( !(Math.pow(2,magicCnt) >= biscuit) ){
				magicCnt++;
			}
			System.out.println(magicCnt);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	*食べたいビスケットの値が指定範囲内かのチェック
	* @param ビスケット数
	* @return
	*/
	private static boolean numCheck(int biscuit){
		if(biscuit >= 1 && biscuit <= 100000000){
			return false;
		}
		return true;
	}
}
