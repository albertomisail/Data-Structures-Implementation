import java.util.LinkedList;

public class MyLinkedList<T> {
    protected class Node<T>{
        private Node next;
        private T value;

        protected Node(){
            this.next = null;
            this.value = null;
        }

        protected Node(T value){
            this.next = null;
            this.value = value;
        }

        protected Node getNext(){
            return this.next;
        }

        protected void setNext(Node n){
            this.next = n;
        }

        protected T getValue(){
            return this.value;
        }

        protected void setValue(T value){
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size(){
        return this.size;
//       Node n = this.head;
//       int counter = 0;
//       while(n!=null){
//           n = n.getNext();
//           counter++;
//       }
//       return counter;
    }

    public boolean isEmpty(){
        if(this.size()==0) return true;
        return false;
//        if(this.head==null) return true;
//        return false;
    }

    private Node getNode(int index){
        int counter = 0;
        Node n = this.head;
        while(counter < index){
            n = n.getNext();
            counter++;
        }
        return n;
    }

    public T get(int index){
        return (T) this.getNode(index).getValue();
    }

    public boolean add(T value){
        Node n = new Node(value);
        if(this.isEmpty()){
            this.head = n;
            this.tail = n;
        }else{
            this.tail.setNext(n);
            this.tail = n;
        }
        this.size++;
        return true;
    }

    public void clear(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean contains(T value){
        Node n = this.head;
        while(n!=null){
            if(n.getValue().equals(value)){
                return true;
            }
            n = n.getNext();
        }
        return false;
    }

    public int indexOf(T value){
        int counter = 0;
        Node n = this.head;
        while(n != null){
            if(n.getValue().equals(value)) {
                return counter;
            }else{
                counter++;
                n = n.getNext();
            }
        }
        return -1;
    }

    public T remove(int index){
        Node toBeRemoved = this.getNode(index);
        T result = (T) toBeRemoved.getValue();
        if(index==0){
            this.head = toBeRemoved.getNext();
        }else{
            this.getNode(index-1).setNext(toBeRemoved.getNext());
        }
        this.size--;
        return result;
    }

    public boolean remove(T value){
        int index = this.indexOf(value);
        if(index==-1){
            return false;
        }
        Node toBeRemoved = this.getNode(index);
        if(index==0){
            this.head = toBeRemoved.getNext();
        }else{
            this.getNode(index-1).setNext(toBeRemoved.getNext());
        }
        this.size--;
        return true;
    }

    public T set(int index, T value){
        Node n = this.getNode(index);
        T result = (T) n.getValue();
        n.setValue(value);
        return result;
    }

    public LinkedList<T> subList(int start, int end){
        LinkedList<T> result = new LinkedList<>();
        int counter = 0;
        Node n = this.head;
        while(counter < end){
            if(counter>=start){
                result.add((T) n.getValue());
            }
            counter++;
            n = n.getNext();
        }
        return result;
    }
}
