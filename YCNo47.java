/*
javac -encoding UTF-8 YCNo47.java
java YCNo47
*/
import java.util.*;

public class YCNo47{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			boolean flag = true;
			int biscuit = 0;
			while(flag){
				biscuit = sc.nextInt();
				flag = numCheck(biscuit);
			}
			int magicCnt = 0;
			int counter = 1;
			while( !flag ){
				magicCnt = counter;
				if(Math.pow(2,counter) >= biscuit){
					System.out.println(magicCnt);
					break;
				}
				counter++;
			}
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
