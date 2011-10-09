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
    
    public UsageReportViewModel getUsageReport(Date startDate, Date endDate){
        
        UsageReportViewModel viewModel = new UsageReportViewModel(startDate, endDate);
        
        EntryEvent[] currentEntryEvents = entryExitManager.getCurrentEntryEvents();
        ExitEvent[] exitEvents = entryExitManager.getExitEvents();
        
        Calendar calCounter=Calendar.getInstance();
        Calendar calEnd = Calendar.getInstance();        
        Calendar entryExitCal = Calendar.getInstance();
        
        for(calCounter.setTime(startDate), calEnd.setTime(endDate); calCounter.before(calEnd); calCounter.add(Calendar.HOUR, 1)){
            int hourCounter = 0;                
           
            for(EntryEvent entry : currentEntryEvents){
                entryExitCal.setTime(entry.getEntryDate());
                if(entryExitCal.after(calCounter))
                    hourCounter++;
            }
            
            for(ExitEvent exit : exitEvents){
                entryExitCal.setTime(exit.getEntryDate());
                Date calCounterDate = calCounter.getTime();
                if(!(calCounterDate.before(exit.getEntryDate()) 
                        || calCounterDate.after(exit.getExitDate()))){
                    hourCounter++;
                }
            }
            
            UsageReportDetail detail = new UsageReportDetail(calCounter.getTime(), 
                    calCounter.get(Calendar.HOUR), 
                    hourCounter, hourCounter / totalSpots); 
            
            viewModel.addDetail(detail);
           
            //System.out.println("Current hour..." + calCounter.getTime().toString());
                        
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
