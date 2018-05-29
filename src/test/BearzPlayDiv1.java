package test;

public class BearzPlayDiv1 {
	
	public int pileSize(int A, int B, int K){
		int answer = 0;

		for(int i = 0; i<K; i++){
			if(A<= B){
				B-=A;
				A *= 2;
			}
			else{
				A-=B;
				B*=2;
			}
			  
		}
		answer = Math.min(A,B);
		return answer;
	}

	
}
