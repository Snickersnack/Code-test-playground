package test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class QuickSort {
	int[] array;
	int pivotIndex;
	
	public QuickSort(int[] array){
		this.pivotIndex = 0;
		this.array = array;
		System.out.println(Arrays.toString(array));
	}
	
	public void calc(int left, int right){
		
	}

	public void swap(int left, int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
