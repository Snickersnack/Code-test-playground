package test;

import java.util.Arrays;

public class RopeString {

	String makerope(String s){
		int ropeCount = 0;
		int dotCount = 0;
		boolean ropeConstruction = true;
		int[] ropes = new int[s.length()];
		for(int i = 0; i<s.length(); i++){
			char c = s.charAt(i);
			if(c == '-'){
				ropeCount++;
				if(i == s.length() -1){
					ropes[i] = ropeCount;
				}
			}
			
			else{
				ropes[i] = ropeCount;
				ropeCount = 0;
				dotCount++;
				System.out.println(dotCount);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<ropes.length; i++){
			if(ropes[i] % 2 == 0 && ropes[i] != 0){
				for(int j = 0; j<ropes[i]; j++){
					sb.append("-");
				}
				if(dotCount>0){
					sb.append(".");
					dotCount--;	
				}
			}else if (ropes[i] % 2 != 0 && ropes[i] != 0){
				for(int j = 0; j<ropes[i]; j++){
					sb.append("-");
					
				}
				if(dotCount>0){
					sb.append(".");
					dotCount--;	
				}

		
			}
			else{
				continue;
			}
		}
		while(dotCount>0){
			sb.append(".");
			dotCount--;
		}
		
		return sb.toString();
	}
}
