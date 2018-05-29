package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class AmazonOnlineEduardo {

	public static void main(String[] args){
		HashMap<String, String> map = new HashMap();
		map.put("test" , "1");
		map.put("test2", "2");
		for(Entry<String, String> item : map.entrySet()){
			item.setValue("new");
		}
		for(Entry<String, String> item : map.entrySet()){
			System.out.println(item.getValue());
		}
		
		HashSet<item> set = new HashSet();
		item b = new item();
		item c = new item();
		b.i = "asdf";
		c.i = "dfasd";
		set.add(b);
		set.add(c);
		for(item a : set){
			a.i = "new";
		}
		for(item a : set){
			System.out.println(a.i);
		}
		String test = "/yelp corner beef noodle house @ alhambra";
		String[] test1 = test.substring(6).split("@");
		System.out.println(Arrays.toString(test1));
		System.out.println(test.indexOf('@'));
		for(String item : test1){
			item = item.replaceAll("\\s", "");
			if(item.isEmpty()){
				System.out.println("Must of format: /yelp search query @ location. Query and location must not be blank");
			}
		}
		String yelpTest = "/yelp display on";
		System.out.println(yelpTest.substring(6).equals("display on"));
	}
	
	public static class item{
		public String i;
	}
}
