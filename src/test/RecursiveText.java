package test;
public class RecursiveText {

	int stringIndex = 0;
	
	public String solve(String text, int chunk) {
//		StringBuilder sb = new StringBuilder();
//		if(text.length()<= chunk){
//			return text + "\n";
//		}
//		
//		int index = text.length()-1;
//		int difference = 0;
//		while(text.charAt(index) != ' ' || difference<chunk ){
//			index--;	
//			difference+= 1;
//			System.out.println(difference + " : " + text.substring(index+1,text.length()));
//			
//		}
//		String answer = solve(text.substring(0,index), chunk);
//		sb.append(answer + text.substring(index+1,text.length()) + "\n");
//		return sb.toString();
		
		
	StringBuilder sb = new StringBuilder();
	int index = 0;
	if((text.length() - index) <= chunk){
		return text;
	}
	while(text.charAt(index) != ' ' || index +1 < chunk){
		index++;
		System.out.println(index + " : " + text.substring(0, index));
	}
	
	String answer = solve(text.substring(index+1, text.length()), chunk);
	sb.append(text.substring(0, index) + "\n" + answer  );
	return sb.toString();
	}
}
