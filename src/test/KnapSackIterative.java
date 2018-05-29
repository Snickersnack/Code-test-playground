package test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class KnapSackIterative {

	int[][] knapsack;
	int n;
	int items;
	int[] value;
	int[] weight;
	
	public void solve() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("/Users/wilsontan/Downloads/knapsack2.txt"));
		
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		items = Integer.parseInt(input[1]);
		value = new int[items];
		weight = new int[items];
		String next = "";
		int valueIndex = 0;
		int weightIndex = 0;
		
		
		while(( next = br.readLine()) != null ){
			String[] breaker = next.split(" ");
			
			value[valueIndex] = Integer.parseInt(breaker[0]);
			weight[weightIndex] = Integer.parseInt(breaker[1]);
			valueIndex++;
			weightIndex++;
		}
		knapsack = new int[3][n+1];
		int itemIndex = 1;
		//initialize array with all -1s (is this even necessary?)
		for(int i = 0; i<3; i++){
			for(int j = 0; j<n; j++){
				knapsack[i][j] = -1;
			}
		}
		//fill out zeros for first column
		for(int i = 0; i<n; i++){
			knapsack[0][i] =0;
		}
		//fill out next columns
			for(int i = 1; i<n; i++){
				for(int j =0; j<items; j++){
					if(weight[j]<=n){
						if(j % 2 == 0){
							knapsack[1][n] = Math.max(knapsack[0][n], knapsack[0][n-weight[j]] + value[j]);
							knapsack[0][n] = knapsack[1][n];
						}
						else{
							knapsack[2][n] = Math.max(knapsack[0][n], knapsack[0][n-weight[j]] + value[j]);
							knapsack[0][n] = knapsack[2][n];
						}
					}
					else{
						if(j % 2 == 0){
							knapsack[1][n] = knapsack[0][n];

						}
						else{
							knapsack[2][n] = knapsack[0][n];
						}
						
					}
					//copy to first column
				}
			}
		
		

		//increment index so we know which items we are on
		//replace previous column with new column
		System.out.println(knapsack[2][n]);
		System.out.println(knapsack[1][n]);

		
	}

}
