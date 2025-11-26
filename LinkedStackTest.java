
package towerofhanoi;

import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * This is the test class for LinkedStack class and it is used to test the
 * behavior of the LinkedStack class and the methods.
 * 
 * @author Yonas
 * @version Oct 22, 2025
 */
public class LinkedStackTest
    extends student.TestCase
{
    // ~ Fields ................................................................

    private LinkedStack<String> stack;
    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * This method is used to create a new empty LinkedStack.
     */
    public void setUp()
    {
        stack = new LinkedStack<String>();
    }


    // ----------------------------------------------------------
    /**
     * This is used to test the push() and size() methods.
     */
    public void testPushAndTestSize()
    {
        assertEquals(0, stack.size());
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals(3, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * This is used to test the peek() method.
     */
    public void testPeek()
    {
        stack.push("one");
        stack.push("two");
        assertEquals("two", stack.peek());
        assertEquals(2, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * This is used to test the peek() method when stack is empty.
     */
    public void testPeekWhenEmpty()
    {
        Exception error = null;
        try
        {
            stack.peek();
        }
        catch (EmptyStackException e)
        {
            error = e;
        }
        assertNotNull(error);
    }


    // ----------------------------------------------------------
    /**
     * This is used to test pop() method when stack is empty.
     */
    public void testPopWhenEmpty()
    {
        Exception ex = null;
        try
        {
            stack.pop();
        }
        catch (EmptyStackException e)
        {
            ex = e;
        }
        assertNotNull(ex);
    }


    // ----------------------------------------------------------
    /**
     * This is used to test the isEmpty() and clear() methods.
     */
    public void testIsEmptyAndClear()
    {
        stack.push("X");
        stack.push("Y");
        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * This is used to test teh toString() method.
     */
    public void testToString()
    {
        assertEquals("[]", stack.toString());
        stack.push("1");
        stack.push("2");
        stack.push("3");
        assertEquals("[3, 2, 1]", stack.toString());
    }

    // ~Public Methods ........................................................

}
