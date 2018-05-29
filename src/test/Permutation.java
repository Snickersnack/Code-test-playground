package test;

public class Permutation {

	public static void main(String[] args){
		permute("abc", "");
	}
	
	public static void permute(String str, String n){
		
		if(str.isEmpty()){
			System.out.println(n);
		}
		for(int i =0; i<str.length(); i++){
			permute(str.substring(0,i) + str.substring(i+1, str.length()), n+str.charAt(i));
		}
	}
	
}
