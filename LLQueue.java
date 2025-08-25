/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dshp;

/**
 *
 * @author maysamalhuthail
 */
public class LLQueue<E> {

    static class Node<E> {

        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public void setelement(E element) {
            this.element = element;
        }
    }
    protected Node<E> front;
    protected Node<E> rear;
    protected int size;

    public LLQueue() { // constructor
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { // returns (but does not remove) the first element
        if (isEmpty()) {
            return null;
        }
        return front.getElement();
    }

    public E last() { // returns (but does not remove) the last element
        if (isEmpty()) {
            return null;
        }
        return rear.getElement();
    }

    public void enqueue(E elem) {
        Node<E> newest = new Node<E>(elem, null);
        if (isEmpty()) {
            front = newest; // special case of a previously empty queue 
        } else {
            rear.setNext(newest); // add node at the tail of the list 
        }
        rear = newest; // update the reference to the tail node 
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = front.getElement();
        front = front.getNext();
        size--;
        if (size == 0) {
            rear = null; // the queue is now empty
        }
        return answer;
    }

    public void Display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        int s = size();

        for (int i = 0; i < s; i++) {
            E ele = dequeue();
            System.out.println(ele);

            enqueue(ele);
        }
    }

    public void BookAppointment(E appointment) {
        enqueue(appointment);
        System.out.println("Appointment booked: " + appointment);
    }

    public Appointment cancelAppointment(int appointmentNum) {

        if (isEmpty()) {
            System.out.println("Queue is empty ,  There is no appointment to cancel");
            return null;
        }

        Appointment apppoooo = null;
        int size = size();
        for (int i = 0; i < size; i++) {
            Appointment aaa = (Appointment) dequeue();

            if (aaa.getNum() == appointmentNum) {
                apppoooo = aaa;
                System.out.println("Appointment with the number " + appointmentNum + " have been canceled");
            } else {
                enqueue((E) aaa);

            }
        }
        if (apppoooo == null) {
            System.out.println("Appointment with the number " + appointmentNum + " have been not found");
        }
        return apppoooo;

    }

    public Appointment DisplayMyAppointment(int appointmentNum) {

        LLQueue<Appointment> temp = new LLQueue<>();
        if (isEmpty()) {
            System.out.println("Queue is empty ,  There is no appointment to display");
            return null;
        }

        Appointment app = null;
        int size = size();
        for (int i = 0; i < size; i++) {
            Appointment a = (Appointment) dequeue();

            temp.enqueue(a);
        }

        for (int i = 0; i < size; i++) {
            Appointment b = (Appointment) temp.dequeue();

            if (b.getNum() == appointmentNum) {
                app = b;
                System.out.println("Appointment with the number " + appointmentNum + " will now be shown:\n" + b.toString());
            }
            enqueue((E)b);
        }

        System.out.println("This appointment doesnt exisit");
        return null;
    }

    public Appointment changeAppointmentTime(int appointmentNum, double time) {
   
    LLQueue<Appointment> temp = new LLQueue<>();

    if (isEmpty()) {
        System.out.println("Queue is empty. There are no appointments to change.");
        return null; 
    }

    Appointment newapp = null;
    int size = size(); 

   
    for (int i = 0; i < size; i++) {
        Appointment v; 
        v = (Appointment)dequeue();
        
        if (v.getNum() == appointmentNum) {
           
            v.setTime(time);
            newapp = v; 
            System.out.println("Appointment with the number " + appointmentNum + " has been updated to new time: " + time);
        }

     
        temp.enqueue(v);
    }

   
    while (!temp.isEmpty()) {
        enqueue((E)temp.dequeue());
    }

    
    if (newapp == null) {
        System.out.println("Appointment with the number " + appointmentNum + " was not found.");
    }

    
    return newapp;
}

}












