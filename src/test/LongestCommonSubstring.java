package test;

public class LongestCommonSubstring {

	
	public static void main(String[] args){
		System.out.println(lcs("daily", "damn"));
//		solve("daily", "damn");
	}
	
	public static void solve(String a, String b){
		a = a.toLowerCase();
		b = b.toLowerCase();
		int aL = a.length();
		int bL = b.length();
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();
		int max = 0;
		int[][] matrix = new int[aL+1][bL+1];
		for(int i =1; i<=aL; i++){
			for(int j = 1; j<=bL; j++){
				if(aArr[i-1] == bArr[j-1]){
					matrix[i][j] = matrix[i-1][j-1]+1;
					if(matrix[i][j] > max){
						max = matrix[i][j];
					}
				}
			}
		}
		
		String print = "";
	    for(int i = 0; i<=aL; i++){
	    	for(int j = 0; j<=bL; j++){
	    		print += matrix[i][j] + " ";
	    	}
	    	System.out.println(print);
	    	System.out.println();
	    	print = "";
	    	
	    }
	    
		System.out.println(max);
		
	}
	
	public static int lcs(String a, String b){
		int m = a.length();
		int n = b.length();
	 
		int max = 0;
	 
		int[][] dp = new int[m][n];
	 
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(a.charAt(i) == b.charAt(j)){
					if(i==0 || j==0){
						dp[i][j]=1;
						System.out.println(1);
					}else{
						dp[i][j] = dp[i-1][j-1]+1;
					}
	 
					if(max < dp[i][j])
						max = dp[i][j];
				}
	 
			}
		}
		String print = "";
	    for(int i = 0; i<m; i++){
	    	for(int j = 0; j<n; j++){
	    		print += dp[i][j] + " ";
	    	}
	    	System.out.println(print);
	    	System.out.println();
	    	print = "";
	    	
	    }
		return max;
	}
}
