package BC_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import java.util.List;

public class zzzz{	 
	

	public static void main(String[] args) {

		 HashMap<String, String> companies = new HashMap<String, String>();
	        companies.put("eBay", "South San Jose");
	        companies.put("Paypal", "North San Jose");
	        companies.put("Google", "Mountain View");
	        companies.put("Yahoo", "Santa Clara");
	        companies.put("Twitter", "San Francisco");
	        
	        Object[] crunchifyKeys = companies.keySet().toArray();
	        Object key = crunchifyKeys[new Random().nextInt(crunchifyKeys.length)];
	        System.out.println("************ Random Value ************ \n" + key + " :: " + companies.get(key));
	 	        
	 
	        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(companies.entrySet());
	        
	        
	        System.out.println("\n************ Now Let's start shuffling list ************");
	        Collections.shuffle(list);
	   
	        for (int i=0; i<5; i++) {
	  //          System.out.println(entry.getKey() + " :: " + entry.getValue());
	        
		
	 } 
}
}
