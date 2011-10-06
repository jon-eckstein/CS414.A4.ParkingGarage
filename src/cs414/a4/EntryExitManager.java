/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jeckstein
 */
public class EntryExitManager {
        
    Map<String,EntryEvent> openEntries;
    ArrayList<ExitEvent> exitEvents;
    RateManager rateManager;
    private int ticketIdCounter = 1;     
    
    public EntryExitManager(RateManager rm){
        rateManager = rm;
        openEntries = new HashMap<String, EntryEvent>();
        exitEvents = new ArrayList<ExitEvent>();
    }
    
    
    public int getFilledSpots() {
       return openEntries.size();
    }

    public EntryEvent createEntryEvent() {
        EntryEvent newEntry = new EntryEvent(Integer.toString(ticketIdCounter++), new Date());
        openEntries.put(newEntry.getTicketId(), newEntry);
        return newEntry;
    }
    
    public ExitEvent createExitEvent(String ticketId, Date exitDateTime) throws Exception{
        ExitEvent exit;
        BigDecimal rate;
                
        if(!Utilities.isNullOrEmpty(ticketId)){
            //this is a regular entry/exit event
            EntryEvent entry = openEntries.get(ticketId);
            if(entry == null) throw new Exception("Could not find entry with given ticket ID.");
            rate = getRate(entry.getEntryDate(), exitDateTime);
            exit = new ExitEvent(entry, exitDateTime, rate);
            //remove the openEntry record...
            openEntries.remove(ticketId);
        }else{
            //lost or damaged ticket, flat rate transaction...
            rate = getRate(exitDateTime);
            exit = new ExitEvent(null, exitDateTime, rate);            
        }
        
        exitEvents.add(exit);
        return exit;                
    }
    
    public EntryEvent getEntryEvent(String ticketId) throws Exception {
        if(openEntries.containsKey(ticketId))
            return openEntries.get(ticketId);
        else
            throw new Exception("Invalid ticket number.");                     
    }
    
    private BigDecimal getRate(Date entryDate, Date exitDate) throws Exception{
        return rateManager.getRegularRate(entryDate, exitDate);
    }
    
    private BigDecimal getRate(Date exitDateTime) throws Exception{
        return rateManager.getFlatRate(exitDateTime);
    }
    
    
    
}
