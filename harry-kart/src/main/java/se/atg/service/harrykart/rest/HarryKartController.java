package se.atg.service.harrykart.rest;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import se.atg.entity.harrykart.HarryKart;
import se.atg.entity.harrykart.Lane;
import se.atg.entity.harrykart.Loop;
import se.atg.entity.harrykart.Participant;

@RestController
@RequestMapping("/api")
public class HarryKartController {

//    @RequestMapping(method = RequestMethod.POST, path = "/play", consumes = "application/xml", produces = "application/json")
//    public String playHarryKart() {
//        return "{ \"message\": \"Don't know how to play yet\" }";
//    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/play")
    public String playHarryKart(){
        System.out.println("*************Inside Controller");
        String json = "";
        JsonObject ranking = new JsonObject();

        try {
            JsonArray list = new JsonArray();
    		File file = new File("src/main/resources/input_0.xml");
    		System.out.println(file);
    		JAXBContext jaxbContext = JAXBContext.newInstance(HarryKart.class);

    		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    		HarryKart harryKart = (HarryKart) jaxbUnmarshaller.unmarshal(file);
    		System.out.println(harryKart.getStartList().getParticipant());
    		System.out.println(harryKart.getPowerUps().getLoop());
    		
    		ArrayList<Participant> participants = harryKart.getStartList().getParticipant(); 
    		
    		ArrayList<Loop> loops = harryKart.getPowerUps().getLoop();
    		Map<String,Integer> finalist = new HashMap<String,Integer>();
    		for(Participant partcipant : participants) {
    			System.out.println("horse: "+partcipant.getName());
    			int baseSpeed= partcipant.getBaseSpeed();
    			int lane= partcipant.getLane();
        		int totalDistCoverred=1;
    			System.out.println("lane: "+lane);
    			System.out.println("baseSpeed: "+baseSpeed);
    			for(Loop loop : loops) {
    				for(Lane laneObj : loop.getLane()) {
    					if(laneObj.getNumber()==lane) {
    						System.out.println("powerUp: "+laneObj.getPowerUpVal());
    						baseSpeed += laneObj.getPowerUpVal();
    		    			System.out.println("baseSpeed: "+baseSpeed);
    						totalDistCoverred+=(1*baseSpeed);
    						System.out.println("totalDistCoverred: "+totalDistCoverred);
    					}
        			}
    			}
    			finalist.put(partcipant.getName(),totalDistCoverred);
    		}
    		
    		
            List<Entry<String, Integer>> greatest = findGreatest(finalist, 3);
            System.out.println("Top 3"+" entries:");
            int position=3;
            for (Entry<String, Integer> entry : greatest)
            {
                System.out.println(entry);
                JsonObject rank = new JsonObject();
                rank.addProperty("position", position);
                rank.addProperty("horse", entry.getKey());
                position--;
                list.add(rank);
            }
            ranking.add("ranking", list);

    		System.out.println("list: " + ranking.toString());
  		
    		
    	  } catch (JAXBException e) {
    		e.printStackTrace();
    	 }
        
        json=ranking.toString() ;
        return json;
    }
    
    private static <K, V extends Comparable<? super V>> List<Entry<K, V>> 
    findGreatest(Map<K, V> map, int n)
	{
	    Comparator<? super Entry<K, V>> comparator = 
	        new Comparator<Entry<K, V>>()
	    {
	        @Override
	        public int compare(Entry<K, V> e0, Entry<K, V> e1)
	        {
	            V v0 = e0.getValue();
	            V v1 = e1.getValue();
	            return v0.compareTo(v1);
	        }
	    };
	    PriorityQueue<Entry<K, V>> highest = 
	        new PriorityQueue<Entry<K,V>>(n, comparator);
	    for (Entry<K, V> entry : map.entrySet())
	    {
	        highest.offer(entry);
	        while (highest.size() > n)
	        {
	            highest.poll();
	        }
	    }
	
	    List<Entry<K, V>> result = new ArrayList<Map.Entry<K,V>>();
	    while (highest.size() > 0)
	    {
	        result.add(highest.poll());
	    }
	    return result;
	}

}
