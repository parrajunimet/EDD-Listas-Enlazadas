/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author Juan Parra
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Listas");
        List list = new List();
        System.out.println("Insert Begin");
        for (int i = 0; i < 10; i++) {
            list.insertBegin(i);
        }
        list.print();
        System.out.println("Insert Final");
        for (int i = 0; i < 10; i++) {
            list.insertFinal(i);
        }
        System.out.println("Insert In Index: 9");
        list.insertInIndex(100, 10);
        list.print();
        System.out.println("Delete Begin");
        list.deleteBegin();
        list.print();
        System.out.println("Delete Final");
        list.deleteFinal();
        list.print();
        System.out.println("Delete In Index: 9");
        list.deleteInIndex(9);
        list.print();
    }
    
}
