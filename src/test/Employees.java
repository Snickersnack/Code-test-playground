package test;

public class Employees {

	public int fire(int[] manager, int[] salary, int[] productivity){
		
		
		int[] answerArray = new int[manager.length + 1];
		for(int i = manager.length - 1; i>=0; i--){
			int managerIndex = manager[i];
			int profit = productivity[i] - salary[i];
			answerArray[i + 1] += profit;
			if(answerArray[i+1] < 0){
				answerArray[i+1] = 0;
			}
			
			answerArray[managerIndex]+=answerArray[i+1];
			//System.out.println("manager: " + answerArray[managerIndex] + "answerArray[i + 1]" + answerArray[i+1]);
		}
		if(answerArray[0] < 0){
			answerArray[0] = 0;
		}
		
		
		return answerArray[0];
		
		}
	}


