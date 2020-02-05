/*
javac -encoding UTF-8 YCNo586.java
java YCNo586
*/
import java.util.*;
public class YCNo586{
	private List<String> duplicateList = new ArrayList<String>();
	private List<String> roomList = new ArrayList<String>();
	
	public static void main(String[] args)throws Exception{
		YCNo586 obj = new YCNo586();
		Scanner scan = new Scanner(System.in);
		try{	
			int lodgmentFee = obj.fee(scan);
			int replacementFee = obj.fee(scan);
			int reservationCount = obj.reservationCount(scan);
			obj.listAllocation(scan,reservationCount);
			obj.lossDecision(lodgmentFee,replacementFee);
		}catch(Exception e){
			;
		}finally{
			scan.close();
		}
	}
	/**
	 * 金額範囲指定
	 * @param スキャナー変数
	 * @return fee
	 */
	private int fee(Scanner scan){
		boolean flag = false;
		int fee = 0;
		while( !flag ){
			fee = scan.nextInt();
			flag = fee >= 1 && fee <= 100000 ?true:false;
		}
		return fee;
	}
	/**
	 * 予約数指定
	 * @param スキャナー変数
	 * @return reservationCount
	 */
	private int reservationCount(Scanner scan){
		boolean flag = false;
		int reservationCount = 0;
		while( !flag ){
			reservationCount = scan.nextInt();scan.nextLine();
			flag = reservationCount >= 1 && reservationCount <= 100 ?true:false;
		}
		return reservationCount;
	}
	/**
	 * 重複振り分け
	 * @param スキャナー変数、予約数
	 */
	private void listAllocation(Scanner scan ,int reservationCount){
		boolean flag = false;
		String roomNo = null;
		for(int i = 0 ; i < reservationCount ; i++){
			while( !flag ){
				roomNo = scan.nextLine();
				flag = Integer.valueOf(roomNo) >= 1 && Integer.valueOf(roomNo) <= 999 ? true:false;
			}
			if(roomList.contains(roomNo)){
				this.duplicateList.add(roomNo);
			}else{
				this.roomList.add(roomNo);
			}
			flag = false;
		}
	}
	/**
	 * 判定
	 * @param ホテル代、ホテル差し替え代
	 */
	private void lossDecision(int lodgmentFee,int replacementFee){
		if(duplicateList.size() > 0){
			int lossPrice = lodgmentFee + replacementFee;
			System.out.println(duplicateList.size() * lossPrice);
		}else{
			System.out.println(0);
		}
	}
}