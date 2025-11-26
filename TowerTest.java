
package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * This class is used to test the tower class to make sure all the methods work
 * properly.
 * 
 * @author Yonas
 * @version Oct 22, 2025
 */
public class TowerTest
    extends student.TestCase
{
    // ~ Fields ................................................................

    private Tower leftTower;
    private Tower rightTower;
    private Disk diskA;
    private Disk diskB;

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * This is used to initialize the towers and the conditions for the tests.
     */
    public void setUp()
    {
        leftTower = new Tower(Position.LEFT);
        rightTower = new Tower(Position.RIGHT);
        diskA = new Disk(10);
        diskB = new Disk(20);
    }


    // ----------------------------------------------------------
    /**
     * This is used to test the positions of the towers.
     */
    // ~Public Methods ........................................................

    public void testPosition()
    {
        assertEquals(Position.LEFT, leftTower.position());
        assertEquals(Position.RIGHT, rightTower.position());

    }


    // ----------------------------------------------------------
    /**
     * This tests a valid push as in pushing smaller disks onto larger ones.
     */
    public void testValidPush()
    {
        rightTower.push(diskB);
        rightTower.push(diskA);
        assertEquals(2, rightTower.size());
        assertEquals(diskA, rightTower.peek());
    }


    // ----------------------------------------------------------
    /**
     * This method tests pushing a disk that is null which throws an exception.
     */
    public void testNullPush()
    {
        Exception ex = null;
        try
        {
            leftTower.push(null);
        }
        catch (IllegalArgumentException e)
        {
            ex = e;
        }
        assertNotNull(ex);
    }


    // ----------------------------------------------------------
    /**
     * This method tests a push that is not valid (bigger disk on a smaller
     * one.)
     */
    public void testInvalidPush()
    {
        leftTower.push(diskA);
        Exception ex = null;
        try
        {
            leftTower.push(diskB);
        }
        catch (IllegalStateException e)
        {
            ex = e;
        }
        assertNotNull(ex);
    }


    // ----------------------------------------------------------
    /**
     * This is to make sure the string output of the tower matches the expected
     * output.
     */
    public void testToString()
    {
        assertEquals("[]", leftTower.toString());
        leftTower.push(diskB);
        leftTower.push(diskA);
        assertEquals("[10, 20]", leftTower.toString());
    }


    // ----------------------------------------------------------
    /**
     * This method is used to test the equals() method in Tower class.
     */
    public void testEquals()
    {
        Tower left1 = new Tower(Position.LEFT);
        Tower left2 = new Tower(Position.LEFT);
        Tower right = new Tower(Position.RIGHT);

        assertTrue(left1.equals(left1));
        assertTrue(left1.equals(left2));
        assertFalse(left1.equals(right));
        assertFalse(left1.equals(null));
        assertFalse(left1.equals("String"));

    }
}
