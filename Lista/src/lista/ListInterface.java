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
public interface ListInterface {
    public void insertBegin(Object element);
    public void insertFinal(Object element);
    public void insertInIndex(Object element, int index);
    public Object deleteBegin();
    public Object deleteFinal();
    public Object deleteInIndex(int index);
    public boolean isEmpty();
    public int length();
    public void print();
}
