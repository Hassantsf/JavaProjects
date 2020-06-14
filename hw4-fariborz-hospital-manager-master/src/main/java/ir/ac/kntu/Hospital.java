package ir.ac.kntu;

import ir.ac.kntu.logic.person.*;
import ir.ac.kntu.logic.room.Room;
import ir.ac.kntu.logic.room.Section;
import ir.ac.kntu.logic.room.Type;
import ir.ac.kntu.logic.user.User;
import ir.ac.kntu.tool.ScannerWrapper;
import ir.ac.kntu.tool.Shift;

import java.util.ArrayList;

public class Hospital {
    // Fields
    private String name;
    private String address;
    private int beds;
    private int basePriceOfRoom;
    private int basePriceOfVipRoom;
    private ArrayList<Doctor> doctors;
    private ArrayList<Nurse> nurses;
    private ArrayList<Patient> patients;
    private ArrayList<Room> rooms;
    private ArrayList<User> users;
    private ArrayList<Personnel> personnels;

    // Constructors
    public Hospital() {
        System.out.println("Creating new hospital: ");
        name = ScannerWrapper.getStringField("name");
        address = ScannerWrapper.getStringField("address");
        beds = ScannerWrapper.getIntField("number of beds");
        basePriceOfRoom = ScannerWrapper.getIntField("base price of ordinary room");
        basePriceOfVipRoom = ScannerWrapper.getIntField("base price of VIP room");
        doctors = new ArrayList<>();
        nurses = new ArrayList<>();
        patients = new ArrayList<>();
        rooms = new ArrayList<>();
        users = new ArrayList<>();
        personnels = new ArrayList<>();
        System.out.println("Operation was successful");
    }

