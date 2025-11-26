
package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * This is used to run our project using the main method.
 * 
 * @author Yonas
 * @version Oct 22, 2025
 */
public class ProjectRunner
{
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * This is the main method that initializes and runs the simulation of the
     * tower.
     * 
     * @param args
     *            is the argument for the main method but we are using disks in
     *            this case.
     */
    public static void main(String[] args)
    {
        int disks = 6;

        if (args.length == 1)
        {
            disks = Integer.parseInt(args[0]);
        }

        HanoiSolver solver = new HanoiSolver(disks);
        new PuzzleWindow(solver);
    }
}
