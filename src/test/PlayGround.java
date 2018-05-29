package test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;

public class PlayGround {

	HashMap<Integer, HashSet<Integer>> map;

	static void swap(Integer arg1, Integer arg2) {
		Integer temp = arg1;
		System.out.println("here is temP: " + temp);
		arg1 = arg2;
		System.out.println("here is arg1: " + arg1);
		arg2 = temp;
		System.out.println("here is arg2: " + arg2);
	}

	static void properSwap(Integer arg1, Integer arg2) {
		Integer temp = arg1;
		Integer temp2 = arg2;
		System.out.println("here is temP: " + temp);
		arg1 = temp2;
		System.out.println("here is arg1: " + arg1);
		arg2 = temp;
		System.out.println("here is arg2: " + arg2);
	}

	static void swapDog(Dog dog1, Dog dog2) {
		Dog temp = new Dog("test");
		dog1 = dog2;
		dog2 = temp;
		System.out.println(dog1.getName() + " " + dog2.getName());
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		String[] serverIds = {"a", "b", "c"};
		String prefix = "";
		for (String serverId : serverIds) {
		  sb.append(prefix);
		  prefix = ",";
		  sb.append(serverId);
		}
		System.out.println(sb.toString());
		
		
		PlayGround play = new PlayGround();
		Sieve sieve = play.new Sieve();
		sieve.solve(1, 100);
		

	}

	public class Sieve {

		public void solve(long first, long last) {
			int answer = 0;
			BigInteger test = new BigInteger("123");
			test.isProbablePrime(10);
			// initially assume all integers are prime
			
			int row = (int) Math.ceil(Math.sqrt(last+1));
			int column = row;
			boolean[][] isPrime = new boolean[row+1][column+1];
			for (int i = 2; i <= last; i++) {
				int r = i/row;
				int c = i%row;
				isPrime[r][c] = true;
			}

			// mark non-primes <= n using Sieve of Eratosthenes
			for (int factor = 2; factor * factor <= last; factor++) {

				// if factor is prime, then mark multiples of factor as nonprime
				// suffices to consider mutiples factor, factor+1, ..., n/factor
				int r = factor/row;
				int c = factor%row;
				if (isPrime[r][c]) {
					for (int j = factor; factor * j <= last; j++) {
						int ro = (factor * j)/row;
						int co = (factor*j)%row;
						isPrime[ro][co] = false;
					}
				}
			}
			
			
			for(long i = first; i<last; i++){
				int r = (int)i/row;
				int c = (int)i%row;
				if(isPrime[r][c]){
					boolean flag = true;
					long number = i;
					while(number>0){
						long digit = number%10;
						int d = (int)digit;
						if(!isPrime[d/10][d%10]){
							flag = false;
							break;
						}
						number/=10;
					}
					if(flag){
						answer++;
					}
				}
			}
			// count primes
			System.out.println(answer);
		}
	}
}