    public Hospital(String name, String address, int beds, int priceOfRoom, int priceOfVipRoom) {
        setName(name);
        setAddress(address);
        setBeds(beds);
        setBasePriceOfRoom(priceOfRoom);
        setBasePriceOfVipRoom(priceOfVipRoom);
        doctors = new ArrayList<>();
        nurses = new ArrayList<>();
        patients = new ArrayList<>();
        rooms = new ArrayList<>();
        users = new ArrayList<>();
        personnels = new ArrayList<>();
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void setNurses(ArrayList<Nurse> nurses) {
        nurses = nurses;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    // Getters
    public String getName() {
        return name;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public ArrayList<Doctor> getAllDoctors() {
        return new ArrayList<Doctor>(doctors);
    }

    public ArrayList<Nurse> getAllNurses() {
        return new ArrayList<Nurse>(nurses);
    }

    public ArrayList<Patient> getAllPatients() {
        return new ArrayList<Patient>(patients);
    }

    public ArrayList<Room> getAllRooms() {
        return new ArrayList<Room>(rooms);

    }

    public ArrayList<Personnel> getAllPersonnels() {
        return new ArrayList<Personnel>(personnels);
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Address: " + address + '\n' +
                "beds: " + beds + '\n';
    }

    // Add Items Section
    public void addDoctor(Doctor newDoctor) {
        doctors.add(newDoctor);
        System.out.println("Your doctor add to data base successfully!");
    }

    public void addNurse(Nurse newNurse) {
        nurses.add(newNurse);
        System.out.println("Your nurse add to data base successfully!");
    }

    public void addPatient(Patient newPatient) {
        patients.add(newPatient);
        System.out.println("Your patient add to data base successfully!");
    }

    public void addRoom(Room newRoom) {
        rooms.add(newRoom);
        System.out.println("Your room add to data base successfully!");
    }

    public void addUser(User newUser) {
        users.add(newUser);
        System.out.println("Your user add to data base successfully!");
    }

    public void addPersonnel(Personnel newPersonnel) {
        personnels.add(newPersonnel);
        System.out.println("Your user add to data base successfully!");
    }

    // Change Items Section
    public void registerRoom(Room room, int index) {
        rooms.set(index, room);
    }

    public void registerDoctor(Doctor doctor, int index) {
        doctors.set(index, doctor);
    }

    public void registerNurse(Nurse nurse, int index) {
        nurses.set(index, nurse);
    }

    public void registerPatient(Patient patient, int index) {
        patients.set(index, patient);
    }
    // Delete Items Section

    // Delete Patient, Nurse and Doctor From Hospital
    public void deleteDNP(Object deletedItem) {
        if (deletedItem == null) {
            System.out.println("Item isn't available right now!");
        } else if (deletedItem instanceof Doctor) {
            doctors.remove(deletedItem);
            System.out.println("Your Doctor Deleted Successfully!");
        } else if (deletedItem instanceof Nurse) {
            nurses.remove(deletedItem);
            System.out.println("Your Nurse Deleted Successfully!");
        } else if (deletedItem instanceof Patient){
            patients.remove(deletedItem);
            System.out.println("Your Patient Deleted Successfully!");
        }
    }

    public void deleteRoom(Room room) {
        if (room == null) {
            System.out.println("Item isn't available right now!");
        } else {
            rooms.remove(room);
            System.out.println("Your Room Deleted Successfully!");
        }
    }

    public void deletePatientFromDoctorList(Patient patient, int id) {
        Doctor doctor = getDoctor(id);
        doctor.deletePatient(patient);
        System.out.println("Patient removed successfully!");
    }
    //Searching Section

    // For Searching Doctors, Nurses, Patients
    public int indexOfPND(int id, int choice) {
        switch (choice) {
            // For Doctor
            case 1:
                for (int i = 0; i < doctors.size(); i++) {
                    if (id == doctors.get(i).getId()) {
                        return i;
                    }
                }
                // For Nurse
            case 2:
                for (int i = 0; i < nurses.size(); i++) {
                    if (id == nurses.get(i).getId()) {
                        return i;
                    }
                }
                // For Patient
            case 3:
                for (int i = 0; i < patients.size(); i++) {
                    if (id == patients.get(i).getId()) {
                        return i;
                    }
                }

            default:
                System.out.println("Wrong Input");
                return -1;
        }
    }

    public int indexOfRoom(int numberOfRoom, Section section) {
        int result = -1;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getSection() == section && rooms.get(i).getNumber() == numberOfRoom) {
                return i;
            }
        }
        return -1;
    }

    // ---------------------------------------------------------------------------------------------
    // Utilities
    public Doctor getDoctor(int id) {
        int index = indexOfPND(id, 1);
        if (index == -1) {
            return null;
        } else {
            return doctors.get(index);
        }
    }

    public Nurse getNurse(int id) {
        int index = indexOfPND(id, 2);
        if (index == -1) {
            return null;
        } else {
            return nurses.get(index);
        }
    }

    public Patient getPatient(int id) {
        int index = indexOfPND(id, 3);
        if (index == -1) {
            return null;
        } else {
            return patients.get(index);
        }
    }

    public Room getRoom(int number, Section section) {
        int index = indexOfRoom(number, section);
        if (index == -1) {
            return null;
        } else {
            return rooms.get(index);
        }
    }

    public Room getRoom(Patient patient) {
        for (int i = 0; i < rooms.size(); i++) {
            ArrayList<Patient> patients = rooms.get(i).getAllPatients();
            for (int j = 0; j < patients.size(); j++) {
                if (patient.equals(patients.get(j))) {
                    return rooms.get(i);
                }
            }
        }

        return null;
    }

    public User getUser(String userName, String password) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getName().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public Worker getWorker(int id) {
        for (int i = 0; i < personnels.size(); i++) {
            Personnel personnel = personnels.get(i);
            if (personnel.getId() == id && personnel instanceof Worker) {
                return (Worker) personnel;
            }
        }
        return null;
    }

    public int choosingRoom(int patientId, boolean isVip) {
        int minCapacity = 0, index = 0;
        for (int i = 0; i < rooms.size(); i++) {
            int numberOfPatient = rooms.get(i).getAllPatients().size();
            if (numberOfPatient < minCapacity) {
                minCapacity = numberOfPatient;
                index = i;
            }
        }
        return rooms.get(index).getNumber();
    }

    public int getBasePriceOfRoom() {
        return basePriceOfRoom;
    }

    public void setBasePriceOfRoom(int basePriceOfRoom) {
        this.basePriceOfRoom = basePriceOfRoom;
    }

    public int getBasePriceOfVipRoom() {
        return basePriceOfVipRoom;
    }

    public void setBasePriceOfVipRoom(int basePriceOfVipRoom) {
        this.basePriceOfVipRoom = basePriceOfVipRoom;
    }
}
