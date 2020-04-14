/*
javac -encoding UTF-8 YCNo149.java
java YCNo149
*/
import java.util.*;

public class YCNo149{
	private static final int lOWERLIMIT = 0;
	private static final int MAX_TOMBSTONE = 100000;
	private static final int FETCH_TOMBSTONE = 200000;
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			
			//墓石が入る袋Aと袋Bの配列変数を初期化
			int[] tombstoneA = null;
			int[] tombstoneB = null;
			
			//袋Aと袋Bを2回入れるためのカウンター変数初期化
			int counter = 0;
			
			//袋Aと袋Bに入っている墓石の数（数：白い碁石、数：黒い碁石）を半角区切り（” ”）で取得
			while(counter != 2){
				int[] tombstone;
				do{
					String[] work = sc.nextLine().split(" ");
					tombstone = Arrays.stream(work).mapToInt(a -> Integer.parseInt(a)).toArray();
				}while( !isTombstone(tombstone) );
				
				//カウンター変数「0」の場合、袋Aの配列にセット
				//上記以外の場合、袋Bの配列にセット
				if(counter == 0){
					tombstoneA = new int[tombstone.length];
					tombstoneA = tombstone;
					counter++;
				}else{
					tombstoneB = new int[tombstone.length];
					tombstoneB = tombstone;
					counter++;
				}
			}
			
			//袋から墓石を移動するための数を入れる変数初期化
			int fetchTombstoneA = 0;
			int fetchTombstoneB = 0;
			
			//カウンター変数を「1」で再定義
			counter = 1;
			
			//袋から墓石を移動する数を取得
			while(counter != 3){
				int fetchTombstone;
				do{
					fetchTombstone = Integer.parseInt(sc.next());
				}while( !isFetchTombstone(fetchTombstone,counter) );
				
				//カウンター変数「1」の場合、袋Aから袋Bに移動するための墓石の数を保持する変数にセット
				//上記以外の場合、袋Bから袋Aに移動するための墓石の数を保持する変数にセット
				if(counter == 1){
					fetchTombstoneA = fetchTombstone;
					counter++;
				}else{
					fetchTombstoneB = fetchTombstone;
					counter++;
				}
			}
			
			//出力
			System.out.println(result(tombstoneA,tombstoneB,fetchTombstoneA,fetchTombstoneB));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* 墓石の数が有効な範囲か判定
	* @param 墓石の数
	* @return 真偽値
	*/
	private static boolean isTombstone(int[] target){
		boolean result = true;
		for(int i : target){
			if( !(lOWERLIMIT <= i && i <= MAX_TOMBSTONE) ){
				result = false;
			}
		}
		return result;
	}
	/**
	* 袋から墓石を移動する数が有効な範囲か判定
	* @param 墓石を移動する数、最大値に掛ける値
	* @return 真偽値
	*/
	private static boolean isFetchTombstone(int target,int num){
		if(lOWERLIMIT <= target && target <= (FETCH_TOMBSTONE * num)){
			return true;
		}
		return false;
	}
	/**
	* 可能性として有りうる最多の白い墓石の数を取得し返却
	* @param 袋A（0：白い墓石、1：黒い墓石）、袋B（0：白い墓石、1：黒い墓石）、移動する墓石の数（袋A→袋B）、移動する墓石の数（袋B→袋A）
	* @return 最多の白い墓石の数
	*/
	private static int result(int[] tombstoneA,int[] tombstoneB,int fetchTombstoneA,int fetchTombstoneB){
		List<Integer> list = new ArrayList<Integer>();
		
		//list[0]：移動する墓石の数（袋A→袋B） - 袋Aの黒い墓石の数
		list.add(fetchTombstoneA - tombstoneA[1]);
		
		//list[1]：袋Aの白い墓石の数にlist[0]を引いたもの
		list.add(tombstoneA[0] - list.get(0));
		
		//list[2]：袋Bの白い墓石の数にlist[0]を足したもの
		list.add(tombstoneB[0] + list.get(0));
		
		int result = 0;
		if(fetchTombstoneB < list.get(2)){
			result = list.get(1) + fetchTombstoneB;
		}else{
			result = list.get(2) + list.get(1);
		}
		return result;
	}
}