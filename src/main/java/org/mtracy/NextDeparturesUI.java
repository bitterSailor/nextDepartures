package org.mtracy;

public class NextDeparturesUI {
    // Fetches Departures from a stop and prints the time, name of stop, and upcoming departures
    public static void stopDepartures(String stopId) throws Exception {
        // Initializes station & departure objects
        MBTAStation station = new MBTAStation(stopId);
        MBTADepartures departures = new MBTADepartures(stopId);
        // Gets current time & name of station
        String time = TimeConverter.getTime();
        String stationName = station.getName();
        // Creates a new string with only spaces
        StringBuilder string = new StringBuilder(" ".repeat(40));
        // Inserts time & name of station into string
        string.replace(0, time.length(), time);
        string.replace(20 - stationName.length() / 2, 20 - stationName.length() / 2 + stationName.length(), stationName);
        System.out.println(string);
        System.out.println("           Upcoming Departures          ");
        // Prints each departure on a new line
        for (int i = 0; i < departures.length(); i++) {
            // Checks to ensure departure time is valid and vehicle has not departed station
            if (!departures.getDeparture(i).equals("null") && TimeConverter.relativeMinutes(departures.getDeparture(i)) >= 0) {
                // Initializes trip and retrieves route, destination, and time until departure
                MBTATrip trip = new MBTATrip(departures.getTrip(i));
                String route = String.valueOf(trip.getRoute());
                String destination = trip.getDestination();
                String countdown = TimeConverter.relativeMinutes(departures.getDeparture(i)) + " Min";
                // Arranges variables into a string and prints departure
                StringBuilder line = new StringBuilder(" ".repeat(40));
                line.replace(0, route.length(), route);
                line.replace(route.length() + 1, route.length() + destination.length() + 1, destination);
                line.replace(40 - countdown.length(), 40, countdown);
                System.out.println(line);
            }
        }

    }
}
