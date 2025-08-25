/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dshp;
 
import java.util.Scanner;

/**
 *
 * @author maysamalhuthail
 */
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Date;

public class DSHP {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        SinglyLinkedList<Person> s = new SinglyLinkedList<>();
        LLstack<Inventory> stack = new LLstack<>();
          LLstack<Room> roomstack = new LLstack<>();
        LLQueue q = new LLQueue();

        Doctor d1 = new Doctor("Cardiologist", 4, 700, "Dr.Yasmeen", 1001, "Female");
        Doctor d2 = new Doctor("Dermatologist", 4, 900, "Dr.Aroob", 1002, "Female");
        Doctor d3 = new Doctor("Psychaitrist", 4, 500, "Dr.Ahmed", 1003, "Male");
        Doctor d4 = new Doctor("Paeditrician", 4, 500, "Dr.Fahad", 1004, "Female");
        Doctor d5 = new Doctor("Radiologist", 4, 500, "Dr.Ghaliah", 1005, "Female");

        Doctor array[] = {d1, d2, d3, d4, d5};

        Nurse n1 = new Nurse(110, "night", "Ameena", 2001, "Female");
        Nurse n2 = new Nurse(120, "night", "sara", 2002, "Female");
        Nurse n3 = new Nurse(210, "night", "latifa", 2003, "Female");
        Nurse n4 = new Nurse(220, "night", "khalid", 2004, "Male");
        Nurse n5 = new Nurse(310, "Day", "omar", 2005, "Male");

        Room room1 = new Room(110, 3);
        Room room2 = new Room(120, 5);
        Room room3 = new Room(210, 5);
        Room room4 = new Room(220, 5);

        Inventory med1 = new Inventory("Aspirin", new Date(), 12, 1000, 15);
        Inventory med2 = new Inventory("Tylenol", new Date(), 16, 1001, 20);

        roomstack.push(room1);
        roomstack.push(room2);
        roomstack.push(room3);
        roomstack.push(room4);
        stack.push(med1);
        stack.push(med2);

        System.out.println("\t\tWelcome to PNU Hospital!!");

        int choice = 0;
        int num = 0;
        int PatientID = 0;

        do {
            try {
                System.out.println("\nPlease choose what you want to do :");
                System.out.println("1-Find Doctor \n"
                        + "2-Book Appointment\n"
                        + "3-Cancel Appointment\n"
                        + "4-Change Appointment Time\n"
                        + "5-Display Appointment\n"
                        + "6-Register as a new patient\n"
                        + "7-Display medical history\n"
                        + "8-Search Medical History\n"
                        + "9-find rooom with using ID\n"
                        + "10-Check Medication \n "
                        + "11-Generate Report\n"
                        + "12-Print Rooms and medications\n"
                        + "13-Exit");
                System.out.print("---------------------------------------------\n" + "Your  select  >>>  ");

                choice = input.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("please enter the specialty you need");
                        String specialty = input.next();
                        Appointment.checkDoctor(specialty, array);
                        break;
                    case 2:
                        System.out.println("""
                                       please enter your information
                                       the time :
                                       your illness:
                                       with the doctor:
                                       Patient Name: 
                                       age:
                                       Sex:""");
                        int t = input.nextInt();
                        String ill = input.next();
                        String doc = input.next();
                        String patientN = input.next();
                        int patientA = input.nextInt();
                        String patientS = input.next();
                        ++num;
                        ++PatientID;

                        Patient p = new Patient(patientA,ill ,patientN, PatientID, patientS);

                        Doctor ddd = Appointment.printDoctor(doc, array);
                        Appointment appo = new Appointment(t, ill, num, ddd, p);

                        q.BookAppointment(appo);
                        s.addFirst(p);

                        break;
                    case 3:
                        System.out.println("please enter your appointment number :");
                        int appnum = input.nextInt();

                        q.cancelAppointment(appnum);
                        break;

                    case 4:
                        System.out.println("please enter your appointment number to change your time:");
                        int appcha = input.nextInt();
                        System.out.println("enter the time you want ");
                        double newT = input.nextInt();
                        q.changeAppointmentTime(appcha, newT);
                        break;
                    case 5:
                        System.out.println("please enter your appointment number :");
                        int an = input.nextInt();
                        q.DisplayMyAppointment(an);
                        break;
                    case 6:
                        System.out.println("please enter your information\n"
                                + "age :\n"
                                + "name :\n"
                                + "ID:\n"
                                + "sex:\n");
                        int a1 = input.nextInt();
                        String n = input.next();
                        int i = input.nextInt();
                        String ps = input.next();

                        Patient newP = new Patient(a1, n, i, ps);
                        
                        System.out.print("you are now registered!");
                        break;

                    case 7:
                        s.Displaymedicalhistory();
                        System.out.println("");
                        break;
                    case 8:
                        System.out.println("what is the condition you are looking for ");
                        String MC = input.next();
                        System.out.print( s.SearchMedicalCodition(MC));
                        System.out.println("");
                        break;

                    case 9:
                        System.out.print("Enter ID to search your room: ");
                        int searchId = input.nextInt();
                        Bill found = roomstack.search(searchId);
                        if (found != null) {
                            System.out.println("Found: " + found);
                        } else {
                            System.out.println("No element with ID " + searchId + " found.");
                        }
                        break;
                        
                    case 10:
                        System.out.print("Enter medication ID to check: ");
                        int inventoryId = input.nextInt();
                       Inventory k = new Inventory(inventoryId);
                       
                        stack.check(k);

                        break;
                    case 11:

                        stack.generateReport();
                        break;
                    case 12:
                        stack.printStack();
                        roomstack.printStack();
                        break;

                    case 13:
                        break;
                    default:
                        System.out.println("Invalid option!");
                        System.out.print("please enter one of the exiting options.");

                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input");
                input.next();

            }

        } while (choice != 13);

    }
}
