/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dshp;
import java.util.Date;
/**
 *
 * @author maysamalhuthail
 */
public class Inventory implements Bill {

    private String MedName;
    private Date Exdate;
    private int AgeAppropriate;
    private int id;
    private int price;
    private static int count = 1000;

    public Inventory(String MedName, Date Exdate, int AgeAppropriate, int id, int price) {
        this.MedName = MedName;
        this.Exdate = Exdate;
        this.AgeAppropriate = AgeAppropriate;
        this.price = price;
        this.id = count++;
    }

    public Inventory(int id) {
        this.id = id;
    }

    

    
    public String getMedName() {
        return MedName;
    }

    public void setMedName(String MedName) {
        this.MedName = MedName;
    }

    public Date getExdate() {
        return Exdate;
    }

    public void setExdate(Date Exdate) {
        this.Exdate = Exdate;
    }

    public int getAgeAppropriate() {
        return AgeAppropriate;
    }

    public void setAgeAppropriate(int AgeAppropriate) {
        this.AgeAppropriate = AgeAppropriate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public double Total() {
        return getPrice() * (1 + TAX);
    }

    @Override
    public int getID() {
        return id;
    }

    public double calcDosage(int AgeAppropriate) {
        if (AgeAppropriate < 5) {
            return 2.5;
        } else if (AgeAppropriate >= 5 && AgeAppropriate < 12) {
            return 5.0;
        } else if (AgeAppropriate >= 12 && AgeAppropriate < 18) {
            return 7.5;
        } else {
            return 10.0;
        }
    }

    @Override
    public String toString() {
        return "Inventory{" + "MedName=" + MedName + ", Exdate=" + Exdate + ", \nAgeAppropriate=" + AgeAppropriate + ", id=" + id + ", price=" + price + '}';
    }

}

