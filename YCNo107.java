/*
javac -encoding UTF-8 YCNo107.java
java YCNo107
*/
import java.util.*;

public class YCNo107{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			
			//モンスターの数取得
			int n = sc.nextInt();
			
			//モンスターを格納するリストを生成
			List<Integer> monsterList = new ArrayList<Integer>();
			
			//モンスターの数分、モンスターをリストに追加
			for(int i = 0 ; i < n ; i++){
				monsterList.add(sc.nextInt());
			}
			
			//攻撃モンスターと回復モンスターに振り分け
			List<Integer> monsters = new ArrayList<Integer>();
			List<Integer> recoveryMonsters = new ArrayList<Integer>();
			for(int m : monsterList){
				if(m < 0){
					monsters.add(m);
				}else{
					recoveryMonsters.add(m);
				}
			}
			//結果出力
			result(monsters,recoveryMonsters,n);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* 残HPの出力
	* @param 攻撃モンスター、回復モンスター、モンスター数
	*/
	private static void result(List<Integer> monsters,List<Integer> recoveryMonsters,int n){
		int HP = 100;
		int maxHP = 100;
		boolean result = false;
		for(int i = 0 ; i < n ; i++){
			//HPより低い攻撃モンスターがいる場合
			if(decisionMonster(HP,monsters)){
				int work = fight(HP,monsters);
				HP += work;
				maxHP += 100;
				monsters.remove(monsters.indexOf(work));
			//一番弱い攻撃モンスターより、回復量が多い回復モンスターがいる場合
			}else if(decisionRecovery(monsters,recoveryMonsters)){
				HP += recovery(monsters,recoveryMonsters);
				if(maxHP < HP){
					HP = maxHP;
				}
				recoveryMonsters.remove(recoveryMonsters.indexOf(recovery(monsters,recoveryMonsters)));
			}else{
				result = true;
				break;
			}
		}
		if(result){
			System.out.println(0);
		}else{
			System.out.println(HP);
		}
	}
	/**
	* HPより低いモンスターの中から一番強いモンスターを返却
	* @param HP、攻撃モンスター
	* @return HPより低いモンスターの中から一番強いモンスター
	*/
	private static int fight(int HP,List<Integer> monsters){
		List<Integer> list = new ArrayList<Integer>();
		for(int m : monsters){
			if(HP > Math.abs(m)){
				list.add(m);
			}
		}
		return Collections.min(list);
	}
	/**
	* HPより低い攻撃モンスターがいるかを判定
	* @param HP、攻撃モンスターリスト
	* @return 真偽値
	*/
	private static boolean decisionMonster(int HP,List<Integer> monsters){
		boolean decision = false;
		for(int m : monsters){
			if(HP > Math.abs(m)){
				decision = true;
			}
		}
		return decision;
	}
	/**
	* 1番弱い攻撃モンスター以上の回復量を持つ回復モンスターを返却
	* @param 攻撃モンスターリスト、回復モンスターリスト
	* @return 1番弱い攻撃モンスター以上の回復量を持つ回復モンスター
	*/
	private static int recovery(List<Integer> monsters,List<Integer> recoveryMonsters){
		List<Integer> list = new ArrayList<Integer>();
		int monster = 0;
		if(monsters.size() != 0){
			monster = Collections.max(monsters);
		}

		for(int r : recoveryMonsters){
			if(Math.abs(monster) <= r){
				list.add(r);
			}
		}
		return Collections.min(list);
	}
	/**
	* 一番弱い攻撃モンスターより、回復量が多い回復モンスターがいるかを判定
	* @param 攻撃モンスターリスト、回復モンスターリスト
	* @return 真偽値
	*/
	private static boolean decisionRecovery(List<Integer> monsters,List<Integer> recoveryMonsters){
		boolean result = false;
		int monster = 0;
		if(monsters.size() == 0){
			result = true;
		}else{
			monster = Collections.max(monsters);
		}
		
		for(int r : recoveryMonsters){
			if(Math.abs(monster) <= r){
				result = true;
			}
		}
		return result;
	}
}
