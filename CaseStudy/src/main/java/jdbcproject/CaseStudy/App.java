package jdbcproject.CaseStudy;

import jdbcproject.CaseStudy.CallQuality;

public class App 
{
    public static void main( String[] args )
    {
    	CallQuality obj = new CallQuality();
    	obj.dbConnect();
    	obj.executeStatements();
    	obj.insertRecords();
    	obj.getRecords();
    	obj.updateRecords();
    	obj.getRecordsWithConditions();
    	obj.deleteRecord(5);
    	obj.insertRecordWithParameters(10, "1234567890", "Good call quality", 5, "Alice", "40%");
    	obj.updateRecordWithParameter(7, "20%");
    }
}
