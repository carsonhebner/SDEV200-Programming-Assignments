// Plane Tracker 
// SDEV-200 Final Project (11/8/26)
// Author: Carson Hebner

import java.util.LinkedList;

// Holds all the “completed/filled” plane objects from LoggedPlane (list of all the planes I have recorded)
public class FlightLog {

    private LinkedList<LoggedPlane> planeList;

    // constructor for making the list
    public FlightLog() {
        planeList = new LinkedList<LoggedPlane>();
    }

    // method for adding each plane to planeList
    public void addPlane(LoggedPlane newPlane) {
        planeList.add(newPlane);

    }

    // method for returning planes from the planeList
    public LinkedList<LoggedPlane> getPlanes() {
        return planeList;
    }

    // method for returning the last five planes I added
    public LinkedList<LoggedPlane> getLastFive() {
        LinkedList<LoggedPlane> lastFiveList = new LinkedList<LoggedPlane>();

        if (planeList.size() < 5) {
            return planeList;

        } else {
            for (int i = planeList.size() - 5; i < planeList.size(); i++) {
                lastFiveList.add(planeList.get(i));
            }
        }

        return lastFiveList;
    }

}
