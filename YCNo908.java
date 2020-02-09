/*
javac -encoding UTF-8 YCNo908.java
java YCNo908
*/
import java.util.*;
import java.util.regex.Pattern;
public class YCNo908{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        try{
        	String line = sc.nextLine();
        	int loop = line.length();
        	char work;
        	for(int i = 0 ; i < loop ; i++){
        		work = line.charAt(i);
        		if(i % 2 == 0 && !Pattern.matches("^[a-z]+$", Character.toString(work))){
        			flag = false;
        		}
        		if(i % 2 == 1 && !(work == ' ')){
        			flag = false;
        		}
        	}
        	System.out.println(flag ? "YES" : "NO");
        }catch(Exception e){
        	;
        }finally{
        	sc.close();
        }
    }
}