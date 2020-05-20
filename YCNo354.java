/*
javac -encoding UTF-8 YCNo354.java
java YCNo354
*/
import java.util.*;

public class YCNo354{
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			long index = sc.nextInt();
			long num = (long)Math.pow(2,index);
			long result = 0;
			
			long work = 1;
			while(work != num){
				work *= 2;
				result++;
			}
			
			System.out.println(result);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}