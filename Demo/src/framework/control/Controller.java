package framework.control;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	private List<Event> eventList = new ArrayList<Event>();
	public void addEvent(Event e){
		eventList.add(e);
	}
	
	public void run(){
		while(eventList.size() > 0){
			for (Event event : new ArrayList<Event>(eventList)) {
				if(event.ready()){
					System.out.println(event);
					event.action();
					eventList.remove(event);
				}
			}
		}
	}
}
