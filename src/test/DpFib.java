package test;

public class DpFib {
	public static void main(String[] args) throws Exception {
		int n = 10;
		int[] array = new int[n];
		System.out.println(fib(n, array));
		
	}
	public static int fib(int n, int[] array){
		if(n == 0){
			return 0;
		}
		if(n<2){
			return 1;
		}
		if(array[n-1] != 0){
			return array[n-1];
		}
		array[n-1] = fib(n-1, array) + fib(n-2, array);
		return array[n-1];
	}
}
