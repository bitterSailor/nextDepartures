package org.mtracy;

public class MBTADepartures extends MBTAObject {
    // Constructor
    public MBTADepartures (String stopId) throws Exception {
        super("https://api-v3.mbta.com/predictions?sort=departure_time&filter[revenue]&filter[stop]=" + stopId);
    }

    // Returns departure time of index i
    public String getDeparture() {
        return super.getAttribute("departure_time").toString();
    }
    public String getDeparture(int index) {
        return super.getAttribute("departure_time", index).toString();
    }

    // Returns id of associated trip for index of i
    public String getTrip () {
        return super.getObject(0).getJSONObject("relationships").getJSONObject("trip").getJSONObject("data").getString("id");
    }
    public String getTrip (int index) {
        return super.getObject(index).getJSONObject("relationships").getJSONObject("trip").getJSONObject("data").getString("id");
    }
}
