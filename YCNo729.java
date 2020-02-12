/*
javac -encoding UTF-8 YCNo729.java
java YCNo729
*/
import java.util.*;

public class YCNo729{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		try{
			String line = null;
			while(!((line = sc.nextLine()).length() >= 2 && line.length() <= 10)){
				;
			}
			StringBuilder sb = new StringBuilder(line);
			
			String[] index = null;
			boolean flag = true;
			while(flag){
				index = sc.nextLine().split(" ");
				flag = stringCount(index,line);
			}
			
			int previous = Integer.valueOf(index[0]),after = Integer.valueOf(index[1]);
			char work = sb.charAt(previous);
			sb.setCharAt(previous,sb.charAt(after));
			sb.setCharAt(after,work);
			
			System.out.println(sb.toString());
		}catch(Exception e){
			;
		}finally{
			sc.close();
		}
	}
	/**
	* 配列のインデックス値判定
	* @param インデックス値（文字列）,文字列
	* @return
	*/
	private static boolean stringCount(String[] index,String line){
		for(String num : index){
			if( !(Integer.valueOf(num) >= 0 && Integer.valueOf(num) <= line.length()-1) ){
				return true;
			}
		}
		return false;
	}
}