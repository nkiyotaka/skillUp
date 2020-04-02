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
			map.put(0,coin);
			for(int i = 0 ; i < tree-1 ; i++){
				int treeVertex,coinNumber;
				do{
					coinNumber = Integer.parseInt(sc.next());
					treeVertex = Integer.parseInt(sc.next());
				}while( !isChecked(treeVertex,coinNumber,tree) );
				map.put(treeVertex,coinNumber);
			}
			
			result(map,tree,coin);
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
			if( !(MIN_COIN <= check[i] && check[i] <= check[2]) ){
				return false;
			}
		}
		return true;
	}
	/**
	* コインの枚数に応じて結果出力
	* @param マップ（key:木の頂点、value:コイン数）、木の頂点の数、コイン
	*/
	private static void result(Map<Integer,Integer> map,int tree,int coin){
		int count =  0;
		if(tree >= coin){
			for(int coinNum : map.values()){
				if(coinNum == 1 && coin != 1){
					count++;
					coin--;
					map.put(0,map.get(0) - 1);
				}
			}
			if(map.get(0) > 1){
				count += map.get(0) - 1;
			}
			System.out.println(count);
		}else{
			System.out.println(-1);
		}
	}
}