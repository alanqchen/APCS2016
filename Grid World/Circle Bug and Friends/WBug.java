import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class WBug extends Bug{
	private int steps;
	private int sideLength;
	private int linecount;
	public WBug(int length) {
		sideLength = length;
		steps = 0;
		linecount = 0;
		setDirection(Location.SOUTH);
	}
	public void act() {
		if (steps < sideLength && linecount <= 4) {
			if (canMove()) {
				move();
				steps++;
			} else {
				steps = sideLength;
				linecount = 3;
			}
		} else if (linecount == 0) {
			setDirection(Location.NORTHEAST);
			steps = 0;
			linecount++;
		} else if (linecount == 1) {
			setDirection(Location.SOUTH);
			steps = 0;
			linecount++;
		} else if (linecount == 2) {
			setDirection(Location.NORTHEAST);
			steps = 0;
			linecount++;
		}
	}
}
