
package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * This class is used to test the methods of the Disk class for coverage.
 * 
 * @author Sameer Radmehr
 * @version Oct 22, 2025
 */
public class DiskTest
    extends student.TestCase
{
    // ~ Fields ................................................................

    private Disk smallDisk;
    private Disk midDisk;
    private Disk large;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * This method is used to initialize disks for testing.
     */
    public void setUp()
    {
        smallDisk = new Disk(9);
        midDisk = new Disk(18);
        large = new Disk(27);
    }


    // ----------------------------------------------------------
    /**
     * This is to make sure width is converted to a string.
     */
    // ~Public Methods ........................................................

    public void testToString()
    {
        assertEquals("9", smallDisk.toString());
        assertEquals("18", midDisk.toString());

    }


    // ----------------------------------------------------------
    /**
     * This method is used to test the CompareTo method.
     */
    public void testCompareTo()
    {
        assertTrue(smallDisk.compareTo(midDisk) < 0);
        assertTrue(large.compareTo(midDisk) > 0);
        Disk anotherMidDisk = new Disk(18);
        assertEquals(0, midDisk.compareTo(anotherMidDisk));
    }


    // ----------------------------------------------------------
    /**
     * This method is used to test the CompareTo method with a null value.
     */
    public void testCompareToWhenNull()
    {
        Exception thrown = null;
        try
        {
            smallDisk.compareTo(null);
        }
        catch (IllegalArgumentException e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
    }


    // ----------------------------------------------------------
    /**
     * This method is used to test the Equals() method.
     */
    public void testEquals()
    {
        Disk sameSize = new Disk(9);
        Disk differentSize = new Disk(25);

        assertTrue(smallDisk.equals(sameSize));
        assertFalse(smallDisk.equals(differentSize));
        assertFalse(smallDisk.equals(null));
        assertFalse(smallDisk.equals("disk"));
    }

}
