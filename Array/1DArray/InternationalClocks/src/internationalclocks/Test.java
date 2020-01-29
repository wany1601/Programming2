package internationalclocks;

import java.util.Timer;
import java.util.TimerTask;

/**
 * To print the international clocks every second.
 * @author Yi Wang
 */
public class Test {
    
    /**
     * A class of task that print all international clocks
     */
    private static class PrintClock extends TimerTask {
        @Override
        public void run() {
            // not the best, but a simple way to print clock in the console
            System.out.println(new InternationalClocks() + "\n\n\n\n\n\n\n\n\n");
        }
    }  
    
    public static void main(String[] args) {
        // use timer to call the task every second
        Timer timer = new Timer();
        // (task, time before the first execution, repeat time between each execution)
        timer.schedule(new PrintClock(), 0, 1000);
    }
}
