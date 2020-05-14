/*
javac -encoding UTF-8 YCNo1032.java
java YCNo1032
*/
import java.util.*;

public class YCNo1032{
	private static final int MIN_NUM = 1,MAX_NUM = 2*(int)Math.pow(10,5);
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int length;
			do{
				length = sc.nextInt();
			}while( !isChecked(length) );
			
			int to;
			do{
				to = sc.nextInt();
			}while( !isChecked(to) );
			
			Map<Integer,Integer> map = newMap(to);
			Map<Integer,Integer> resultMap = resultMap(length,sc,map);
			
			result(resultMap);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* 数列の長さ／求める範囲数／与えられる数列が有効な範囲かを判定
	* @param 数列の長さ／求める範囲数／与えられる数列
	* @return 真偽値
	*/
	private static boolean isChecked(int target){
		if(MIN_NUM <= target && target <= MAX_NUM){
			return true;
		}
		return false;
	}
	/**
	* 求める範囲数のマップを初期化
	* @param 求める範囲数
	* @return マップ
	*/
	private static Map<Integer,Integer> newMap(int to){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 1 ; i <= to ; i++){
			map.put(i,0);
		}
		return map;
	}
	/**
	* 数列が現れる回数をマップにカウントし返却
	* @param 数列の長さ、スキャナー、マップ
	* @return マップ
	*/
	private static Map<Integer,Integer> resultMap(int length,Scanner sc,Map<Integer,Integer> map){
		int num;
		for(int i = 1 ; i <= length ; i++){
			do{
				num = sc.nextInt();
			}while( !isChecked(num) );
			if(map.containsKey(num)){
				map.put(num,map.get(num)+1);
			}
		}
		return map;
	}
	/**
	* 結果出力
	* @param マップ
	*/
	private static void result(Map<Integer,Integer> resultMap){
		for(Map.Entry<Integer,Integer> entry : resultMap.entrySet()){
			System.out.println(entry.getKey()+ " " +entry.getValue());
		}
	}
}