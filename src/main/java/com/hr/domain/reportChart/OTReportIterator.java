package com.hr.domain.reportChart;


import com.hr.repository.storage.DataAccessRepositoryFacade;

public class OTReportIterator extends DataAccessRepositoryFacade implements ChartAggregate{

	
	@Override
	public Iterator getIterator() {
		
		return new OTReportRepository();
	}
	
	private class OTReportRepository implements Iterator{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}