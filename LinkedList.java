/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment1_ReyhanHosavci;

/**
 *
 * @author rgurleyen
 */
public class LinkedList {

    Node head;

    public LinkedList() {
        head = null;
    }

    void pushData(int location, int newData) {
        Node newNode = new Node(newData, location);
        Node temp = head;
        if (temp == null && location == 1) { // should start in location 1 
            head = newNode;
            head.location = 1;
            printMatrix();
            return;
        }
        int count = 1;
        while (temp != null) {
            if (temp.location == location) { //head.location==1
                while (temp.up != null) {
                    count++;
                    temp = temp.up;
                    temp.location = location;
                }
                temp.up = newNode;
                count++;
                checkColumns(location);
                printMatrix();
                if (count == 7) {
                    System.out.println("Game over");
                }
                return;
            } 
             
            else {
                if (temp.next == null) {
                    if (temp.location > location) { // location control to make list proper
                        Node tmp = head;
                        while (tmp != null) {
                            if (tmp.location + 1 == newNode.location) {
                                newNode.next = tmp.next;
                                tmp.next = newNode;
                                printMatrix();
                                checkColumns(location);
                                return;
                            }
                            tmp = tmp.next;
                        }
                    } else {
                        temp.next = newNode;
                        checkColumns(location);
                        printMatrix();
                        return;
                    }
                   
                } else {
                    temp = temp.next;
                }

            }
        }

    }

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(" (" + temp.location + ")" + temp.data + " >");
            int lp = temp.location;
            temp = temp.next;
            if (temp != null) {
                for (int i = 1; i < temp.location - lp; i++) {
                    System.out.print(" ()" + " >");
                }
            }
        }
        System.out.println("null");

    }

    public void printMatrix() {
        int[][] matrix = new int[7][5];
        Node temp = head;
        while (temp != null) {
            int i = 6;
            Node tmp = temp;
            while (i >= 0) {
                matrix[i][temp.location - 1] = tmp.data;
                if (tmp.up != null) {
                    tmp = tmp.up;
                    i--;
                    matrix[i][temp.location - 1] = tmp.data;
                } else {
                    break;
                }
            }
            temp = temp.next;
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("%1$-5s", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("**************");

    }

    
    public void checkColumns(int Location) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.location == Location) {
                prev = temp;
                while (temp.up != null) {
                    if (temp.data == temp.up.data) {
                        temp.data = 2 * temp.data;
                        temp.up = temp.up.up;
                        if (prev.data == temp.data && prev != temp) {
                            checkColumns(Location);
                        } else {
                            return;
                        }
                    } else {
                        prev = temp;
                        temp = temp.up;
                    }

                }
                return;
            } else {
                temp = temp.next;
            }
        }

    }
}
