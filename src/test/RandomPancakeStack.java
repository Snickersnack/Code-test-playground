package test;

public class RandomPancakeStack {

	public double expectedDeliciousness(int[] d){
		int index = d.length;
		double answer = 0;
		double[][] pancakeMatrix = new double[index][index];
		for(int i = 0; i<index; i++){
			for(int j = 0; j<index; j++){
				pancakeMatrix[i][j] = 0;
			}
		}
		for(int i = 0; i<index; i++){
			pancakeMatrix[i][0] = 1/(index) * d[i];

		}
		for(int i = 1; i<index; i++){
			for(int j = i; j<index; j++){
				pancakeMatrix[i][j] = (1/(index-i) * d[i]) * (pancakeMatrix[i-1][j]);
			}
		}
		
		
		
		return answer;
	}
	
	void recurse(){
		
	}
}
