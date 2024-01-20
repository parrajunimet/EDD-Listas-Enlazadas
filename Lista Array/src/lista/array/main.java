/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista.array;

/**
 *
 * @author Juan Parra
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List list = new List(24);
        System.out.println("Insert Begin");
        for (int i = 0; i < 10; i++) {
            list.insertBegin(i);
        }
        list.print();
        System.out.println("Insert Final");
        for (int i = 0; i < 10; i++) {
            list.insertFinal(i);
        }
        list.print();
        System.out.println("Insert in Index");
        for (int i = 0; i < 5; i++) {
            list.insertInIndex(i, i+2);
        }
        list.print();
        System.out.println("Delete Begin");
        for (int i = 0; i < 5; i++) {
            list.deleteBegin();
        }
        list.print();
        System.out.println("Delete Final");
        for (int i = 0; i < 5; i++) {
            list.deleteFinal();
        }
        list.print();
        System.out.println("Delete in Index");
        for (int i = 0; i < 5; i++) {
            list.deleteInIndex(i+2);
        }
        list.print();
    }
    
}
