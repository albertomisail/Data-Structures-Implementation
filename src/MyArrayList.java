public class MyArrayList<T> {
    private Object[] array;
    private int size;

    public MyArrayList(){
        this.array = new Object[1000];
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        if(this.size()==0) return true;
        return false;
    }

    public T get(int index){
        return (T) this.array[index];
    }

    public T set(int index, T obj){
        this.array[index] = obj;
        return obj;
    }

    public boolean add(T obj){
        if(this.array.length==this.size()){
            Object[] aux = new Object[this.size*2];
            for(int i = 0; i < this.size(); i++){
                aux[i] = this.get(i);
            }
            this.array = aux;
        }
        this.array[this.size()] = obj;
        this.size++;
        return true;
    }

    public void add(int index, T obj){
        Object[] aux = new Object[this.array.length];
        if(this.array.length==this.size) aux = new Object[this.size*2];
        for(int i = 0; i < index; i++){
            aux[i] = this.get(i);
        }
        aux[index] = obj;
        for(int i = index; i < this.size(); i++){
            aux[i + 1] = this.get(i);
        }
        this.array = aux;
        this.size++;
    }

    public int indexOf(T obj){
        for(int i = 0; i < this.size(); i++){
            if(this.get(i).equals(obj)) return i;
        }
        return -1;
    }

    public boolean contains(Object o){
        if(indexOf((T) o)==-1) return false;
        return true;
    }

    public T remove(int index){
        T result = this.get(index);
        for(int i = index + 1; i < this.size(); i++){
            this.set(i-1, this.get(i));
        }
        this.size--;
        return result;
    }

    public boolean remove(T obj){
        int index = this.indexOf(obj);
        if(index==-1) return false;
        this.remove(index);
        return true;
    }

    public MyArrayList<T> subList(int start, int end){
        MyArrayList<T> result = new MyArrayList<>();
        for(int i = start;  i < end; i++) result.add(this.get(i));
        return result;
    }

    public void clear(){
        this.array = new Object[1000];
        this.size = 0;
    }

    public Object[] toArray(){
        return this.array;
    }
}
