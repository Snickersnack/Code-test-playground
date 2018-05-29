package test;

import java.util.HashMap;
import java.util.HashSet;

import test.PlayGround.Node;

public class PrivateMap {

	private HashMap<Integer, HashSet<Node>> map;

	public HashMap<Integer, HashSet<Node>> getMap() {
		return map;
	}

	public void setMap(HashMap<Integer, HashSet<Node>> map) {
		this.map = map;
	}

	public PrivateMap(){
		 map = new HashMap();
	}
	
	
}
