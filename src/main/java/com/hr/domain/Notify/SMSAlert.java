package com.hr.domain.Notify;

public class SMSAlert implements Observer {
	
	private Subject NotifyCenter;
	
	public void update() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String msg = (String) NotifyCenter.getUpdate(this);
				if(msg == null){
					return;
				}else
				{ 
					// send SMS to persons who concerns 
					System.out.println("Alert email was sent to concerned persons");
			  }
	}

	public void setSubject(Subject sub) {
		// TODO Auto-generated method stub
		this.NotifyCenter=sub;
	}

}
