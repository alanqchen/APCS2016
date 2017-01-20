import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

/** Alan Chen
 * Project: GridWorld
 * Assignment(File): SmellyCrabRunner.java
 * Date Started: Nov 28, 2016
 * Brief Description:
 * Notes: Playing around with code templates
 */
public class SmellyCrabRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld(new BoundedGrid(11,11));
		SmellyCrab sc1 = new SmellyCrab();
        world.add(new Location(4,3),sc1);
        world.add(new Location(6,0),new Rock());
        world.add(new Location(6,4), new Rock());
        world.add(new Location(4,2),new Flower());
        world.show();
	}
}
