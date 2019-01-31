package com.hr.domain.reportChart;

import com.hr.repository.storage.DataAccessRepositoryFacade;

public class ATReportIterator extends ChartTemplate implements ChartAggregate {

	DataAccessRepositoryFacade dataReport = new DataAccessRepositoryFacade();
	int totalRecord = dataReport.readATForm().values().size();
	Object [] ATReports = dataReport.readATForm().entrySet().toArray();
    
	@Override
	public int getTotalRecord() {
		
		return totalRecord;
	}
	
	@Override
	public Iterator getIterator() {

		return new ATReportRepository();
	}

	private class ATReportRepository implements Iterator {
		
		
		int index =0;

		@Override
		public boolean hasNext() {
			if (index < ATReports.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if(this.hasNext()) {
				return ATReports[index++];
			}
			return null;
		}

	}

}
