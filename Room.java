/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dshp;

/**
 *
 * @author maysamalhuthail
 */
public class Room implements Bill {

    private int roomNum;
    private int days;

    public Room(int roomNum, int days) {
        this.roomNum = roomNum;
        this.days = days;
    }

    public Room(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public double Total() {
        int priceOfRoom = 100;
        return priceOfRoom * getDays() * (1 + TAX);
    }

    @Override
    public String toString() {
        return "Room{" + "roomNum=" + roomNum + ", days=" + days + '}';
    }

    @Override
    public int getID() {
        return roomNum ; }
}

