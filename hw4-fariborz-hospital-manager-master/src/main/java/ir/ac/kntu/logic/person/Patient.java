package ir.ac.kntu.logic.person;

import ir.ac.kntu.Hospital;
import ir.ac.kntu.logic.room.Room;
import ir.ac.kntu.logic.room.Section;
import ir.ac.kntu.tool.DateTools;
import ir.ac.kntu.tool.ScannerWrapper;
import ir.ac.kntu.tool.SelectionList;

import java.util.Date;

public class Patient {
    // Fields
    private String name;
    private int id;
    private Section section;
    private Disease disease;
    private Apply typeOfApply;
    private Date confineDate;
    private boolean gender;
    private int age;
    private int caseNumber;
    private Insurance insurance;
    private Doctor doctor;
    private boolean relieved;

    // Constructors
    public Patient(Hospital hospital) {
        SelectionList list = new SelectionList();
        System.out.println("Creating new Patient: ");
        ScannerWrapper.getString();
        name = ScannerWrapper.getStringField("name");
        id = ScannerWrapper.getIntField("ID");
        age = ScannerWrapper.getIntField("age");
        caseNumber = ScannerWrapper.getIntField("case number");
        typeOfApply = list.chooseApply();
        if (typeOfApply == Apply.EMERGENCY) {
            section = Section.EMERGENCY;
        } else {
            section = list.chooseSection();
        }

        disease = list.chooseDisease();
        confineDate = new Date();
        gender = ScannerWrapper.getBoolField("Gender", "Male", "Female");
        int doctorId = ScannerWrapper.getIntField("doctor ID");
        doctor = hospital.getDoctor(doctorId);
        if (doctor == null) {
            System.out.println("Doctor isn't in hospital. You can change doctor later");
            doctor = null;
        }

        insurance = list.chooseInsurance();
    }

    public Patient(String name, Section section, Disease disease, Apply typeOfApply,
                   Insurance insurance, int id, int age, int caseNumber,
                   Doctor doctor, Date confineDate, boolean gender) {
        this.name = name;
        this.id = id;
        this.section = section;
        this.disease = disease;
        this.typeOfApply = typeOfApply;
        this.confineDate = confineDate;
        this.gender = gender;
        this.age = age;
        this.caseNumber = caseNumber;
        this.insurance = insurance;
        this.doctor = doctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Apply getTypeOfApply() {
        return typeOfApply;
    }

    public void setTypeOfApply(Apply typeOfApply) {
        this.typeOfApply = typeOfApply;
    }

    public Date getConfineDate() {
        return confineDate;
    }

    public void setConfineDate(Date confineDate) {
        this.confineDate = confineDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(int caseNumber) {
        this.caseNumber = caseNumber;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Patient: \n" +
                "name = '" + name + '\'' +
                " id = " + id +
                " section = '" + section + '\'' +
                " disease = '" + disease + '\'' +
                " typeOfApply = '" + typeOfApply + "'\n" +
                " confineDate = '" + confineDate + '\'' +
                " gender = '" + (gender ? "male" : "female") + '\'' +
                " age = " + age +
                " caseNumber = " + caseNumber +
                " insurance = '" + insurance.printInsurance() + '\'' +
                " doctor = " + doctor + '\'' + " Is Released: " + (relieved ? "Yes" : "No");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Patient patient = (Patient) o;

        return patient.id == this.id;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (section != null ? section.hashCode() : 0);
        result = 31 * result + (disease != null ? disease.hashCode() : 0);
        result = 31 * result + (typeOfApply != null ? typeOfApply.hashCode() : 0);
        result = 31 * result + (confineDate != null ? confineDate.hashCode() : 0);
        result = 31 * result + (gender ? 1 : 0);
        result = 31 * result + age;
        result = 31 * result + caseNumber;
        result = 31 * result + (insurance != null ? insurance.hashCode() : 0);
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        result = 31 * result + (relieved ? 1 : 0);
        return result;
    }

    public void changePatient(Hospital hospital) {
        SelectionList list = new SelectionList();
        System.out.println("Which part do you want to change: ");
        int choice = 1;
        while (choice != 0) {
            System.out.println("1) Name | 2) Section | 3) Disease\n 4) Type of apply | 5) Insurance | 6) Age\n" +
                    "7) Case number | 8) Gender | 9) Confine Date");
            choice = ScannerWrapper.getInt();
            switch (choice) {
                case 1:
                    ScannerWrapper.getString();
                    name = ScannerWrapper.getStringField("name");
                    System.out.println("Changed successfully!");
                    break;
                case 2:
                    section = list.chooseSection();
                    System.out.println("Changed successfully!");
                    break;
                case 3:
                    disease = list.chooseDisease();
                    System.out.println("Changed successfully!");
                    break;
                case 4:
                    typeOfApply = list.chooseApply();
                    System.out.println("Changed successfully!");
                    break;
                case 5:
                    insurance = list.chooseInsurance();
                    System.out.println("Changed successfully!");
                    break;
                case 6:
                    age = ScannerWrapper.getIntField("age");
                    System.out.println("Changed successfully!");
                    break;
                case 7:
                    caseNumber = ScannerWrapper.getIntField("case number");
                    System.out.println("Changed successfully!");
                    break;
                case 8:
                    gender = ScannerWrapper.getBoolField("Gender", "Male", "Female");
                    System.out.println("Changed successfully!");
                    break;
                case 9:
                    DateTools helper = new DateTools();
                    helper.changeDate(confineDate);
                    ScannerWrapper.getString();
                    System.out.println("Changed successfully!");
                    break;
                default:
                    break;
            }
        }

        hospital.registerPatient(this, hospital.indexOfPND(id, 3));
    }

    public boolean isRelieved() {
        return relieved;
    }

    public void setRelieved(boolean relieved) {
        relieved = relieved;
    }

    public void factorOfRelieve(int price) {
        DateTools date = new DateTools();
        int day = date.calculateDay(confineDate, new Date());
        int discount = getInsurance().getDiscount();
        System.out.println("Patient");
        System.out.println("-----------------------------------------");
        System.out.println("Name: " + getName());
        System.out.println("Section: " + getSection());
        System.out.println("Disease: " + getDisease());
        System.out.println("Type of Apply: " + getTypeOfApply());
        System.out.println("Confine Date: " + getConfineDate());
        System.out.println("Days of Confine: " + day);
        System.out.println("Price of room per Day: " + price);
        System.out.println("Discount:" + discount);
        System.out.println("Total Price: " + (day * price) * (100 - discount) / 100);
        System.out.println("-----------------------------------------");
        System.out.println("Do you want to relieve the patient: [1) Yes | 2) No]");
    }

    public void relievePatient(Hospital hospital) {
        Room room = hospital.getRoom(this);
        int basePrice = room.isVip() ? hospital.getBasePriceOfVipRoom() : hospital.getBasePriceOfRoom();
        int finalPrice = room.getPriceOfRoom(basePrice);
        factorOfRelieve(finalPrice);
        int choice = ScannerWrapper.getMenuItem(2);
        if (choice == 1) {
            int doctorId = getDoctor().getId();
            hospital.deletePatientFromDoctorList(this, doctorId);
            relieved = true;
        } else {
            return;
        }
    }
}
