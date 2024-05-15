package org.mtracy;

public class MBTATrip extends MBTAObject {
    public MBTATrip (String tripId) throws Exception {
        super("https://api-v3.mbta.com/trips?filter[id]=" + tripId);
    }

    public String getRoute () {
        return super.getObject().getJSONObject("relationships").getJSONObject("route").getJSONObject("data").getString("id");
    }

    public String getDestination () {
        return super.getAttribute("headsign").toString();
    }
}
