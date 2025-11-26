package towerofhanoi;
public class Node<T>
{
    //~ Fields ................................................................

    private T data;
    private Node<T> next;
    
    public Node(T data) {
        
        this.data = data;
        this.next = null;
        
    }
    
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
    
    public Node<T> getNextNode(){
        return next;
    }
    
    public void setNextNode(Node<T> next) {
        this.next = next;
    }
    
    public T getData() {
        return data;
    }
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

}
