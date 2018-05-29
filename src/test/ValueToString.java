package test;

import java.util.ArrayDeque;
import java.util.Deque;


public class ValueToString {
	public static void main(String[] args){
		int value = 111111111;
		String answer = solve(value);
		System.out.println(answer);
		
	}
	
	public static String solve(int value){
		String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		String[] teens = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		String [] hundreds = {"hundred"};
		String[] thousands = {"thousand"};
		String[] million = {"million"};
		String[] billion = {"billion"};
		int vH = 0;
		int pH = 0;
		int previous = -1;
		Deque<String> stringStack = new ArrayDeque<String>();
		while(value>0){
			int place = value%10;
			value/=10;
			

			if(vH % 3 ==0){
				if(pH == 1 ){
					stringStack.push(thousands[0]);
				}
				else if(pH == 2){
					stringStack.push(million[0]);
				}
				else if(pH == 3){
					stringStack.push(billion[0]);
				}
				stringStack.push(ones[place]);
				pH++;
			}
			else if(vH % 3 ==1){
				if(place == 1){
					stringStack.pop();
					stringStack.push(teens[previous]);
				}else{
					stringStack.push(tens[place]);
				}
			}			
			else if(vH % 3 ==2){
				stringStack.push(hundreds[0]);
				stringStack.push(ones[place]);				
			}					
			vH++;
			previous = place;
		}
		StringBuilder answer = new StringBuilder();
		for(int i = stringStack.size()-1; i>=0; i--){
			String temp = stringStack.pop();
			if(temp != ""){
				answer.append(temp);
				answer.append(" ");
			}
		}
		return answer.toString();
	}

}
