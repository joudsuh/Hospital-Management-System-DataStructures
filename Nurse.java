/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dshp;

/**
 *
 * @author maysamalhuthail
 */
public class Nurse extends Person{
   
    private Room room;
    private String Shift;

    public Nurse(int roomNum, String Shift, String Name, int ID, String Sex) {
        super(Name, ID, Sex);
        this.room = new Room(roomNum);
        this.Shift = Shift;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getShift() {
        return Shift;
    }

    public void setShift(String Shift) {
        this.Shift = Shift;
    }

    @Override
    public String toString() {
        return "Room:" + room + ", Shift:" + Shift;
    }
    
    
    
    
}