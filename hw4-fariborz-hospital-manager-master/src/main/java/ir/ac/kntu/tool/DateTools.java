package ir.ac.kntu.tool;

import java.util.Date;

public class DateTools {
    public void changeDate(Date oldDate) {
        System.out.println("Changing Date!\n");
        int year = 1970, month = 0, day = 1;
        while (!isValidDate(year, month, day)) {
            year = ScannerWrapper.getIntField("year");
            month = ScannerWrapper.getIntField("month");
            day = ScannerWrapper.getIntField("day");
            if (isValidDate(year, month, day)) {
                System.out.println("Your Date Has Been Approved!");
            } else {
                System.out.println("Try Again!");
            }
        }
        oldDate.setYear(year - 1900);
        oldDate.setMonth(month - 1);
        oldDate.setDate(day);
        System.out.println("Your Change Was Successful!");
    }

    public boolean isValidDate(int year, int month, int day) {
        boolean result = true;
        if (year < 1970 || year > 2030) {
            result = false;
        }

        if (month < 1 || month > 12) {
            result = false;
        }

        if (day < 1 || day > 31) {
            result = false;
        }

        return result;
    }

    public int calculateDay(Date dateBefore, Date dateAfter) {
        long difference = dateAfter.getTime() - dateBefore.getTime();
        long daysBetween = (difference / (1000*60*60*24));
        return (int) daysBetween;
    }
}
