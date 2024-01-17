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
public class List implements ListInterface{
    
    private Nodo head;
    private int size;

    public List() {
        this.head = null;
        this.size = 0;
    }
    
    @Override
    public void insertBegin(Object element) {
        Nodo nodo = new Nodo(element);
        if(isEmpty()){
            setHead(nodo);
        } else{
            nodo.setNext(getHead());
            setHead(nodo);
        }
        size ++;
    }

    @Override
    public void insertFinal(Object element) {
        Nodo nodo = new Nodo(element);
        if(isEmpty()){
            setHead(nodo);
        }else{
            Nodo pointer = getHead();
            while(pointer.getNext() != null){
                pointer = pointer.getNext();
            }
            pointer.setNext(nodo);
        }
        size++;
    }

    @Override
    public void insertInIndex(Object element, int index) {
        Nodo nodo = new Nodo(element);
        Nodo pointer = getHead();
        if(index > length()){
            System.out.println("Índice no válido");
        }else{
            if (index == 0){
                insertBegin(element);
            }else{                
                for (int i = 0; i < (index-1) ; i++) {
                    pointer = pointer.getNext();
                }
                nodo.setNext(pointer.getNext());
                pointer.setNext(nodo);
                size ++;
            }
        }
    }

    @Override
    public Object deleteBegin() {
        if(isEmpty()){
            System.out.println("No Hay Elementos en la lista");
        } else{
            Nodo pointer = getHead();
            setHead(pointer.getNext());
            pointer.setNext(null);
            size --;
            return pointer.getElement();
        }
        size --;
        return null;
    }

    @Override
    public Object deleteFinal() {
        if(isEmpty()){
            System.out.println("No Hay Elementos en la lista");
        }else{
            Nodo pointer = getHead();
            if(pointer.getNext() == null){
                setHead(null);
                size--;
                return pointer.getElement();
            }else {
                while(pointer.getNext().getNext() != null){
                    pointer = pointer.getNext();
                }
                Object pointer2 = pointer.getNext().getElement();
                pointer.setNext(null);
                size--;
                return pointer2;
            }            
        }
        return null;
    }

    @Override
    public Object deleteInIndex(int index) {
        Nodo pointer = getHead();
        Nodo pointer2;
        if(index > length()){
            System.out.println("Índice no válido");
        }else{
            if (index == 0){
                deleteBegin();
            }else{                
                for (int i = 0; i < (index-1) ; i++) {
                    pointer = pointer.getNext();
                }
                pointer2 = pointer.getNext();
                pointer.setNext(pointer2.getNext());
                pointer2.setNext(null);
                size --;
                return pointer2.getElement();
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return getHead() == null;
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    @Override
    public void print() {
        Nodo pointer = getHead();
        int aux = 0;
        while(pointer != null){
            System.out.println(aux + "._ [" + pointer.getElement() + "]");
            aux ++;
            pointer = pointer.getNext();
        }
    }

    @Override
    public int length() {
        Nodo pointer = getHead();
        int aux = 0;
        while(pointer != null){
            pointer = pointer.getNext();
            aux ++;
        }
        return aux;
    }
    
}
