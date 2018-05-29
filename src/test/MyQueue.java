package test;

import test.PlayGround.Node;

public  class MyQueue{
	Node first;
	Node last;
	int size;
	
	public MyQueue(){
		size = 0;
		first = null;
		last = null;
	}
	
	public int peek(){
		return first.value;
	}
	public void enqueue(Node node){
		if(first == null){
			first = node;
			first.next = null;
			last = node;
			last.next = null;
		}else{
			Node oldLast = last;
			last = node;
			oldLast.next = last;
		}
		size++;
	}
	public int dequeue(){
		int temp = first.value;
		first = first.next;
		size--;
		
		return temp;
	}
	public int size(){
		return size;
	}
}
