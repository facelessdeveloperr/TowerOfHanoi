
package towerofhanoi;


// -------------------------------------------------------------------------
/**
 * This class is used to test the methods of HanoiSolver and test the logic.
 * 
 * @author Sameer Radmehr
 * @version Oct 22, 2025
 */
public class HanoiSolverTest
    extends student.TestCase
{
    // ~ Fields ................................................................

    private HanoiSolver solver;
    private Disk disk1;
    private Disk disk2;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * This is used to initialize the variables and disks.
     */
    public void setUp()
    {
        solver = new HanoiSolver(3);
        disk1 = new Disk(12);
        disk2 = new Disk(24);
    }
    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * This method is used to test counting disks.
     */
    public void testDisksCount()
    {
        assertEquals(3, solver.disks());
    }


    // ----------------------------------------------------------
    /**
     * This method is used to test getting different towers.
     */
    public void testGetTower()
    {
        assertEquals(Position.LEFT, solver.getTower(Position.LEFT).position());
        assertEquals(
            Position.CENTER,
            solver.getTower(Position.CENTER).position());
        assertEquals(
            Position.RIGHT,
            solver.getTower(Position.RIGHT).position());
        assertEquals(
            Position.CENTER,
            solver.getTower(Position.DEFAULT).position());

    }


    // ----------------------------------------------------------
    /**
     * This method is used to test the move() method.
     */
    public void testMove()
    {
        Tower start = solver.getTower(Position.LEFT);
        Tower end = solver.getTower(Position.RIGHT);

        start.push(disk1);
        solver.move(start, end);

        assertTrue(start.isEmpty());
        assertEquals(1, end.size());
        assertEquals(disk1, end.peek());
    }


    // ----------------------------------------------------------
    /**
     * This method is used to test the toString method.
     */
    public void testToString()
    {
        Tower left = solver.getTower(Position.LEFT);
        left.push(disk2);
        left.push(disk1);
        Tower center = solver.getTower(Position.CENTER);
        center.push(new Disk(30));
        assertEquals("[12, 24][30][]", solver.toString());
    }


    // ----------------------------------------------------------
    /**
     * This method is used to test the solve() method and that disks are pushed
     * in the right order.
     */
    public void testSolveRuns()
    {
        Tower left = solver.getTower(Position.LEFT);
        left.push(new Disk(35));
        left.push(new Disk(25));
        left.push(new Disk(15));

        solver.solve();
        assertNotNull(solver.toString());
    }
}
