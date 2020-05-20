/*
javac -encoding UTF-8 YCNo1005.java
java YCNo1005
*/
import java.util.*;

public class YCNo1005{
	private static final int MIN_LENGTH = 1,MAX_LENGTH = 1000;
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			String s;
			do{
				s = sc.next();
			}while( !isChecked(s) );
			
			String t;
			do{
				t = sc.next();
			}while( !isChecked(t) );
			
			System.out.println(result(s,t));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* 文章（s）／BOT文字列（t）が有効な文字列数かを判定
	* @param 文章（s）／BOT文字列（t）
	* @return 真偽値
	*/
	private static boolean isChecked(String target){
		if(MIN_LENGTH <= target.length() && target.length() <= MAX_LENGTH){
			if(target.matches("^[a-z]+")){
				return true;
			}
		}
		return false;
	}
	/**
	* BOT文字列（t）に反応しないための文字挿入回数を特定し返却
	* @param 文章（s）／BOT文字列（t）
	* @return 最小の文字挿入回数
	*/
	private static int result(String s,String t){
		int result = 0;
		StringBuilder sb = new StringBuilder(s);
		
		if(sb.indexOf(t) > -1){
			int work = sb.indexOf(t) + t.length();
			result++;
			
			while(sb.indexOf(t,work) != -1){
				work = sb.indexOf(t,work) + t.length();
				result++;
			}
		}
		return result;
	}
}