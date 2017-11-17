import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.actor.ActorWorld;

import info.gridworld.grid.Location;
import info.gridworld.grid.BoundedGrid;
import java.awt.Color;

public class JumperRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld(new BoundedGrid(7,5));
		Jumper jumpBug1 = new Jumper();
		Jumper jumpBug2 = new Jumper();
		jumpBug1.setDirection(Location.NORTHWEST);
		jumpBug2.setDirection(Location.NORTHEAST);
        world.add(new Location(2,1),jumpBug1);
        world.add(new Location(2,3),jumpBug2);
        world.add(new Jumper());
        world.add(new Location(6,0),new Rock());
        world.add(new Flower());
        world.show();
	}

}
