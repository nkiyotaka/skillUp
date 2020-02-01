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
			int lodgmentFee = obj.fee(scan,true);
			int replacementFee = obj.fee(scan,true);
			int reservationCount = obj.reservationCount(scan,true);
			obj.listAllocation(scan,reservationCount,true);
			obj.lossDecision(lodgmentFee,replacementFee);
		}catch(Exception e){
			;
		}finally{
			scan.close();
		}
	}
	private int fee(Scanner scan,boolean flag){
		int fee = 0;
		while(flag){
			fee = scan.nextInt();
			flag = fee >= 1 && fee <= 100000 ?false:true;
		}
		return fee;
	}
	private int reservationCount(Scanner scan,boolean flag){
		boolean result = true;
		int reservationCount = 0;
		while(flag){
			reservationCount = scan.nextInt();scan.nextLine();
			flag = reservationCount >= 1 && reservationCount <= 100 ?false:true;
		}
		return reservationCount;
	}
	private void listAllocation(Scanner scan ,int reservationCount,boolean flag){
		List<String> duplicateList = new ArrayList<String>();
		List<String> roomList = new ArrayList<String>();
		String roomNo = null;
		for(int i = 0 ; i < reservationCount ; i++){
			while(flag){
				roomNo = scan.nextLine();
				flag = Integer.valueOf(roomNo) >= 1 && Integer.valueOf(roomNo) <= 999 ? false:true;
			}
			if(roomList.contains(roomNo)){
				duplicateList.add(roomNo);
			}else{
				roomList.add(roomNo);
			}
			flag = true;
		}
		this.duplicateList = duplicateList;
		this.roomList = roomList;
	}
	private void lossDecision(int lodgmentFee,int replacementFee){
		if(duplicateList.size() > 0){
			int lossPrice = lodgmentFee + replacementFee;
			System.out.println(duplicateList.size() * lossPrice);
		}else{
			System.out.println(0);
		}
	}
}