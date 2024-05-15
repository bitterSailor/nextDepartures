package org.mtracy;

public class MBTAStation extends MBTAObject {
    // Constructor
    public MBTAStation (String stopId) throws Exception {
        super("https://api-v3.mbta.com/stops?filter[id]=" + stopId);
    }

    // Returns name of station
    public String getName () {
        return super.getAttribute("name").toString();
    }
}
