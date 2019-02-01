package com.hr.domain.reportIterator;

import com.hr.repository.storage.DataAccessRepositoryFacade;

public class ATReportIterator implements ChartAggregate {

	DataAccessRepositoryFacade dataReport = new DataAccessRepositoryFacade();
	int totalRecord = dataReport.readATForm().values().size();
	String [] ATReports = {"One", "Two", "Three"};
	//Object [] ATReports = dataReport.readATForm().entrySet().toArray();
    
		
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
			if(this.hasNext()==true) {
				return ATReports[index++];
			}
			return null;
	}
}
}
