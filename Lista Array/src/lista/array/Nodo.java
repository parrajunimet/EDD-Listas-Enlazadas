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
public class Nodo {
    private Object element;
    private Integer next;

    public Nodo(Object element) {
        this.element = element;
        this.next = null;
    }
    
    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }
    
    
    
}
