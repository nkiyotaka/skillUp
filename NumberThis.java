/*
javac -encoding UTF-8 YCNo24.java
java YCNo24
*/
import java.util.*;
public class YCNo24{
	public static void main(String[] args) throws Exception{
		
		Scanner scan = new Scanner(System.in);
		String loop = null;
		
		Boolean result = true;
		while(result){
			loop = scan.nextLine();
			result = (Integer.valueOf(loop) > 1 && Integer.valueOf(loop) < 10)? false : true;
		}
		
		String[] input = null;
		List<String> list = new ArrayList<String>(Arrays.asList("0","1","2","3","4","5","6","7","8","9"));
		List<String> resultList = new ArrayList<String> ();
		
		for(int i = 0 ; i < Integer.valueOf(loop) ; i++){
			input = scan.nextLine().split(" ");
			
			if(input[input.length-1].equals("YES")){
				for(String str : input){
					if(list.contains(str)){
						resultList.add(str);
					}
				}
				list.clear();
				for(String str : resultList){
					list.add(str);
				}
				resultList.clear();
			}else{
				for(String str : input){
					if(list.contains(str)){
						list.remove(list.indexOf(str));
					}
				}
			}
		}
		list.forEach(thisNumber -> System.out.println(thisNumber));
	}
}
