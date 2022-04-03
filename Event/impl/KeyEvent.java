package apeclient.Event.impl;

import apeclient.Event.EventCancelable;

public class KeyEvent extends EventCancelable{
	
	private final int key;
	
	public KeyEvent(int key) {
		this.key = key;
	}
public int getKey() {
	return key;
}
public void call() {
	// TODO Auto-generated method stub
	
}
}
