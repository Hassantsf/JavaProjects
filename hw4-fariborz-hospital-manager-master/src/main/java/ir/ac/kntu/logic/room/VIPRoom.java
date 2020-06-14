package ir.ac.kntu.logic.room;

import ir.ac.kntu.Hospital;

public class VIPRoom extends Room {
    private Facility bed;
    private Facility phone;

    public VIPRoom(Hospital hospital) {
        super(true, hospital);
        setBed(new Facility(Type.BED));
        setPhone(new Facility(Type.PHONE));
    }

    public Facility getBed() {
        return bed;
    }

    public void setBed(Facility bed) {
        this.bed = bed;
    }

    public Facility getPhone() {
        return phone;
    }

    public void setPhone(Facility phone) {
        this.phone = phone;
    }

    @Override
    public int getPriceOfRoom(int baseVipPrice) {
        int percentOfIncrement = (getAllBeds().size() - 1) * 10;
        if (getFridge() != null) {
            percentOfIncrement += 10;
        }
        if (getTv() != null) {
            percentOfIncrement += 15;
        }
        if (getCooler() != null) {
            percentOfIncrement += 5;
        }
        if (phone != null) {
            percentOfIncrement += 5;
        }

        return baseVipPrice * percentOfIncrement / 100;
    }
}
