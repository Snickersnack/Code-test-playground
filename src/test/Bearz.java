package test;

import java.util.Arrays;

public class Bearz {
	
	static boolean[][] can = new boolean[1505][1505];
	 
	 void rec(int t[]) {
	    if(can[t[0]][t[1]]) return; // we processed this state before
	    can[t[0]][t[1]] = true;
	    for(int i = 0; i < 3; ++i)
	        for(int j = 0; j < 3; ++j)
	            if(t[i] < t[j]) {
	                // we move stones from j to i
	                // third pile has index 0+1+2-i-j
	                int[] t2 = {t[i]*2, t[j]-t[i], t[0+1+2-i-j]};
	                rec(t2);
	            }
	}
	 
	public String equalPiles(int a, int b, int c) {
	    int[] t = {a,b,c};
	    int s = a + b + c;
	    if(s % 3 == 0) {
	        rec(t);
	        if(can[s/3][s/3]) return "possible";
	    }
	    return "impossible";
	}
}
