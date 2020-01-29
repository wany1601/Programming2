package internationalclocks;

import java.time.LocalDateTime;

/**
 * International Clocks, a class of many clocks, each one represent a city.
 * This class does not consider check the time zone of the current position, 
 * so only work at GMT-5.
 * 
 * @author Yi Wang
 */
public class InternationalClocks {
    private final static String[] CITIES = {"Montreal", "London", "Paris", "Beijing"};
    private final static Clock[] CLOCKS = new Clock[CITIES.length];

    public InternationalClocks() {
        // initial all clock to the current time
        for (int i = 0; i < CLOCKS.length; i++) {
            CLOCKS[i] = new Clock();
            CLOCKS[i].setCity(CITIES[i]);
            CLOCKS[i].setHr(LocalDateTime.now().getHour());
            CLOCKS[i].setMi(LocalDateTime.now().getMinute());
            CLOCKS[i].setSe(LocalDateTime.now().getSecond());
        }
        
        // tune the second clock, hard-coded time difference
        for (int i = 0; i < 5; i++)
            CLOCKS[1].increaseHr();
        
        // tune the third clock, hard-coded time difference
        for (int i = 0; i < 6; i++)
            CLOCKS[2].increaseHr();
        
        // tune the fourth clock, hard-coded time difference
        for (int i = 0; i < 13; i++)
            CLOCKS[3].increaseHr();
    }

    @Override
    public String toString() {
        String str = "";
        for (Clock clock : CLOCKS) 
            str += String.format("%13s", clock.getCity());
        str += "\n";
        for (Clock clock : CLOCKS) 
            str += String.format("%13s", clock);
        
        return str;
   }

    public Clock[] getCLOCKS() {
        return CLOCKS;
    }
}
