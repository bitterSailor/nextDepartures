package org.mtracy;

public class NextDeparturesUI {
    public static void stopDepartures(String stopId) throws Exception {
        MBTAStation station = new MBTAStation(stopId);
        MBTADepartures departures = new MBTADepartures(stopId);
        String time = TimeConverter.getTime();
        String stationName = station.getName();
        StringBuilder string = new StringBuilder(" ".repeat(40));
        string.replace(0, time.length(), time);
        string.replace(20 - stationName.length() / 2, 20 - stationName.length() / 2 + stationName.length(), stationName);
        System.out.println(string);
        System.out.println("           Upcoming Departures          ");
        for (int i = 0; i < departures.length(); i++) {
            if (!departures.getDeparture(i).equals("null") && TimeConverter.relativeMinutes(departures.getDeparture(i)) >= 0) {
                MBTATrip trip = new MBTATrip(departures.getTrip(i));
                String route = String.valueOf(trip.getRoute());
                String destination = trip.getDestination();
                String countdown = TimeConverter.relativeMinutes(departures.getDeparture(i)) + " Min";
                StringBuilder line = new StringBuilder(" ".repeat(40));
                line.replace(0, route.length(), route);
                line.replace(route.length() + 1, route.length() + destination.length() + 1, destination);
                line.replace(40 - countdown.length(), 40, countdown);
                System.out.println(line);
            }
        }

    }
}
