package test;

import java.util.ArrayList;
import java.util.List;


public class Arrfix1 {
	public int mindiff(int[] A, int[] B, int[] F){
		int difference = 0;
		int replacement = 0;
		List<Integer> check = new ArrayList<Integer>();
		if(F.length == 0){
			for (int i = 0; i< A.length; i++){
				if(A[i] != B[i]){
					difference++;
				}
			}
			return difference;
		}
		else{
			for(int k = 0; k<F.length; k++){
				check.add(F[k]);
			}
				for(int j = 0; j<A.length; j++){
					if(A[j] != B[j]){
						difference++;
						for(int i = 0; i<check.size(); i++){
							if(check.get(j) == B[j]){
								A[j] = check.get(j);
								check.remove(j);
								difference--;
								replacement++;
								
							}
						}

						
					}

				}
			
		}
		System.out.println(difference + " " +  replacement);
		if(F.length - replacement>0){
			return replacement;
		}
		else{
			return difference;
		}
	}
}
