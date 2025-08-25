package dshp;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maysamalhuthail
 */
public class Patient extends Person {

    private int age;
    private String medicalhistory;

    public Patient(int age, String medicalhistory, String Name, int ID, String Sex) {
        super(Name, ID, Sex);
        this.age = age;
        this.medicalhistory = medicalhistory;
    }
    

    public Patient(int age, String Name, int ID, String Sex) {
        super(Name, ID, Sex);
        this.age = age;
    }

    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMedicalhistory() {
        return medicalhistory;
    }

    public void setMedicalhistory(String medicalhistory) {
        this.medicalhistory = medicalhistory;
    }

    public void displayMedicalHistory() {
        System.out.println("Medical history:" + getMedicalhistory());
        System.out.println(" ");

    }

    @Override
    public String toString() {
        return "Patient{" + "age=" + age + ", medicalhistory=" + medicalhistory + '}';
    }

}

