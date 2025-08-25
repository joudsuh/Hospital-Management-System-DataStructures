package dshp;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maysamalhuthail
 */
public class Doctor extends Person {

    private String Speciality;
    private int YearOfExperience;
    private double price;

    public Doctor(String Speciality, int YearOfExperience, double price, String Name, int ID, String Sex) {
        super(Name, ID, Sex);
        this.Speciality = Speciality;
        this.YearOfExperience = YearOfExperience;
        this.price = price;
    }
    
    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String Speciality) {
        this.Speciality = Speciality;
    }

    public int getYearOfExperience() {
        return YearOfExperience;
    }

    public void setYearOfExperience(int YearOfExperience) {
        this.YearOfExperience = YearOfExperience;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    public String AppointmentDisplay() {
        return "\nWith" + getName() + ": ,Doctor ID:" + getID() + " Sex:" + getSex() + " \nSpeciality:" + Speciality + ", Years Of Experience:" + YearOfExperience;
    }

    @Override
    public String toString() {
        return "\nDoctor Name: " + getName() + " ID:" + getID() + " Sex:" + getSex() + "\nSpeciality:" + Speciality + " Years Of Experience:" + YearOfExperience;
    }



    }

