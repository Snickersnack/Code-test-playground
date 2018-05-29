package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.mirth.match.client.MirthMatchClient;


public class Testy {
	
	public static void main(String[] args) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = "03112017";

        Date date = formatter.parse(dateInString);
		System.out.println(date);
		
		try{
			MirthMatchClient client = new MirthMatchClient("test", "test", "test");
			client.getCoreSessionBean().
		}catch(Exception e){
			
		}
	}

	
}
