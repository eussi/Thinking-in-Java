package innerclasses;//: innerclasses/GreenhouseController.java
// Configure and execute the greenhouse system.
// {Args: 5000}
import innerclasses.controller.*;

public class GreenhouseController {
  public static void main(String[] args) {
    GreenhouseControls gc = new GreenhouseControls();
    // Instead of hard-wiring, you could parse
    // configuration information from a text file here:
    gc.addEvent(gc.new Bell(9000));
    Event[] eventList = {
      gc.new ThermostatNight(100),
      gc.new LightOn(2000),
      gc.new LightOff(4000),
      gc.new WaterOn(6000),
      gc.new WaterOff(8000),
      gc.new ThermostatDay(14000)
    };	
    gc.addEvent(gc.new Restart(20000, eventList));
    if(args.length == 1)
      gc.addEvent(
        new GreenhouseControls.Terminate(
          new Integer(args[0])));
    gc.run();
  }
} /* Output:
Bing!
Thermostat on night setting
Light is on
Light is off
Greenhouse water is on
Greenhouse water is off
Thermostat on day setting
Restarting system
Terminating
*///:~
