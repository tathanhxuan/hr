package com.hr.domain.Notify;

public class EmailAlert implements Observer {

	private Subject NotifyCenter;

	public void update() {
		// TODO Auto-generated method stub
		String msg = (String) NotifyCenter.getUpdate(this);

		if (msg == null) {
			return;
		} else {
			// send email to persons who concerns
			System.out.println("Alert email was sent to concerned persons");
		}
	}

	public void setSubject(Subject sub) {
		// TODO Auto-generated method stub
		this.NotifyCenter = sub;
	}

}
