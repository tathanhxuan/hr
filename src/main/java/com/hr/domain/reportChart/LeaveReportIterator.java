package com.hr.domain.reportChart;

import com.hr.repository.storage.DataAccessRepositoryFacade;

public class LeaveReportIterator extends ChartTemplate implements ChartAggregate{

		
	DataAccessRepositoryFacade dataReport = new DataAccessRepositoryFacade();
	int totalRecord = dataReport.readLeaveForm().values().size();
	
	@Override
	public int getTotalRecord() {
		return totalRecord;
	}

	Object [] leaveReports = dataReport.readLeaveForm().entrySet().toArray();
    
		
	@Override
	public Iterator getIterator() {

		return new LeaveReportRepository();
	}

	private class LeaveReportRepository implements Iterator {
		
		
		int index=0;

		@Override
		public boolean hasNext() {
			if (index < leaveReports.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if(this.hasNext()) {
				return leaveReports[index++];
			}
			return null;
		}

	}
}
