/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment1_ReyhanHosavci;

/**
 *
 * @author rgurleyen
 */
public class Main {

    public static void main(String args[]) {

        int[][] data = {{1, 2}, {4, 2}, {2, 4}, {3, 2}, {5, 4}, {2, 2}, {5, 4}, {1, 8}, {1, 8}, {2, 32}, {3, 2},
        {3, 64}, {4, 16}, {2, 64}, {3, 32}, {1, 16}, {5, 16}, {3, 32}, {2, 64}, {4, 8}, {4, 4}, {4, 2}, {4, 2}, 
        {2, 2}, {3, 64}, {3, 32}, {3, 16}, {3, 8}, {3, 8},{2,4},{2,8}};
        LinkedList list = new LinkedList();

        for (int i = 0; i < data.length; i++) {
            System.out.println("Location: " + data[i][0] + " Data: " + data[i][1]);
            list.pushData(data[i][0], data[i][1]);
        }

    }
}
