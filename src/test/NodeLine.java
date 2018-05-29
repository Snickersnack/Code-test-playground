package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class NodeLine {
	
	public static void main(String[] args){
		int[][] matrix = {{1,2}, {0,0}, {0,4},{2,4}, {-1, -1}, {1,1}, {1,0}, {4,0}};
		
		HashMap<Line, HashSet<int[]>> map = solve(matrix);

	}
		
	
	public static class Line{
		Double slope;
		Double yintercept;
		Double xintercept;
		
		@Override
		public boolean equals(Object obj){
			if (!(obj instanceof Line)){
				return false;
			}
			Line lineObject = (Line)obj;
			if(this.slope == null){
				return(lineObject.slope == null && this.yintercept.equals(lineObject.yintercept) && this.xintercept.equals(lineObject.xintercept));
			}
//			System.out.println("this.slope: " + this.slope + " lineObject.slope: " + lineObject.slope);
//			System.out.println("this.yintercept: " + this.yintercept + " lineObject.y: " + lineObject.yintercept);
//
//			System.out.println((this.slope == lineObject.slope && this.yintercept == lineObject.yintercept));
			return(this.slope.equals(lineObject.slope) && this.yintercept.equals(lineObject.yintercept)&& this.xintercept.equals(lineObject.xintercept));
		}
		
		@Override 
		public int hashCode(){
			
			int result = 17;
			if(slope != null){
				result = 31*result + slope.intValue();
				result = 31*result + yintercept.intValue();
				
			}else{
				result *= 11;
			}
			return result;
			
		}
		
	}
	public static HashMap<Line, HashSet<int[]>> solve(int[][] matrix){
		HashMap<Line, HashSet<int[]>> map = new HashMap<Line, HashSet<int[]>>();
		for(int i =0; i<matrix.length; i++){
			for(int j =0; j<matrix.length; j++){
				if(i == j){
					continue;
				}
				Double slope = 0.0;
				Double yIntercept = 0.0;
				Double xIntercept = 0.0;
				
				if(matrix[i][0] - matrix[j][0] != 0){
					 slope = ((double)matrix[i][1]-(double)matrix[j][1])/((double)matrix[i][0] - (double)matrix[j][0]);
					 yIntercept = (double)matrix[i][1]-((double)matrix[i][0] * slope);
				}else{
					 slope = null;
					 xIntercept = (double)matrix[i][0];
				}
				Line line = new Line();
				line.slope = slope;
				line.yintercept = yIntercept;
				line.xintercept = xIntercept;
				if(map.get(line) == null){
					HashSet<int[]> set = new HashSet<int[]>();
					map.put(line, set);
				}
				map.get(line).add(matrix[j]);				
				}
			}
			StringBuilder sb = new StringBuilder();
			for(Map.Entry<Line, HashSet<int[]>> entry : map.entrySet()){
				if(entry.getValue().size() >2){
					sb.append(" " + entry.getKey().slope + ": " );
					for(int[] array : entry.getValue()){
						sb.append(Arrays.toString(array) + ",");
					}
				}

		}
			System.out.println(sb.toString());
			
		
		return map;
	}
}
