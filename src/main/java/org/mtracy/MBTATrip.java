package org.mtracy;

public class MBTATrip extends MBTAObject {
    // Constructor
    public MBTATrip (String tripId) throws Exception {
        super("https://api-v3.mbta.com/trips?filter[id]=" + tripId);
    }

    // Returns route id of trip
    public String getRoute () {
        return super.getObject().getJSONObject("relationships").getJSONObject("route").getJSONObject("data").getString("id");
    }

    // Returns destination of trip
    public String getDestination () {
        return super.getAttribute("headsign").toString();
    }
}
