import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class RockEaterRunner {
	public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(5, 8), new Rock());
        world.add(new Location(2, 1), new RockEater());
        world.show();
    }
}
