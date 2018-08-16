public class MyString {
    private final char[] array;

    private char[] getArray(){
        return this.array;
    }

    public MyString(char[] str){
        this.array = str;
    }

    public int length(){
        return this.array.length;
    }

    public char[] toCharArray(){
        return this.array.clone();
    }

    public char charAt(int index){
        return this.array[index];
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(!(o instanceof String)){
            return false;
        }
        String s = (String) o;
        if(this.length()!=s.length()){
            return false;
        }
        for(int i = 0; i < this.length(); i++){
            if(this.charAt(i)!=s.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public MyString toUpperCase(){
        char[] arr = new char[this.length()];
        for(int i = 0; i < this.length(); i++){
            arr[i] = Character.toUpperCase(this.charAt(i));
        }
        return new MyString(arr);
    }

    public MyString toLowerCase(){
        char[] arr = new char[this.length()];
        for(int i = 0; i < this.length(); i++){
            arr[i] = Character.toLowerCase(this.charAt(i));
        }
        return new MyString(arr);
    }

    public MyString substring(int start, int end){
        int length = end - start;
        char[] arr = new char[length];
        for(int i = start; i < end; i++){
            arr[i-start] = this.charAt(i);
        }
        return new MyString(arr);
    }

    public MyString trim(){
        int start = 0;
        for(int i = 0; i < this.length(); i++){
            if(this.charAt(i)!=' '){
                start = i;
                break;
            }
        }
        int end = this.length()-1;
        for(int i = this.length()-1; i > -1; i--){
            if(this.charAt(i)!=' '){
                end = i;
            }
        }
        end++;
        return this.substring(start, end);
    }

    public boolean isEmpty(){
        if(this.length()==0) return true;
        return false;
    }

    public int indexOf(char c){
        for(int i = 0; i < this.length(); i++){
            if(this.charAt(i)==c){
                return i;
            }
        }
        return -1;
    }

    public int indexOf(MyString str){
        if(str.length()>this.length()){
            return -1;
        }
        for(int i = 0; i < this.length() - str.length() + 1; i++){
            MyString aux = this.substring(i, str.length());
            if(aux.equals(str)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(MyString str){
        if(this.indexOf(str)==-1) return false;
        return true;
    }

    public MyString replace(char toReplace, char replacement){
        char[] arr = this.getArray().clone();
        for(int i = 0; i < arr.length; i++){
            if(arr[i]==toReplace) arr[i] = replacement;
        }
        return new MyString(arr);
    }

    public int compareTo(MyString other){
        for(int i = 0; i < Math.min(other.length(), this.length()); i++){
            int result = this.charAt(i)-other.charAt(i);
            if(result!=0) return result;
        }
        return this.length() - other.length();
    }

    public MyString concat(MyString str){
        char[] arr = new char[this.length()+str.length()];
        for(int i = 0; i < this.length(); i++){
            arr[i] = this.charAt(i);
        }
        for(int i = 0; i < str.length(); i++){
            arr[i+this.length()] = str.charAt(i);
        }
        return new MyString(arr);
    }
}
