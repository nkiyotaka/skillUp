/*
javac -encoding UTF-8 YCNo45.java
java YCNo45
*/
import java.util.*;

public class YCNo45{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int n = sc.nextInt();
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 0 ; i < n ; i++){
				list.add(sc.nextInt());
			}
			
			System.out.println(result(list));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	*最大の合計値取得
	* @param リスト
	* @return 合計値
	*/
	private static int result(List<Integer> list){
		int loop = Math.round((float)list.size()/2);
		int result = 0;
		
		for(int i = 0 ; i < loop ; i++){
			if(list.size() == 0){
				break;
			}
			Integer max = Collections.max(list);
			int index = list.indexOf(max);
			if(index > 0 && index < list.size()-1){
				result += max;
				list.remove(index+1);
				list.remove(index);
				list.remove(index-1);
			}else{
				if(index == 0){
					if(index < list.size()-1){
						result += max;
						list.remove(index+1);
						list.remove(index);
					}else{
						result += max;
						list.remove(index);
					}
				}else if(index == list.size()-1){
					if(index > 0){
						result += max;
						list.remove(index);
						list.remove(index-1);
					}else{
						result += max;
						list.remove(index);
					}
				}
			}
		}
		return result;
	}
}