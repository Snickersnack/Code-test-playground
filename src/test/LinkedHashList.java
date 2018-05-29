package test;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public class LinkedHashList {

	String removeDuplicateCharacters(String str) {
	    LinkedHashMap<String, Integer> hash = new LinkedHashMap<String, Integer>();
	    String[] split = str.split("");
	    Integer intobj = new Integer ((int)1);
	    for(int i = 0; i<split.length; i++){
	    	Integer value = hash.get(split[i]);
	    	if(value == null){
		        hash.put(split[i], intobj);
	    	}
	    	else{
	    		value+=1;
	    		
	    		hash.put(split[i], value);
	    	}
	    }
	    StringBuilder sb = new StringBuilder();
	    Iterator it = hash.entrySet().iterator();
	    
	        
	    while(it.hasNext()){
	            Map.Entry pair = (Map.Entry)it.next();
	            System.out.println(pair.getKey() + " = " + pair.getValue());
	            if(pair.getValue() == intobj){
	                sb.append(pair.getKey());

	            }
	            

	    }
	    return sb.toString();
	}

}
