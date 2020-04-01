/*
javac -encoding UTF-8 YCNo299.java
java YCNo299
*/
import java.util.*;

public class YCNo299{
	private static final long MIN_VERSIONNUMBER = 1,MAX_VERSIONNUMBER = 10000000000L;
	private static final long versionOne = 316;
	private static final long versionTwo = 368;
	private static final long versionUpPageNumber = versionTwo - versionOne;
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			long versionNumber;
			do{
				versionNumber = sc.nextLong();
			}while( !isVersionNumber(versionNumber) );
			
			result(versionNumber);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* 第N版の範囲が有効か判定
	* @param N版
	* @return 真偽値
	*/
	private static boolean isVersionNumber(long target){
		if(MIN_VERSIONNUMBER <= target && target <=MAX_VERSIONNUMBER){
			return true;
		}
		return false;
	}
	/**
	* 第N版のページ数の結果出力
	* @param N版
	*/
	private static void result(long versionNumber){
		if(versionNumber == 1){
			System.out.println(versionOne);
		}else if(versionNumber == 2){
			System.out.println(versionTwo);
		}else{
			long result = 0;
			for(long i = 1 ; i < versionNumber ; i++){
				result = i * versionUpPageNumber;
			}
			System.out.println(result += versionOne);
		}
	}
}