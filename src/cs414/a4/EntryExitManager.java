/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jeckstein
 */
public class EntryExitManager {
        
    Map<String,SpotFullfillment> openEntries;
         
    public EntryExitManager(){
        openEntries = new HashMap<String, SpotFullfillment>();
    }
    
    
    public int getFilledSpots() {
        int counter = 0;
        for(SpotFullfillment spf : fullfilledSpots.values()){
            if(spf.getExitDateTime() == null)
                counter++;
        }
        
        return counter;
    }

    public SpotFullfillment createFullfillment() {
        SpotFullfillment newFullfillment = new SpotFullfillment();
        fullfilledSpots.put(newFullfillment.getTicketNumber(), newFullfillment);
        return newFullfillment;
    }

    public SpotFullfillment getSpotFullfillment(String ticketId) throws Exception {
        if(fullfilledSpots.containsKey(ticketId))
            return fullfilledSpots.get(ticketId);
        else
            throw new Exception("Invalid ticket number.");
                     
    }
    
}
