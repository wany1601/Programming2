package internationalclocks;

/**
 * Simple Clock class
 * @author Yi Wang
 */
public class Clock {
    private String city;
    private int hr;
    private int mi;
    private int se;

    public Clock() {
        this.hr = 0;
        this.mi = 0;
        this.se = 0;
    }
    
    public Clock(int hr, int mi, int se) {
        this.hr = hr;
        this.mi = mi;
        this.se = se;
    }
    
    /**
     * increase the hour by one
     */
    public void increaseHr() {
        hr++;
        if (hr == 24)
            hr = 0;
    }
    
    /**
     * increase the minute by one
     */
    private void increaseMi() {
        mi++;
        if (mi == 60) {
            increaseHr();
            mi = 0;
        }
    }
    
    /**
     * increase the second by one
     */
    public void increaseSe() {
        se++;
        if (se == 60) {
            increaseMi();
            se = 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hr, mi, se);
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public void setMi(int mi) {
        this.mi = mi;
    }

    public void setSe(int se) {
        this.se = se;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public int getHr() {
        return hr;
    }

    public int getMi() {
        return mi;
    }

    public int getSe() {
        return se;
    }
}
