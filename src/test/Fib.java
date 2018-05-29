package test;

public class Fib {
	
	int[] memo;
	int count = 0;
	public Fib(int n){
		this.memo = new int[n];
		
	}
	public int calc(int n){
		int f = 0;
		if(memo[n-1] != 0){
			System.out.println("memoized call");
			return memo[n-1];
		}
		if(n <= 2){
			return 1;
		}
		else{
			f = calc(n-1) + calc(n-2);
			
			System.out.println("called " + ++count + " times");
		}
		memo[n-1]=f;
		return f;

	}
}
