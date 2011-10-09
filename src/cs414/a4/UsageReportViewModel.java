/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jeckstein
 */
public class UsageReportViewModel {
    
    ArrayList<UsageReportDetail> reportDetail = new ArrayList<UsageReportDetail>();
    
    
    public void addDetail(UsageReportDetail detail){
        reportDetail.add(detail);
    }
    
    
    
    public ArrayList<UsageReportDetail> getReportDetail(){
        return reportDetail;
    }    
    
    public class UsageReportDetail{
        public final Date detailDate;
        public final int hour;
        public final int numSpotFilled;
        public final double percentageOccupied; 
                
        public UsageReportDetail(Date detailDate, int hour, int numSpotFilled, double percentageOccupied){
            this.detailDate = detailDate;
            this.hour = hour;
            this.numSpotFilled = numSpotFilled;
            this.percentageOccupied = percentageOccupied; 
        }
        
        
        
        
    }
    
    
}
