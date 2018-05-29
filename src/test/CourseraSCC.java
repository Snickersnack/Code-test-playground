package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class CourseraSCC {
	Stack stack;
	List<Integer> list;
	int[] array;
	int t;
	
	static class InputReader {
		public BufferedReader br;
		public StringTokenizer st;

		public InputReader() throws FileNotFoundException {
			br = new BufferedReader(new FileReader("/Users/wilsontan/Downloads/SCC.txt"));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
	private class Node{
		Node next;
		int value;
		Node leader;
		boolean explored = false;
		
		
	}
	public void solve() throws IOException{
		String sCurrentLine;
		InputReader in = new InputReader();
		int count = 0;
		long time = System.currentTimeMillis();
		String a ="";
		HashMap<Node, List<Node>> hash = new HashMap<Node,List<Node>>();
		
		//start with a reverse graph 
		//H T
		//1 2
		//1 3
		//1 4
		//Currently using a hashMap to store values. May need to use Matrix or Adjacency list
		//Use neither. We are going to just create the nodes and point them to each other. We are going to use the reverse version first
		int max = 0;
		try{
			for (Integer vertex = in.nextInt(); vertex != null; vertex = in.nextInt()) {
				Node tail = new Node();
				tail.value = vertex;
				Node head = new Node();
				head.value = in.nextInt();
				head.next = tail;
				if(vertex == null){
					break;
				}
				
				
				System.out.println(vertex + " " + in.nextInt());
				count++;
			}
		}catch(Exception e){
			System.out.println(e);
		}
		//once we've populated the graph, do DFS to get the completion times. As we complete, replace the values with completion times...
		//

		DFS(node);
		
		t = 0;
		for (Map.Entry<Node, List<Node>> set : hash.entrySet()){
			if(!set.getKey().explored){
				stack.push(set.getKey());
				DFS(hash, set.getKey());
			}
			
		}
		System.out.println("total number of lines: " + count);
		System.out.println("time = " + ((System.currentTimeMillis() - time) /1000) + "seconds");

		
	}
	public void DFS(Node node){
		
	}
	public void DFS(HashMap<Node, List<Node>> hash, Node node){
		if(node == null){
			return;
		}
		node.explored = true;		
		for(Node node1 : hash.get(node)){			
			if(node1 == null){
				return;
			}
			DFS(hash, node1);
			t++;			
			list.add(node1.value); // we may ahve to maintain order...
		}
		t++;
		node.value = t;

		
	}
	public HashMap<Node,List<Node>> reverseAdjacencyList(HashMap<Node, List<Node>> hash){
		HashMap<Node, List<Node>> reverseHash = new HashMap<Node, List<Node>>();
		
		for(Map.Entry<Node, List<Node>> set: hash.entrySet()){
			for(Node node : set.getValue()){
				if(reverseHash.get(node) == null){
					List<Node> nodeList = new ArrayList<Node>();
					nodeList.add(set.getKey());
					reverseHash.put(node, nodeList);
					
				}else{
					reverseHash.get(node).add(set.getKey());
				}
			}

		}
		return reverseHash;

	}

	
}
