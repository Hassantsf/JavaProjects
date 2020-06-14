package ir.ac.kntu.logic.person;

import ir.ac.kntu.logic.room.Facility;
import ir.ac.kntu.tool.Shift;

import java.util.HashMap;
import java.util.Map;

public class Worker extends Personnel {
    private Map<Shift, Facility> schedule;

    public Worker() {
        super();
        schedule = new HashMap<>();
    }

    public void addToSchedule(Facility facility, Shift shift) {
        Shift nearestShift = getNearestShift(shift);
        if (nearestShift == null) {
            System.out.println("Worker don't have time!");
        } else {
            schedule.put(nearestShift, facility);
            System.out.println("");
        }
    }

    public void removeFromSchedule(Shift shift) {
        schedule.remove(shift);
        System.out.println("Facility Fixed!!!");
    }

    private Shift getNearestShift(Shift suggestedShift) {
        int dayNumber = suggestedShift.getDayNumber();
        int timeNumber = suggestedShift.getTimeNumber();

        for (int i = 1; i <= 7; i++) {
            for (int j = 0; j <= 3; j++) {
                if (dayNumber == 7) {
                    dayNumber = 1;
                }
                if (timeNumber == 3) {
                    dayNumber = 1;
                }

                Shift shift = new Shift(dayNumber, timeNumber);
                if (getAllShifts().contains(shift) && !schedule.containsKey(shift)) {
                    return shift;
                }
            }
        }

        return null;
    }
}
