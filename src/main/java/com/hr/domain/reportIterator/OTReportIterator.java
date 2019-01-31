package com.hr.domain.reportIterator;


import com.hr.repository.storage.DataAccessRepositoryFacade;

public class OTReportIterator implements ChartAggregate{

	
	DataAccessRepositoryFacade dataReport = new DataAccessRepositoryFacade();
	int totalRecord = dataReport.readLeaveForm().values().size();
	public int getTotalRecord() {
		return totalRecord;
	}

	Object [] otReports = dataReport.readLeaveForm().entrySet().toArray();
    
     
	@Override
	public Iterator getIterator() {

		return new OTReportRepository();
	}

	private class OTReportRepository implements Iterator {
		
		
		int index=0;

		@Override
		public boolean hasNext() {
			if (index < otReports.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if(this.hasNext()) {
				return otReports[index++];
			}
			return null;
		}

	}
}