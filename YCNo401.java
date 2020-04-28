/*
javac -encoding UTF-8 YCNo401.java
java YCNo401
*/
import java.util.*;

public class YCNo401{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int num;
			do{
				num = sc.nextInt();
			}while( !isNum(num) );
			
			//数字の渦配列取得
			String[][] numArray = getNumArray(num);
			
			//結果出力
			result(numArray);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* 入力数字が有効な範囲か判定
	* @param 入力数字
	* @return 真偽値
	*/
	private static boolean isNum(int target){
		if(1 <= target && target <= 30){
			return true;
		}
		return false;
	}
	/**
	* 数字の渦配列取得
	* @param 入力数字
	* @return 数字配列
	*/
	private static String[][] getNumArray(int num){
		
		//判定用フラグ
		boolean turnRight = true,turnLeft = false;
		boolean up = false,down = false;
		
		//初期値設定
		int counter = 1;
		int end = num * num;
		
		int right = num-1,left = 0;
		int over = 1,under = num-1;
		
		//配列のインデックス値
		int indexH = 0,indexW = 0;
		
		String work;
		String[][] numArray = new String[num][num];
		
		while(counter <= end){
			
			if(String.valueOf(counter).length() == 1){
				work = "00"+String.valueOf(counter);
			}else if(String.valueOf(counter).length() == 2){
				work = "0"+String.valueOf(counter);
			}else{
				work = work = String.valueOf(counter);
			}
			//右に進む
			if(turnRight){
				numArray[indexH][indexW] = work;
				indexW++;
				
				//行き止まりになったら下に進むフラグ立てる
				if(indexW-1 == right){
					turnRight = false;
					down = true;
					
					//右の壁を1狭める
					right--;
					
					//次のインデックス値の準備
					indexH++;
					indexW--;
				}
			//下に進む
			}else if(down){
				numArray[indexH][indexW] = work;
				indexH++;
				
				//行き止まりになったら左に進むフラグ立てる
				if(indexH-1 == under){
					down = false;
					turnLeft = true;
					
					//下の壁1狭める
					under--;
					
					//次のインデックス値準備
					indexH--;
					indexW--;
				}
			//左に進む
			}else if(turnLeft){
				numArray[indexH][indexW] = work;
				indexW--;
				
				//行き止まりになったら上に進むフラグ立てる
				if(indexW+1 == left){
					turnLeft = false;
					up = true;
					
					//左の壁1狭める
					left++;
					
					//次のインデックス値準備
					indexH--;
					indexW++;
				}
			//上に進む
			}else if(up){
				numArray[indexH][indexW] = work;
				indexH--;
				
				//行き止まりになったら右に進むフラグ立てる
				if(indexH+1 == over){
					up = false;
					turnRight = true;
					
					//上の壁1狭める
					over++;
					
					//次のインデックス値準備
					indexH++;
					indexW++;
				}
			}
			counter++;
		}
		return numArray;
	}
	/**
	* 数字の渦出力
	* @param 数字の配列
	*/
	private static void result(String[][] array){
		for(int i = 0 ; i < array.length ; i ++){
			for(int j = 0 ; j < array.length ; j++){
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
}