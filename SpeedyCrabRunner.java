import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.actor.ActorWorld;

import info.gridworld.grid.Location;
import info.gridworld.grid.BoundedGrid;
import java.awt.Color;
/** Alan Chen
 * Project: GridWorld
 * Assignment(File): SpeedyCrabRunner.java
 * Date Started: Nov 28, 2016
 * Brief Description:
 * Notes: Playing around with code templates
 */
public class SpeedyCrabRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld(new BoundedGrid(11,11));
		SpeedyCrab sc1 = new SpeedyCrab();
        world.add(new Location(4,3),sc1);
        world.add(new Location(6,0),new Rock());
        world.add(new Location(6,4), new Rock());
        world.add(new Location(4,2),new Flower());
        world.show();
	}

}
