/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jeckstein
 */
public class ReportManager {
   
    EntryExitManager entryExitManager;
    int totalSpots;
    
    public ReportManager(EntryExitManager eem, int totalSpots){
        entryExitManager = eem;
        this.totalSpots = totalSpots;               
    }
    
    public UsageReportViewModel GetUsageReport(Date startDate, Date endDate){
        
        UsageReportViewModel viewModel = new UsageReportViewModel();
        
        EntryEvent[] currentEntryEvents = entryExitManager.getCurrentEntryEvents();
        ExitEvent[] exitEvents = entryExitManager.getExitEvents();
        
        Calendar cal=Calendar.getInstance();
        Calendar entryExitCal = Calendar.getInstance();
        
        for(cal.setTime(startDate); cal.before(endDate); cal.add(Calendar.HOUR, 1)){
            int hourCounter = 0;                
            
            for(EntryEvent entry : currentEntryEvents){
                entryExitCal.setTime(entry.getEntryDate());
                if(entryExitCal.get(Calendar.HOUR) == cal.get(Calendar.HOUR))
                    hourCounter++;
            }
            
            System.out.println("Current hour..." + cal.toString());
                        
        }
            
        
        
        return viewModel;
        /*
        for(EntryEvent ev : currentEntryEvents){
            if(ev.getEntryDate() >= startDate && ev.getEntryDate() <= endDate){
                
            }
        }
        */
        
        
        
        
    }
    
}
