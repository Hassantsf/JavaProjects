package ir.ac.kntu.tool;

public class Shift {
    // Fields
    private ShiftTime time;
    private Week day;
    private int timeNumber;
    private int dayNumber;

    // Constructors
    public Shift() {
        int day = ScannerWrapper.getIntField("number of day(1 - 7)");
        int time = ScannerWrapper.getIntField(dayList());
        setDayNumber(day);
        setTimeNumber(time);
        this.day = convertIntToWeek(day);
        this.time = convertIntToTime(time);
        Menu.result(true);
    }

    public Shift(ShiftTime time, Week day) {
        this.setTime(time);
        this.setDay(day);
    }

    public Shift(int dayNumber, int timeNumber) {
        this.setDayNumber(dayNumber);
        this.setTimeNumber(timeNumber);
        this.day = convertIntToWeek(dayNumber);
        this.time = convertIntToTime(timeNumber);
    }

    public ShiftTime getTime() {
        return time;
    }

    public int getTimeNumber() {
        return timeNumber;
    }

    public void setTime(ShiftTime time) {
        this.time = time;
    }

    public Week getDay() {
        return day;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDay(Week day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Shift" + "------------------------------------------------" +
                "Time: " + getTime() +
                "Day: " + getDay() +
                "------------------------------------------------";
    }

    public Week convertIntToWeek(int day) {
        switch (day) {
            case 1:
                return Week.SATURDAY;
            case 2:
                return Week.SUNDAY;
            case 3:
                return Week.MONDAY;
            case 4:
                return Week.TUESDAY;
            case 5:
                return Week.WEDNESDAY;
            case 6:
                return Week.THURSDAY;
            case 7:
                return Week.FRIDAY;
            default:
                return null;
        }
    }

    public ShiftTime convertIntToTime(int time) {
        switch (time) {
            case 1:
                return ShiftTime.MORNING;
            case 2:
                return ShiftTime.AFTERNOON;
            case 3:
                return ShiftTime.NIGHT;
            default:
                return null;
        }
    }

    private String dayList() {
        return "number of time[ 1) Morning | 2) Afternoon | 3) Night)]";
    }

    public void setTimeNumber(int timeNumber) {
        this.timeNumber = timeNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }
}
