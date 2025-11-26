
package towerofhanoi;

import java.util.Observable;

// -------------------------------------------------------------------------
/**
 * This class is used for the logic of the Tower of Hanoi, it handles moving,
 * recursion, and communication.
 * 
 * @author Yonas
 * @version Oct 22, 2025
 */
public class HanoiSolver
    extends Observable
{
    // ~ Fields ................................................................

    private Tower left;
    private Tower center;
    private int numDisks;
    private Tower right;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * This is the constructor for the class, it creates a new solver with the
     * given numebr of disks.
     * 
     * @param numDisks
     *            is the number of disks for the puzzle.
     */
    public HanoiSolver(int numDisks)
    {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        center = new Tower(Position.CENTER);
        right = new Tower(Position.RIGHT);
    }


    // ----------------------------------------------------------
    /**
     * returns the total number of disks in the puzzle.
     * 
     * @return returns the number of disks.
     */
    public int disks()
    {
        return numDisks;
    }


    // ----------------------------------------------------------
    /**
     * returns a tower based on position.
     * 
     * @param pos
     *            is the position of the tower.
     * @return returns the tower corresponding to the position.
     */
    public Tower getTower(Position pos)
    {
        switch (pos)
        {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case CENTER:
                return center;
            default:
                return center;
        }
    }


    // ----------------------------------------------------------
    /**
     * This method is used to handle the movement of the disks.
     * 
     * @param source
     *            is the tower to move from.
     * @param destination
     *            is the tower the disk is moving to.
     */
    public void move(Tower source, Tower destination)
    {
        Disk disk = source.pop();
        destination.push(disk);

        setChanged();
        notifyObservers(destination.position());
    }


    @Override
    public String toString()
    {
        return left.toString() + center.toString() + right.toString();
    }


    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole)
    {
        if (currentDisks == 1)
        {
            move(startPole, endPole);
        }
        else
        {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    // ----------------------------------------------------------
    /**
     * Solves the puzzle.
     */
    public void solve()
    {
        solveTowers(numDisks, left, center, right);
    }
    // ~Public Methods ........................................................

}
