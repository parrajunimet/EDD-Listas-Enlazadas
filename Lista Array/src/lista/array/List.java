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
public class List implements ListInterface{

    private Integer head;
    private int size, maxSize;
    private Nodo[] array;
    
    public List(int maxSize) {
        this.head = null;
        this.size = 0;
        this.maxSize = maxSize;
        this.array = new Nodo[0];
    }

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public Nodo[] getArray() {
        return array;
    }

    public void setArray(Nodo[] array) {
        this.array = array;
    }
    
    @Override
    public void insertBegin(Object element) {
        Nodo nodo = new Nodo(element);
        if(isEmpty()){
                setArray(amplifyArray());
                array[array.length - 1] = nodo;
                setHead(array.length - 1);
                size ++;
        } else{
            if(searchEmpty() == -1){
                if(maxSize > array.length){
                    int oldHead = getHead();
                    setArray(amplifyArray());
                    array[array.length - 1] = nodo;
                    setHead(array.length - 1);
                    array[array.length-1].setNext(oldHead);
                    size ++;
                }else {
                    System.out.println("Max Index Reached");
                }
            } else{
                int oldHead = getHead();
                array[searchEmpty()] = nodo;
                setHead(searchEmpty());
                array[searchEmpty()].setNext(oldHead);
                size ++;
            }
        }
    }

    @Override
    public void insertFinal(Object element) {
        Nodo nodo = new Nodo(element);
        if(isEmpty()){
                setArray(amplifyArray());
                array[array.length - 1] = nodo;
                setHead(array.length - 1);
                size ++;
        } else{
            if(searchEmpty() == -1){
                if(maxSize > array.length){
                    setArray(amplifyArray());
                    Integer pointer = getHead();
                    while(array[pointer].getNext() != null){
                        pointer = array[pointer].getNext();
                    }
                    array[array.length - 1] = nodo;
                    array[pointer].setNext(array.length - 1);
                    size ++;
                }else {
                    System.out.println("Max Index Reached");
                }
            } else{
                Integer pointer = getHead();
                while(array[pointer].getNext() != null){
                    pointer = array[pointer].getNext();
                }
                array[searchEmpty()] = nodo;
                array[pointer].setNext(searchEmpty());
                size ++;
            }
        }
    }

    @Override
    public void insertInIndex(Object element, int index) {
        Nodo nodo = new Nodo(element);
        if(index > array.length || index < 0){
            System.out.println("Not valid index");
        } else {
            if (index == 0){
                insertBegin(element);
            }else{
                Integer pointer = getHead();
                for (int i = 0; i < index -1; i++) {
                    pointer = array[pointer].getNext();
                }
                nodo.setNext(array[pointer].getNext());
                int position;
                if(searchEmpty() == -1){
                    if(maxSize > array.length){
                        setArray(amplifyArray());
                        position = array.length-1;
                        array[position] = nodo;
                        array[pointer].setNext(position);
                        size ++;
                    } else {
                        System.out.println("Max Reached");
                    }
                }else {
                    position = searchEmpty();
                    array[position] = nodo;
                    array[pointer].setNext(position);
                    size ++;
                }
            }

        }
    }

    @Override
    public Object deleteBegin() {
        if(isEmpty()){
            System.out.println("Empty Arrray");
        } else {
            int oldHead = getHead();
            Object deleted = array[oldHead].getElement();
            setHead(array[oldHead].getNext());
            array[oldHead] = null;
            size --;
            return deleted;
        }
        return null;
    }

    @Override
    public Object deleteFinal() {
        if(isEmpty()){
            System.out.println("Empty Arrray");
        } else {
            if(array.length > 1){
                Integer pointer = getHead();
                while(array[array[pointer].getNext()].getNext() != null){
                    pointer = array[pointer].getNext();
                }
                Object deleted = array[array[pointer].getNext()].getElement();
                array[array[pointer].getNext()] = null;
                array[pointer].setNext(null);
                size--;
                return deleted;
            } else {
                return deleteBegin();
            }
        }
        return null;
    }

    @Override
    public Object deleteInIndex(int index) {
        if(index > array.length || index < 0){
            System.out.println("Not valid index");
        } else {
            if (index == 0){
                return deleteBegin();
            }else{
                Integer pointer = getHead();
                Integer pointer2 = 0; 
                Object deleted;
                for (int i = 0; i < index -1; i++) {
                    pointer = array[pointer].getNext();
                }
                pointer2 = array[pointer].getNext();
                deleted = array[pointer2].getElement();
                array[pointer].setNext(array[pointer2].getNext());
                array[pointer2] = null;
                size --;
                return deleted;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return getHead() == null;
    }
    
    public Nodo[] amplifyArray() {
        Nodo[] newArray = new Nodo[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    public int searchEmpty(){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null){
                return i;
            }
        }
        return -1;
    }


    @Override
    public void print() {
        Integer pointer = getHead();
        int aux = 0;
        while(pointer != null){
            System.out.println( aux + "._ " + "[" + array[pointer].getElement() + "]");
            pointer = array[pointer].getNext();
            aux ++;
        }
    }

}


