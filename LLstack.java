/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dshp;

/**
 *
 * @author maysamalhuthail
 */
public class LLstack<E> {
    //-------------------------------- Node Class --------------------------------------- 

    static class Node<E> {

        private E element;
        private Node<E> next;

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
    //-------------------------------- End Node Class ---------------------------------------

    private Node<E> top;
    private int size;

    public LLstack() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E top() {
        if (isEmpty()) {
            return null;
        }
        return top.getElement();
    }

    public void push(E elem) {
        Node<E> v = new Node<E>(elem, top);
        top = v;
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E temp = top.getElement();
        top = top.getNext();
        size--;
        return temp;
    }

    // 1. Check if an element exists in the stack
//     public void check(Inventory element) {
//    LLstack<Inventory> temp = new LLstack<>();
//    boolean found = false;
//
//    
//    int x = element.getId();
//    // Check if the stack is empty
//    while (!isEmpty()) {
//        Inventory ele = (Inventory)pop(); 
//        
//        int p = ele.getId();
//        if (x== p) {
//            found = true;
//            System.out.println("Element " + ele + " is found in the stack.");
//        }
//
//        // Push the element into the temporary stack
//        temp.push(ele);
//    }
//
//    // Restore the original stack from the temporary stack
//    while (!temp.isEmpty()) {
//        push((E)temp.pop());
//    }
//
//    // If element was not found, print a message
//    if (!found) {
//        System.out.println("Element with the id" + x + " is not found in the stack.");
//    }
//
//   
//}
    
    public void check(Inventory element) {
    LLstack<Inventory> temp = new LLstack<>();
    boolean found = false;

    int x = element.getId(); // Get the ID to check
    
    // Check if the stack is empty
    while (!isEmpty()) {
        Inventory ele = (Inventory)pop(); // Pop the element from the stack
        
        // Compare the IDs of the popped element and the input element
        if (x == ele.getId()) {
            found = true;
            System.out.println("Element " + ele + " is found in the stack.");
        }

        // Push the element into the temporary stack
        temp.push(ele);
    }

    // Restore the original stack from the temporary stack
    while (!temp.isEmpty()) {
        push((E)temp.pop()); // No cast needed here as temp holds Inventory objects
    }

    // If the element was not found, print a message
    if (!found) {
        System.out.println("Element with the ID " + x + " is not found in the stack.");
    }
}

    // 2. Search for an element by its ID (assuming elements implement Bill interface)
    public E search(int id) {
        LLstack temp = new LLstack();
        E foundElement = null;

        while (!isEmpty()) {
            E ele = (E) pop();
            if (ele instanceof Bill) {
                Room bill = (Room) ele;
                if (bill.getID() == id) {
                    foundElement = ele;
//                    System.out.println("Element with ID " + id + " is found.");
                }
            }
            temp.push(ele);
        }

        while (!temp.isEmpty()) {
            push((E) temp.pop());
        }

//        if (foundElement == null) {
//            System.out.println("Element with ID " + id + " is not found.");
 //       }

        return foundElement;
    }

    // 4. Generate a report of all items in the stack
    public void generateReport() {
        double totalRoomCost = 0;
        double totalInventoryCost = 0;
        int roomCount = 0;
        int inventoryCount = 0;

        LLstack temp = new LLstack();

        while (!isEmpty()) {
            E element = (E) pop();

            if (element instanceof Room) {
                Room room = (Room) element;
                double roomTotal = room.Total();
                totalRoomCost += roomTotal;
                roomCount++;
                System.out.println("Room ID: " + room.getID() + " | Cost: " + roomTotal);
            } else if (element instanceof Inventory) {
                Inventory inventory = (Inventory) element;
                double inventoryTotal = inventory.Total();
                totalInventoryCost += inventoryTotal;
                inventoryCount++;
                System.out.println("Inventory Item: " + inventory.getMedName() + " | ID: " + inventory.getID() + " | Cost: " + inventoryTotal);
            }

            temp.push(element);
        }

        while (!temp.isEmpty()) {
            push((E) temp.pop());
        }

        System.out.println("\n--- Summary Report ---");
        System.out.println("Total Rooms: " + roomCount + " | Total Room Cost: " + totalRoomCost);
        System.out.println("Total Inventory Items: " + inventoryCount + " | Total Inventory Cost: " + totalInventoryCost);
        System.out.println("-----------------------");
    }

    // 3. Display all elements in the stack
    public void printStack() {
        LLstack temp = new LLstack();

        System.out.println("--- Stack Elements ---");

        while (!isEmpty()) {
            E element = (E) pop();
            System.out.println(element);
            temp.push(element);
        }

        while (!temp.isEmpty()) {
            push((E) temp.pop());
        }

        System.out.println("-----------------------");
    }
}


