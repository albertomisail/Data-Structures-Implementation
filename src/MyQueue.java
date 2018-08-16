import java.util.NoSuchElementException;

public class MyQueue<T> {
    protected class Node{
        private T value;
        private Node next;

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

    public MyQueue(){
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty(){
        if(this.head==null) return true;
        return false;
    }

    public void add(T obj){
        if(this.isEmpty()){
            this.head = new Node(obj);
            this.tail = this.head;
        }else{
            Node n = new Node(obj);
            this.tail.setNext(n);
            this.tail = n;
        }
    }

    public T remove() throws NoSuchElementException{
        if(this.isEmpty()) throw new NoSuchElementException();
        T result = this.head.getValue();
        this.head = this.head.getNext();
        if(this.isEmpty()){
            this.tail = null;
        }
        return result;
    }

    public T peek() throws NoSuchElementException{
        if(this.isEmpty()) throw new NoSuchElementException();
        return this.head.getValue();
    }
}
