/*
javac -encoding UTF-8 YCNo296.java
java YCNo296
*/
import java.util.*;
import java.time.LocalTime;

public class YCNo296{
	private static final int MAX_SLEEPTIMES = 1000000;
	private static final int MAX_HOUR = 23;
	private static final int MAX_MINUTES = 59;
	private static final int MAX_ALARM = 1440;
	private static final int MIN_TIME = 0,MIN_SLEEPTIMES_OR_ALARM = 1;
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			int sleepTimes;
			do{
				sleepTimes = sc.nextInt();
			}while( !isSleepTimes(sleepTimes) );
			
			int hour;
			do{
				hour = sc.nextInt();
			}while( !isHour(hour) );
			
			int minutes;
			do{
				minutes = sc.nextInt();
			}while( !isMinutes(minutes) );
			
			int alarm;
			do{
				alarm = sc.nextInt();
			}while( !isAlarm(alarm) );
			
			result(sleepTimes,hour,minutes,alarm);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	* n度寝の回数が有効な範囲か判定
	* @param 寝る回数
	* @return 真偽値
	*/
	private static boolean isSleepTimes(int target){
		if(MIN_SLEEPTIMES_OR_ALARM <= target && target <= MAX_SLEEPTIMES){
			return true;
		}
		return false;
	}
	/**
	* 時が有効な範囲か判定
	* @param 時
	* @return 真偽値
	*/
	private static boolean isHour(int target){
		if(MIN_TIME <= target && target <= MAX_HOUR){
			return true;
		}
		return false;
	}
	/**
	* 分の値が有効な範囲か判定
	* @param 分
	* @return 真偽値
	*/
	private static boolean isMinutes(int target){
		if(MIN_TIME <= target && target <= MAX_MINUTES){
			return true;
		}
		return false;
	}
	/**
	* アラームが繰り返される間隔の分単位が有効な範囲か判定
	* @param アラームが繰り返される間隔分
	* @return 真偽値
	*/
	private static boolean isAlarm(int target){
		if(MIN_SLEEPTIMES_OR_ALARM <= target && target <= MAX_ALARM){
			return true;
		}
		return false;
	}
	/**
	* n度寝の回数に応じた起床時間の結果出力
	* @param n度寝回数、時、分、アラーム分単位
	*/
	private static void result(int sleepTimes,int hour,int minutes,int alarm){
		if(sleepTimes != 1){
			LocalTime localTime = LocalTime.of(hour,minutes);
			LocalTime resultTime = localTime.plusMinutes( (sleepTimes-1) * alarm);
			System.out.println(resultTime.getHour());
			System.out.println(resultTime.getMinute());
		}else{
			System.out.println(hour);
			System.out.println(minutes);
		}
	}
}