package apeclient.Event;

public class EventCancelable {
	
	private boolean cancelled = false;
	
	public boolean isCancelled() {
		return cancelled;
	}
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
	

}
