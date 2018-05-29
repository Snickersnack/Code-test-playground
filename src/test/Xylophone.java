package test;

import java.util.HashSet;
import java.util.Set;

public class Xylophone {
	int countKeys(int[] keys){
		int answer = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i =0; i<keys.length; i++){
			Integer in = new Integer(keys[i]);
			in = in % 7;
			if(set.add(in)){
				answer++;
			}
		}
		return answer;
	}
}
