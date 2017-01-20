import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.ArrayList;
public class RockEater extends Critter{
	public RockEater() {
		setColor(Color.RED);
	}
	public void processActors (ArrayList<Actor> actors) {
		for (Actor a : actors) {
			if (a instanceof Rock)
				a.removeSelfFromGrid();
		}
	}
	public void makeMove(Location loc) {
		setDirection(getLocation().getDirectionToward(loc));
		super.makeMove(loc);
	}
}
