/*
javac -encoding UTF-8 YCNo851.java
java YCNo851
*/
import java.util.*;

public class YCNo851{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int loop = 0;
			List<Long> list = new ArrayList<Long>();
			boolean processDecision = true;
			do{
				loop = sc.nextInt();sc.nextLine();
			}while(loopDecision(loop));
			
			do{
				String[] line = sc.nextLine().split(" ");
				processDecision = testDecision(line);
				if(processDecision){
					break;
				}
				inputValue(Long.parseLong(new String(line[0])),list);
			}while(list.size() != loop);
			result( !processDecision,list);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* 3であるかを判定
	* @param 入力値
	* @return
	*/
	private static boolean loopDecision(int loop){
		return (loop == 3) ? false : true;
	}
	/**
	* 配列の個数を判定
	* @param 文字列配列
	* @return
	*/
	private static boolean testDecision(String[] line){
		if(line.length > 1){
			return true;
		}
		return false;
	}
	/**
	* 範囲内の値かを判定
	* @param 整数、リスト
	* @return
	*/
	private static void inputValue(Long num,List<Long> list){
		if(num >= 1 && num <= 10000000000L){
			list.add(num);
		}
	}
	/**
	* 結果表示
	* @param 真偽値、リスト
	* @return
	*/
	private static void result(boolean processDecision,List<Long> list){
		if(processDecision){
			List<Long> resultList = new ArrayList<Long>();
			for(int i = 0 ; i < list.size() ; i++){
				for(int j = i+1 ; j < list.size() ; j++){
					if( !(resultList.contains(list.get(i) + list.get(j))) ){
						resultList.add(list.get(i) + list.get(j));
					}
				}
			}
			Collections.sort(resultList,Collections.reverseOrder());
			System.out.println(resultList.get(1));
		}else{
			System.out.println("\"assert\"");
		}
	}
}
