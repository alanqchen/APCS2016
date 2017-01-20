import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.actor.ActorWorld;

import info.gridworld.grid.Location;
import info.gridworld.grid.BoundedGrid;
import java.awt.Color;
public class BlushingCritterRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld(new BoundedGrid(7,7));
		int courage = 2;
		Color c = new Color(0,255,0);
		BlushingCritter bc1 = new BlushingCritter(courage);
		bc1.setColor(c);
        world.add(new Location(4,3),bc1);
        world.add(new Location(6,0),new Rock());
        world.add(new Location(6,4), new Rock());
        world.add(new Location(4,2),new Flower());
        world.show();
	}
}
