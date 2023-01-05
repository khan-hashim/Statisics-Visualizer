package controllers;

import java.util.ArrayList;

public class Subject {
	
	private ArrayList<Observer> viewers;
	private ViewersData state;
	
	public Subject() {
		viewers = new ArrayList<>();
	}
	public void setState(ViewersData data) {
		this.state = data;
		this.notifyViewers(); // notifies all its observers after its state changes
	}
	public ViewersData getState() {
		return this.state;
	}
	public ArrayList<Observer> getViewers(){
		return this.viewers;
	}
	public void attach(Observer viewer) {
		viewers.add(viewer);
	}
	
	public void detach(Observer viewer) {
		viewers.remove(viewer);
	}
	
	public void notifyViewers() {
		for(int i = 0; i < viewers.size(); i++) {
			viewers.get(i).update(this);
		}
	}

	

}
