/*
javac -encoding UTF-8 YCNo410.java
java YCNo410
*/
import java.util.*;

public class YCNo410{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int[] A = coordinatePoint(sc);
			int[] B = coordinatePoint(sc);
			int Ax_By = calculation(A[0],B[0]);
			int Ay_Bx = calculation(A[1],B[1]);
			result(Ax_By+Ay_Bx);
		}catch(Exception e){
			;
		}
	}
	/**
	* 整数座標点取得
	* @param スキャナー変数
	* @return
	*/
	private static int[] coordinatePoint(Scanner sc){
		String[] num = null;
		boolean flag = true;
		while(flag){
			num = sc.nextLine().split(" ");
			flag = decisionInRange(num);
		}
		int[] xy = {Integer.valueOf(num[0]),Integer.valueOf(num[1])};
		return xy;
	}
	/**
	* 整数座標点範囲判定
	* @param 整数座標点
	* @return
	*/
	private static boolean decisionInRange(String[] num){
		for(String str : num){
			if( !(Integer.valueOf(str) >= -100000 && Integer.valueOf(str) <= 100000) ){
				return true;
			}
		}
		return false;
	}
	/**
	* 計算判定
	* @param x軸、y軸
	* @return
	*/
	private static int calculation(int Ax,int By){
		int answer = Ax - By;
		if(answer < 0){return -answer;}
		else{return answer;}
	}
	/**
	* 結果表示
	* @param xy軸
	* @return
	*/
	private static void result(int xy){
		if(xy % 2 == 0){System.out.println(xy / 2);}
		else{System.out.println((double)xy / 2);}
	}
}