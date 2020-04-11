/*
javac -encoding UTF-8 YCNo104.java
java YCNo104
*/
import java.util.*;

public class YCNo104{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			String[] array = null;
			do{
				String branch = sc.nextLine();
				if(branch.equals("")){
					System.out.println(1);
					return;
				}else{
					array = branch.split("");
				}
			}while(isEnabled(array));
			int result = 1;
			for(int i =  0; i < array.length ; i++){
				result = array[i].equals("L")? result * 2 : result * 2 + 1;
			}
			System.out.println(result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	*文字が有効か判定
	* @param 文字列
	* @return 真偽値
	*/
	private static boolean isEnabled(String[] line){
		if(line.length < 1 && line.length > 30){
			return true;
		}
		for(String s : line){
			if( !(s.matches("[LR]")) ){
				return true;
			}
		}
		return false;
	}
}