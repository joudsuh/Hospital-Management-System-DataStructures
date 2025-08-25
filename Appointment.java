
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dshp;

/**
 *
 * @author maysamalhuthail
 */
public class Appointment implements Bill {

    private double time;
    private String illness;
    private int Num;
    private Doctor doctor;
    private Patient patient;

    public Appointment(double time, String illness, int Num, Doctor doctor, Patient patient) {
        this.time = time;
        this.illness = illness;
        this.Num = Num;
        this.doctor = doctor;
        this.patient = patient;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int Num) {
        this.Num = Num;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return doctor.AppointmentDisplay() + "\n" + patient + ", Appointment NUmber: " + Num + ", Appointment Time:" + time + ", Illness:" + illness;
    }

    public static void checkDoctor(String Speciality, Doctor array[]) {

        for (Doctor doctor : array) {
            if (Speciality.equals("Cardiologist")) {
                System.out.println(array[0].toString());
                return;
            }
            if (Speciality.equals("Dermatologist")) {
                System.out.println(array[1].toString());
                return;
            }
            if (Speciality.equals("psychaitrist")) {
                System.out.println(array[2].toString());
                return;
            }
            if (Speciality.equals("Paeditrician")) {
                System.out.println(array[3].toString());
                return;
            }
            if (Speciality.equals("Radiologist")) {
                System.out.println(array[4].toString());
                return;
            } else {
                System.out.println("we dont have the suitable doctor");
                return;
            }
        }

    }

    public static Doctor printDoctor(String n, Doctor array[]) {

        for (int i = 0; i < array.length; i++) {
            if (n.equals(array[i].getName())) {
                return array[i];
            }
        }

        return null;

    }

    @Override
    public double Total() {
        int priceOfRoom = 100;
        return priceOfRoom * doctor.getPrice() * (1 + TAX);
    }

    @Override
    public int getID() {
        return Num;
    }

}
