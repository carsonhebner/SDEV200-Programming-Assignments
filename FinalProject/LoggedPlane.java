// Plane Tracker 
// SDEV-200 Final Project (11/8/26)
// Author: Carson Hebner

// Class used to create the actual plane objects that get logged.
public class LoggedPlane extends Plane {

    public LoggedPlane(String aircraftType, String toFrom, int altitude, String callsign, String timeOfRecording,
            String commercialOrPrivate) {
        super(aircraftType, toFrom, altitude, callsign, timeOfRecording, commercialOrPrivate);
    }
}
