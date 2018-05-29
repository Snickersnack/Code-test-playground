package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class PQueue {
	public static void main(String[] args){
		List<Integer> pq = new ArrayList<>();
		pq.add(1);
		pq.add(4);
		pq.add(6);
		pq.add(12);
		pq.add(7);
		pq.add(13);
		pq.add(8);
		pq.add(15);
		pq.add(9);
		pq.add(11);
		pq.add(5);
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(12, Collections.reverseOrder());
		pq1.addAll(pq);
		System.out.println("priority queue heapify: " + pq1.toString());
		PQ test = new PQ();
		int[][] arr = { {1, 3, 5, 7},
	            {2, 4, 6, 8},
	            {0, 9, 10, 11}};
		for(int i = 0; i<arr.length; i++){
			for(int j = 0; j<arr[0].length; j++){
				test.add(arr[i][j]);
			}
		}
		test.sort(test.size()-1);
		test.print();
		test.heapify(pq);
		test.print();
		List<Integer> list = new ArrayList<Integer>();
		Iterator<Integer> it = pq1.iterator();

		
		
		while(it.hasNext()){
			list.add(pq1.remove());
		}
		System.out.println("Priority Queue: " + list);
		

		test.sort(test.size()-1);
		test.print();
	}
	
	public static class PQ{
		List<Integer> list;
		public PQ(){
			list = new ArrayList<>();
			
		}
		public void add(Integer integer){
			list.add(integer);
			bubbleUp(list.size()-1);
		}
		public Integer remove(){
			if(list.size() <= 1){
				return list.get(0);
			}
			Integer temp = list.get(0);
			list.set(0, list.get(list.size()-1));
			list.remove(list.size()-1);
			bubbleDown(0,list.size());
			
			return temp;
		}
		private void bubbleUp(int index){
			Integer temp = list.get(index);
			if(index <1){
				return;
			}
			if(temp > list.get((index-1)/2)){
				swap(index, (index-1)/2);
				bubbleUp((index-1)/2);
				bubbleUp(index);
			}
		}

		private void bubbleDown(Integer startIndex, Integer endIndex){
			int parent = startIndex;
			Integer difference = endIndex - startIndex;
			if(difference <= 0){
				return;
			}
			if(difference == 1){
				if(list.get(startIndex) < list.get(endIndex)){
					swap(startIndex, endIndex);
				}
			}
			if(2 * startIndex + 2 > endIndex){
				return;
			}
			Integer leftChildIndex = 2*startIndex + 1;
			Integer leftChild = list.get(leftChildIndex);
			Integer rightChildIndex = 2*startIndex + 2;
			Integer rightChild = list.get(rightChildIndex);
			Integer largerIndex;
			if(leftChild > rightChild){
				largerIndex = leftChildIndex;
			}else{
				largerIndex = rightChildIndex;
			}
			if(list.get(largerIndex) > list.get(parent)){
				swap(parent, largerIndex);
				bubbleDown(largerIndex, endIndex);
				//bubbleDown(parent, endIndex);
			}
			
				
			
		}
		public void heapify(List<Integer> newList){
			list.clear();
			list.addAll(newList);
			int length = list.size();
			for(int i = length/2; i>=0; i--){
				bubbleDown(i,length);
			}
		}
		public void sort(int endIndex){
			if(endIndex == 0){
				return;
			}
			swap(0, endIndex);
			bubbleDown(0, endIndex-1);
			sort(endIndex-1);

			System.out.println(list);
		}
		private void swap(int index1, int index2){
			Integer temp = list.get(index1);
			list.set(index1, list.get(index2));
			list.set(index2, temp);
			
		}
		public int size(){
			return list.size();
		}
		public void print(){
			System.out.println("My Version: " + list);
		}
	}
}
