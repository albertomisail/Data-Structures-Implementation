import java.util.EmptyStackException;

public class MyStack<T> {
    private MyArrayList<T> stackInternal;

    public MyStack(){
        this.stackInternal = new MyArrayList<T>();
    }

    public boolean isEmpty(){
        return this.stackInternal.isEmpty();
    }

    public void push(T obj){
        this.stackInternal.add(obj);
    }

    public T pop() throws EmptyStackException {
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        return this.stackInternal.remove(this.stackInternal.size()-1);
    }

    public T peek() throws EmptyStackException{
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        return this.stackInternal.get(this.stackInternal.size()-1);
    }
}
