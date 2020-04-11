/*
javac -encoding UTF-8 YCNo116.java
java YCNo116
*/
import java.util.*;

public class YCNo116{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int num = 0;
			do{
				num = Integer.parseInt(sc.nextLine());
			}while(numberCheck(num));
			String[] kadomatsu = new String[num];
			do{
				kadomatsu = sc.nextLine().split(" ");
			}while(kadomatuCheck(kadomatsu));
			List<String> list = null;
			int result = 0;
			for(int i = 0 ; i < kadomatsu.length - 2 ; i++){
				list = Arrays.asList(kadomatsu[i],kadomatsu[i+1],kadomatsu[i+2]);
				result += kadomatsuColumn(new ArrayList<String>(new LinkedHashSet<>(list)));
			}
			System.out.println(result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	*門松の本数が指定範囲内かのチェック
	* @param 数字
	* @return
	*/
	private static boolean numberCheck(int num){
		if(num >= 3 && num <= 100){
			return false;
		}
		return true;
	}
	/**
	*門松の長さが指定範囲内かのチェック
	* @param 門松
	* @return
	*/
	private static boolean kadomatuCheck(String[] kadomatsu){
		for(String a : kadomatsu){
			if( !(Integer.parseInt(a) >= 1 && Integer.parseInt(a) <= 100) ){
				return true;
			}
		}
		return false;
	}
	/**
	*門松列があるかを判定
	* @param リスト
	* @return
	*/
	private static int kadomatsuColumn(List<String> list){
		int counter = 0;
		if(list.size() == 3){
			String max = list.stream().max((a1, a2) -> a1.compareTo(a2)).get();
			String min = list.stream().min((a1, a2) -> a1.compareTo(a2)).get();
			if(list.get(1).equals(max) || list.get(1).equals(min)){
				counter++;
			}
		}
		return counter;
	}
}