/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dshp;

/**
 *
 * @author maysamalhuthail
 */
public class Person {

    private String Name;
    private int ID;
    private String Sex;

    public Person(String Name, int ID, String Sex) {
        this.Name = Name;
        this.ID = ID;
        this.Sex = Sex;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    @Override
    public String toString() {
        return "Name:" + Name + ", ID:" + ID + ", Sex:" + Sex;
    }

}
