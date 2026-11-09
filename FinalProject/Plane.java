// Plane Tracker 
// SDEV-200 Final Project (11/8/26)
// Author: Carson Hebner

// abstract class that holds the logic for each plane
public abstract class Plane {

    private String aircraftType;
    private String toFrom;
    private int altitude;
    private String commercialOrPrivate;
    private String timeOfRecording;
    private String callsign;
    private static int planeCount;

    // constructor for the blank abstract plane
    public Plane(String aircraftType, String toFrom, int altitude, String commercialOrPrivate, String timeOfRecording,
            String callsign) {

        this.aircraftType = aircraftType;
        this.toFrom = toFrom;
        this.altitude = altitude;
        this.commercialOrPrivate = commercialOrPrivate;
        this.timeOfRecording = timeOfRecording;
        this.callsign = callsign;
        planeCount++;
    }

    // toString() method to convert indivisual planes into a string
    @Override
    public String toString() {
        return aircraftType + " | " + toFrom + " | " + altitude + " | " + callsign + " | " + timeOfRecording + " | "
                + commercialOrPrivate;
    }

    // getter methods for each data type
    public String getAircraftType() {
        return aircraftType;
    }

    public String getToFrom() {
        return toFrom;
    }

    public int getAltitude() {
        return altitude;
    }

    public String getCommercialOrPrivate() {
        return commercialOrPrivate;
    }

    public String getTimeOfRecording() {
        return timeOfRecording;
    }

    public String getCallsign() {
        return callsign;
    }

    public static int getPlaneCount() {
        return planeCount;
    }

    // setter methods
    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public void setToFrom(String toFrom) {
        this.toFrom = toFrom;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public void setCommercialOrPrivate(String commercialOrPrivate) {
        this.commercialOrPrivate = commercialOrPrivate;
    }

    public void setTimeOfRecording(String timeOfRecording) {
        this.timeOfRecording = timeOfRecording;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

}
