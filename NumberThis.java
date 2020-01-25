/*
javac -encoding UTF-8 NumberThis.java
java NumberThis
*/
import java.util.*;
public class NumberThis{
	public static void main(String[] args) throws Exception{
		
		Scanner scan = new Scanner(System.in);
		String loop = scan.nextLine();
		
		String line = null;
		String[] input = null;
		List<String> list = new ArrayList<String>(Arrays.asList("0","1","2","3","4","5","6","7","8","9"));
		List<String> resultList = new ArrayList<String> ();
		
		for(int i = 0 ; i < Integer.valueOf(loop) ; i++){
			line = scan.nextLine();
			input = line.split(" ");
			
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
		list.forEach(result -> System.out.println(result));
	}
}
