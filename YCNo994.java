/*
javac -encoding UTF-8 YCNo994.java
java YCNo994
*/
import java.util.*;

public class YCNo994{
	private static final int MIN_TREE = 2,MAX_TREE = 100000;
	private static final int MIN_COIN = 1,MAX_COIN = 100000;
	
	public static void main(String[] args){
		try(Scanner sc = new  Scanner(System.in)){
			int tree;
			do{
				tree = Integer.parseInt(sc.next());
			}while( !isTree(tree) );
			
			int coin;
			do{
				coin = Integer.parseInt(sc.next());
			}while( !isCoin(coin) );
			
			sc.nextLine();
			Map<Integer,Integer> map = new HashMap<>();
			for(int i = 0 ; i < tree-1 ; i++){
				int treeVertex,coinNumber;
				do{
					coinNumber = Integer.parseInt(sc.next());
					treeVertex = Integer.parseInt(sc.next());
				}while( !isChecked(treeVertex,coinNumber,tree) );
				map.put(treeVertex,coinNumber);
			}
			
			result(map,coin);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* 向こう木の頂点の数が有効な範囲か判定
	* @param 木
	* @return 真偽値
	*/
	private static boolean isTree(int target){
		if(MIN_TREE <= target && target <= MAX_TREE){
			return true;
		}
		return false;
	}
	/**
	* コインの値が有効な範囲か判定
	* @param コイン
	* @return 真偽値
	*/
	private static boolean isCoin(int target){
		if(MIN_COIN <= target && target <= MAX_COIN){
			return true;
		}
		return false;
	}
	/**
	* 渡すコイン及び渡される木の頂点の値が有効な範囲か判定
	* @param 渡す木の頂点、コイン枚数、木の頂点の数
	* @return 真偽値
	*/
	private static boolean isChecked(int... check){
		for(int i = 0 ; i < check.length-1 ; i++){
			if(MIN_COIN <= check[i] && check[i] <= check[2]){
				return true;
			}
		}
		return false;
	}
	/**
	* コインの枚数に応じて結果出力
	* @param マップ（コイン枚数、渡す木の頂点）、コイン
	* @return 真偽値
	*/
	private static void result(Map<Integer,Integer> map,int coin){
		int cnt =  0;
		boolean result = false;
		for(int i : map.values()){
			if(i == 1 && coin != 1){
				cnt++;
				coin--;
			}
			if(coin == 1 || coin == 0){
				result = true;
			}
		}
		System.out.println(result ? cnt : -1);
	}
}