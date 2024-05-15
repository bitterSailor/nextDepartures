package org.mtracy;

public class MBTAStation extends MBTAObject {
    public MBTAStation (String stopId) throws Exception {
        super("https://api-v3.mbta.com/stops?filter[id]=" + stopId);
    }

    public String getName () {
        return super.getAttribute("name").toString();
    }
}
