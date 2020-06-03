/*
javac -encoding UTF-8 YCNo7.java
java YCNo7
*/
import java.util.*;

public class YCNo7{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int num = sc.nextInt();
			List<Integer> list = getList(num);
			
			System.out.println(result(num,list));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* 素数リストを取得
	* @param 整数
	* @return 素数リスト
	*/
	private static List<Integer> getList(int target){
		List<Integer> list = new ArrayList<Integer>();
		boolean prime;
		if(target == 2){
			list.add(target);
		}
		else{
			for(int i = 2 ; i < target ; i++){
				prime = true;
				for(int j = 2 ; j < i ; j++){
					if(i % j == 0){
						prime = false;
					}
				}
				if(prime){
					list.add(i);
				}
			}
		}
		return list;
	}
	/**
	* 勝敗判定
	* @param 整数、リスト
	* @return 結果
	*/
	private static String result(int num,List<Integer> list){
		int work = list.size()-1;
		int counter = 0;
		boolean result = true;
		while(result){
			num -= list.get(work);
			if(num < 3){
				result = false;
			}
			for(int i = num ; i > 0 ; i--){
				if(list.indexOf(i) >= 0){
					work = list.indexOf(i);
				}
			}
			counter++;
		}
		if(counter % 2 != 0){
			if(num == 2){
				return "WIN";
			}else{
				return "LOSE";
			}
		}else{
			if(num == 2){
				return "LOSE";
			}else{
				return "WIN";
			}
		}
	}
}