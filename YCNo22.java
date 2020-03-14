/*
javac -encoding UTF-8 YCNo22.java
java YCNo22
*/
import java.util.*;

public class YCNo22{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			String[] inputValue;
			do{
				inputValue = sc.nextLine().split(" ");
			}while(inputData(Integer.parseInt(inputValue[0]),Integer.parseInt(inputValue[1])));
			String[] line;
			do{
				line = sc.nextLine().split("");
			}while(characterPattern(line));
			System.out.println(result(Integer.parseInt(inputValue[1]),new ArrayList<String>(Arrays.asList(line))));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	*文字数、指定文字のチェック
	* @param 文字数、文字指定値
	* @return 真偽値
	*/
	private static boolean inputData(int length,int characterNumber){
		if( !(length >= 1 && length <= 10000) ){
			return true;
		}
		if( !(characterNumber >= 1 && characterNumber <= length) ){
			return true;
		}
		return false;
	}
	/**
	*文字列が括弧かのチェック
	* @param 文字列
	* @return 真偽値
	*/
	private static boolean characterPattern(String[] line){
		for(String s : line){
			if( !(s.matches("[()]+")) ){
				return true;
			}
		}
		return false;
	}
	/**
	*括弧の位置により処理を分岐し結果出力
	* @param 文字指定値、リスト
	* @return 指定文字に対応する位置
	*/
	private static int result(int index,List<String> list){
		int result = 0;
		int cnt = 1;
		if(list.get(index-1).equals("(") && list.size() > 1){
			result = index + 1;
			list.subList(0,index).clear();
			for(String str : list){
				if(str.equals(")")){cnt--;}
				if(str.equals("(")){cnt++;}
				if(cnt == 0){break;}
				result++;
			}
		}else if(list.get(index-1).equals(")") && list.size() > 1){
			result = index-1;
			list.subList(index-1,list.size()).clear();
			Collections.reverse(list);
			for(String str : list){
				if(str.equals(")")){cnt++;}
				if(str.equals("(")){cnt--;}
				if(cnt == 0){break;}
				result--;
			}
		}
		return result;
	}
}