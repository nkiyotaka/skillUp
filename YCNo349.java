/*
javac -encoding UTF-8 YCNo349.java
java YCNo349
*/
import java.util.*;

public class YCNo349{
	private static final int MIN_STEAMS_AND_BRANCHES = 2,MAX_STEAMS_AND_BRANCHES = 50;
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			
			//干支12種類をマップ（key：干支名、value：個数）で初期化
			Map<String,Integer> map = new HashMap<String,Integer>(){
				{put("ne",0);}
				{put("ushi",0);}
				{put("tora",0);}
				{put("u",0);}
				{put("tatsu",0);}
				{put("mi",0);}
				{put("uma",0);}
				{put("hitsuji",0);}
				{put("saru",0);}
				{put("tori",0);}
				{put("inu",0);}
				{put("i",0);}
			};
			
			//置物を置く数を入れる変数
			int stemsAndBranches;
			
			//置く数を取得
			do{
				stemsAndBranches = Integer.parseInt(sc.nextLine());
			}while( !isStemsAndBranches(stemsAndBranches) );
			
			//取得した置く数の分、置く干支名取得
			for(int i = 0 ; i < stemsAndBranches ; i++){
				String name = sc.nextLine();
				
				//取得した干支名が重複していたらvalueに+1
				if(map.containsKey(name)){
					map.put(name,map.get(name)+1);
				}
			}
			
			//結果取得し出力
			boolean result = result(map,stemsAndBranches);
			System.out.println(result ? "YES" : "NO");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* 干支の置物のを置く数が有効な範囲かを判定
	* @param 干支の置物を置く数
	* @return 真偽値
	*/
	private static boolean isStemsAndBranches(int target){
		if(MIN_STEAMS_AND_BRANCHES <= target && target <= MAX_STEAMS_AND_BRANCHES){
			return true;
		}
		return false;
	}
	/**
	* 干支の置物を横に（同じ干支の種類を隣に並べずに）一列で並べられるかを判定
	* @param マップ、干支の置物を置く数
	* @return 真偽値
	*/
	private static boolean result(Map<String,Integer> map,int stemsAndBranches){
		for(int i : map.values()){
			if(i > Math.round((double)stemsAndBranches / 2)){
				return false;
			}
		}
		return true;
	}
}