package test;

public class BinarySearch {

	public static void main(String[] args){
		//assume sorted
		int[] array = {3,6,1,5,10,-1,-3,-6,0,4,20,41};
		System.out.println(search(array, 0, array.length-1, 3));
		
	}
	public static Integer search(int[] array, int begin, int end, int number){
		if(begin>end){
			return null;
		}
		int mid = ((end-begin)/2) + begin;
		System.out.println("end:" + end + " begin " + begin);
		System.out.println("mid = " + mid);
		int midPoint = array[mid];
		if(number == midPoint){
			return mid;
		}
		if(number>array[mid]){
			return search(array, mid+1, array.length-1, number);
		}else{
			return search(array, 0, mid-1, number);
		}
		
		
	}
}
