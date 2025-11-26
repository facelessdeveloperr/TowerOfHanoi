
package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * This class is used to hold and to move the disks in the puzzle.
 * 
 * @author Yonas
 * @version Oct 22, 2025
 */
public class Tower
    extends LinkedStack<Disk>
{
    // ~ Fields ................................................................

    private Position position;
    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Create a new Tower object at the position specified.
     * 
     * @param position
     *            is the position of the tower.
     */
    public Tower(Position position)
    {
        super();
        this.position = position;
    }
    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * This method simply returns the position of the tower.
     * 
     * @return this returns the tower's position.
     */
    public Position position()
    {
        return position;
    }


    @Override
    public void push(Disk disk)
    {
        if (disk == null)
        {
            throw new IllegalArgumentException("Disk can't be null!");
        }

        if (isEmpty() || peek().compareTo(disk) > 0)
        {
            super.push(disk);
        }
        else
        {
            throw new IllegalStateException(
                "Can't place bigger disk on smaller disk.");
        }
    }


    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        Tower other = (Tower)obj;
        return this.position == other.position;
    }

}
