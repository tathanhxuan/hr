package com.hr.domain.Notify;

import java.util.ArrayList;
import java.util.List;

public class NotifyService  implements Subject{

	private List<Observer> observers;
	private String message;
	private boolean changed;
	private final Object MUTEX= new Object();
	
	public NotifyService(){
		this.observers = new ArrayList<Observer>();
	}
	
	public void register(Observer obj) {
		// TODO Auto-generated method stub
		if(obj == null) throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
		if(!observers.contains(obj)) observers.add(obj);
		}
	}

	public void unregister(Observer obj) {
		// TODO Auto-generated method stub
		synchronized (MUTEX) {
			observers.remove(obj);
			}
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		List<Observer> observersLocal = null;
		//synchronization is used to make sure any observer registered after message is received is not notified
		synchronized (MUTEX) {
			if (!changed)
				return;
			observersLocal = new ArrayList<Observer>(this.observers);
			this.changed=false;
		}
		for (Observer obj : observersLocal) {
			obj.update();
		}
	}

	public Object getUpdate(Observer obj) {
		// TODO Auto-generated method stub
		return  this.message;
	}

	public void postMessage(String msg){
		this.message=msg;
		this.changed=true;
		notifyObservers();
	}
}
