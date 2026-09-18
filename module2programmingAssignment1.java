// Geometry: The MyDate class
// Module 2 Programming Assignment (1)
// Author: Carson Hebner

import java.util.GregorianCalendar;

public class module2programmingAssignment1 {

    public static void main(String[] args) {

        // creating objects and outputting dates
        MyDate date1 = new MyDate();
        MyDate date2 = new MyDate(34355555133101L);

        System.out.println("IMPORTANT: Month is 0-based, i.e., 0 is for January ");
        System.out.println();
        System.out.println("Outputting dates (MM/DD/YYYY) ... ");
        System.out.println();
        System.out.println("date1: " + date1.getMonth() + "-" + date1.getDay() + "-" + date1.getYear());
        System.out.println("date2: " + date2.getMonth() + "-" + date2.getDay() + "-" + date2.getYear());

    }

}

//class that holds dates and logic
class MyDate {

    private int year;
    private int month;
    private int day;

    // current date
    public MyDate() {

        GregorianCalendar currdate = new GregorianCalendar();
        year = currdate.get(GregorianCalendar.YEAR);
        month = currdate.get(GregorianCalendar.MONTH);
        day = currdate.get(GregorianCalendar.DAY_OF_MONTH);

    }

    // elapsed time
    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    // specified date
    public MyDate(int xyear, int xmonth, int xday) {
        year = xyear;
        month = xmonth;
        day = xday;
    }

    // three getter methods
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    // method for setting date 
    public void setDate(long elapsedTime) {
        GregorianCalendar elapsed = new GregorianCalendar();
        elapsed.setTimeInMillis(elapsedTime);

        year = elapsed.get(GregorianCalendar.YEAR);
        month = elapsed.get(GregorianCalendar.MONTH);
        day = elapsed.get(GregorianCalendar.DAY_OF_MONTH);
    }
}
