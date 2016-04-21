package framework.control;

public class GreenhouseControls extends Controller {
	private boolean light =false;
	
	public class LightOn extends Event{

		public LightOn(long dealayTime) {
			super(dealayTime);
		}

		@Override
		public void action() {
			light = true;
		}
		public String toString(){
			return "Lisght is on";
		}
	}
	
	public class LightOff extends Event{

		public LightOff(long dealayTime) {
			super(dealayTime);
		}

		@Override
		public void action() {
			light = false;
			
		}
		public String toString(){
			return "Lisght is off";
		}
	}
	private boolean water = false;
	
	public class WaterOn extends Event{

		public WaterOn(long dealayTime) {
			super(dealayTime);
		}

		@Override
		public void action() {
			light = true;
			
		}
		public String toString(){
			return "water is on";
		}
	}
	
	public class WaterOff extends Event{

		public WaterOff(long dealayTime) {
			super(dealayTime);
		}

		@Override
		public void action() {
			light = false;
			
		}
		public String toString(){
			return "WaterOff is off";
		}
	}
	
	private String thermostat = "Day";
	
	public class ThermostatNight extends Event{

		public ThermostatNight(long dealayTime) {
			super(dealayTime);
		}

		@Override
		public void action() {
			thermostat = "Night";
		}
		public String toString(){
			return "ThermostatNight on night";
		}
		
	}
	
	public class ThermostatDay extends Event{

		public ThermostatDay(long dealayTime) {
			super(dealayTime);
		}

		@Override
		public void action() {
			thermostat = "Day";
		}
		public String toString(){
			return "ThermostatNight on day";
		}
		
	}
	
	public class Bell extends Event{

		public Bell(long dealayTime) {
			super(dealayTime);
		}

		@Override
		public void action() {
			addEvent(new Bell(delayTime));
		}
		public String toString(){
			return "Bing!";
		}
	}
	
	public class Restart extends Event{
		private Event[] eventList;
		public Restart(long dealayTime,Event[] eventList) {
			super(dealayTime);
			this.eventList = eventList;
			for (Event event : eventList) {
				addEvent(event);
			}
		}

		@Override
		public void action() {
			for (Event event : eventList) {
				event.start();
				addEvent(event);
			}
			start();
			addEvent(this);
		}
		public String toString(){
			return "Restarting system";
		}
	}
	public static class Terminate extends Event{

		public Terminate(long dealayTime) {
			super(dealayTime);
		}

		@Override
		public void action() {
			System.exit(0);
		}
		public String toString(){
			return "Terminating";
		}
		
	}
}
