package test;

import java.util.ArrayList;
import java.util.List;

public class XMarksTheSpot {

	public int countArea(String[] board){
		int answer = 0;
		char[][] array = new char[board.length][board[0].length()];
		List<Integer> questionMark = new ArrayList<Integer>();
		for(int i =0; i<board.length; i++){
			String word = board[i];
			for(int j = 0; j< word.length(); j++){
				array[i][j] = word.charAt(j);
				if(array[i][j] == '?'){
					
				}
			}
		}
		
		return answer;
		
	}
}
