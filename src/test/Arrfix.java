package test;

import java.util.ArrayList;
import java.util.List;

public class Arrfix {

	public int mindiff(int[] A, int[] B, int[] F){
		int difference = 0;
		boolean loopCompleted = false;
		int pointerF = 0;
		boolean[] check = new boolean[A.length];
		List<Integer> fList = new ArrayList<Integer>();
		
		if(F.length == 0){
			for (int i = 0; i< A.length; i++){
				if(A[i] != B[i]){
					difference++;
				}
			}
			return difference;
		}
		while(F.length>0){
			if(!loopCompleted){
				for (int i = 0; i<A.length; i++){
					if(A[i] != B[i]){
						difference++;
						check[i] = false;
						for(int j = 0; j < F.length; j++){
							if(F[j] == B[i]){
								if(F.length == 1){
									break;
								}else{
									int[] temp = new int[F.length-1];
									for(int m = 0; m<F.length; m++){
										int minus = 0;
										if(m == j){
											minus++;
											continue;
										}
										else{
											temp[m - minus] = F[m];
										}
									}
									F = temp;
									difference--;
									check[i] = true;
									break;
								}

							}
						}
					}

				}
				loopCompleted = true;
				for(int k = pointerF; k<F.length; k++){
					if(check[k]){
						
					}
				}
			}

		}


		return difference;
		
	}
}
