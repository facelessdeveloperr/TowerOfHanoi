
package towerofhanoi;

import cs2.Shape;
import java.awt.Color;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 * This is the Disk class, used to create the Disk in the puzzle using different
 * widths and colors.
 * 
 * @author Yonas
 * @version Oct 22, 2025
 */
public class Disk
    extends Shape
    implements Comparable<Disk>
{
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Create a new Disk object.
     * 
     * @param width
     *            is the width of the disk.
     */
    public Disk(int width)
    {
        super(0, 0, width, 15);

        TestableRandom newRandom = new TestableRandom();
        Color color = new Color(
            newRandom.nextInt(256),
            newRandom.nextInt(256),
            newRandom.nextInt(256));
        this.setBackgroundColor(color);
    }


    @Override
    public int compareTo(Disk otherDisk)
    {
        if (otherDisk == null)
        {
            throw new IllegalArgumentException("Disk can't be null!");
        }
        return this.getWidth() - otherDisk.getWidth();
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        Disk other = (Disk)obj;
        return this.getWidth() == other.getWidth();
    }


    @Override
    public String toString()
    {
        return String.valueOf(this.getWidth());
    }

    // ~Public Methods ........................................................

}
