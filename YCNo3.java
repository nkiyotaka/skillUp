/*
javac -encoding UTF-8 YCNo3.java
java YCNo3
*/
import java.util.*;

public class YCNo3{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			//現在地（スタート1）
			int point = 1;
			
			//値取得（マスの値取得用変数）
			int value = 0;
			
			//ゴールの値
			int goal = sc.nextInt();
			
			//最短の移動数
			int result = 1;
			
			//重複判定用リスト
			List<Integer> list = new ArrayList<Integer>();
			
			while(point != goal){
				
				if(list.contains(point)){
					result = -1;
					break;
				}
				list.add(point);
				
				//指定されたint値の2の補数バイナリ表現での、1のビットの数を返す。
				value = Integer.bitCount(point);
				
				if((point+value) <= goal){
					point += value;
				}else{
					point -= value;
				}
				result++;
			}
			
			System.out.println(result);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}