package test;

public class RepeatStringEasy 
{ 

  private char[] first, second; 
  private int dp[][]; 

  public int maximalLength(String s) 
  { 
    int max = 0; 
    for (int secondStart = 1; secondStart <= s.length() - 1; secondStart++) 
    { 
      first = s.substring(0, secondStart).toCharArray(); 
      second = s.substring(secondStart).toCharArray(); 
      max = Math.max(max, maxCommon()); 
       
    } 
    return max*2; 
  } 


  private int maxCommon() 
  { 
	System.out.println("first length: " + first.length + "second length: " + second.length);
    dp = new int[first.length][second.length]; 
    for (int i = 0; i < first.length; i++) 
      for (int j = 0; j < second.length; j++) 
        dp[i][j] = -1; 
    return f(0, 0); 
  } 

  private int f(int a, int b) 
  { 
    // base case 
    if (a >= first.length || b >= second.length) 
      return 0; 
    if (dp[a][b] != -1) 
      return dp[a][b]; 

     
    int max = 0; 
    if (first[a] == second[b])  
      max = f(a+1, b+1) + 1; 
    else 
      max = Math.max(f(a, b+1), f(a+1,b)); 
    return dp[a][b] = max; 
  } 

}