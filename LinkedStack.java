
package towerofhanoi;

import stack.StackInterface;
import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * This class is used to create a linked implementation of a stack using push,
 * pop, clear, peek and size
 * 
 * @param <T>
 *            is the type of items in the stack.
 * @author Yonas
 * @version Oct 22, 2025
 */
public class LinkedStack<T>
    implements StackInterface<T>
{

    private Node topNode;
    private int size;

    // ----------------------------------------------------------
    /**
     * This is used to make an empty LinkedStack.
     */
    public LinkedStack()
    {
        topNode = null;
        size = 0;
    }


    @Override
    public void clear()
    {
        topNode = null;
        size = 0;

    }


    @Override
    public boolean isEmpty()
    {
        return topNode == null;
    }


    @Override
    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }


    @Override
    public T pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        T data = topNode.getData();
        topNode = topNode.getNextNode();
        size--;
        return data;
    }


    @Override
    public void push(T entry)
    {
        Node newNode = new Node(entry, topNode);
        topNode = newNode;
        size++;

    }


    // ----------------------------------------------------------
    /**
     * This returns the number of items currently in the stack
     * 
     * @return returns the number of items in the stack.
     */
    public int size()
    {
        return size;
    }


    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Node current = topNode;
        while (current != null)
        {
            builder.append(current.getData());
            current = current.getNextNode();
            if (current != null)
            {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    private class Node
    {
        private T data;
        private Node next;

        public Node(T data)
        {
            this.data = data;
            this.next = null;
        }


        public Node(T data, Node node)
        {
            this(data);
            this.setNextNode(node);
        }


        public T getData()
        {
            return data;
        }


        public Node getNextNode()
        {
            return next;
        }


        public void setNextNode(Node node)
        {
            this.next = node;
        }
    }

    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

}
