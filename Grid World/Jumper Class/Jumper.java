import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;
public class Jumper extends Actor{
	Jumper() {
		setColor(Color.BLUE);
		setDirection(Location.SOUTH);
	}
	Jumper(Color color) {
		setColor(color);
		setDirection(Location.SOUTH);
	}
	public void act() {
			Jump();
	}
	private void Jump() {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Actor nextActor;
        int rows = gr.getNumRows();
        int cols = gr.getNumCols();
        Location loc = getLocation();
        Location adj = loc.getAdjacentLocation(getDirection());
        Location next = adj.getAdjacentLocation(getDirection());
        if (gr.isValid(next)) {
            nextActor = gr.get(next);
        } else {
            int actualrow = next.getRow();
            int actualcol = next.getCol();
            if (next.getRow() < 0) {
                actualrow += rows;
            } else if (next.getRow() >= rows) {
                actualrow -= rows;
            }
            if (next.getCol() < 0) {
                actualcol += cols;
            } else if (next.getCol() >= cols) {
                actualcol -= cols;
            }
            next = new Location(actualrow,actualcol);
            nextActor = gr.get(next);
        }
        if((nextActor == null) || !(nextActor instanceof Rock)) {
        	moveTo(next);
        } else {

        }
	}
}
