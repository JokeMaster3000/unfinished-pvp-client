package apeclient.Event;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;



public class Event {

	
	
	public Event call() {
		final ArrayList<EventData> dataList = EventManager.get(this.getClass());
		
		if(dataList != null ) {
			for(EventData data : dataList) {
				try {
					data.target.invoke(data.source, this);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				} 
		
			}
		return null;
	}
}
