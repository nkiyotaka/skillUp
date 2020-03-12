/*
javac -encoding UTF-8 YCNo5.java
java YCNo5
*/
import java.util.*;
import java.util.stream.Stream;

public class YCNo5{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int blockBox;
			do{
				blockBox = sc.nextInt();
			}while(boxWidthOrLoopCheck(blockBox));
			int loop;
			do{
				loop = sc.nextInt();
			}while(boxWidthOrLoopCheck(loop));
			sc.nextLine();
			int[] blockArray;
			int result = 0;
			do{
				String array = sc.nextLine();
				blockArray = Arrays.stream(array.split(" ")).mapToInt(a -> Integer.parseInt(a)).toArray();
				Arrays.sort(blockArray);
				result = blockWidthCheck(blockArray,blockBox);
			}while(result < 0 ?true:false);
			System.out.println(result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	*ブロックを入れる箱幅／ブロックを求める数チェック
	* @param 箱のサイズ／ループ回数
	* @return 真偽値
	*/
	private static boolean boxWidthOrLoopCheck(int testTarget){
		if( !(1 <= testTarget && testTarget <= 10000) ){
			return true;
		}
		return false;
	}
	/**
	*ブロックを入れる箱幅／ブロックを求める数チェック
	* @param 箱のサイズ／ループ回数
	* @return 真偽値
	*/
	private static int blockWidthCheck(int[] testTarget,int blockBox){
		int sum = 0,cnt = 0;
		for(int i : testTarget){
			if( !(1 <= i && i <= blockBox) ){
				return -1;
			}
			sum += i;
			if(sum <= blockBox){
				cnt++;
			}
		}
		return cnt;
	}
}