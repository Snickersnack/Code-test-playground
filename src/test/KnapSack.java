package test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class KnapSack {

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
		knapsack = new int[n+1][items+1];
		for(int i =1; i<=n; i++){
			for (int j=1; j<items; j++){
				if(weight[j] <= i){
					System.out.println(weight[j] + "<="+ i);
					System.out.println("j (# of items) = " + j);
					
					
					if(knapsack[i][j] == 0){
						knapsack[i][j] =  Math.max((optimal(i-weight[j], j-1) + value[j]), optimal(i, j-1));
					}


				}
			}
		}
		System.out.println(knapsack[n-1][items-1]);
//		System.out.println(optimal(n, items));
//worst case scenario, try populating the first column first
		
		
	}
	public int optimal(int weightNum, int itemNum){
		int answer = 0;
		System.out.println("else " + weightNum + " " + itemNum);
		if(weightNum == 0 || itemNum == 0){
			return 0;
		}
		if(knapsack[weightNum][itemNum] != 0){
			return knapsack[weightNum][itemNum];
		}
//		if(weightNum == 0){
//			return 0;
//		}		
		if(weightNum >= weight[itemNum]){
			knapsack[weightNum][itemNum]= Math.max((optimal(weightNum-weight[itemNum], itemNum-1) + value[itemNum]), optimal(weightNum, itemNum-1));
			System.out.println("vertex if " + weightNum + " " + itemNum);

		}
		else{
			knapsack[weightNum][itemNum] =  optimal(weightNum, itemNum-1);
			System.out.println("else itemNum - 1 = " + (itemNum-1));

		}
		
		return knapsack[weightNum][itemNum];
	}
}
