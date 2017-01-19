import java.awt.Color;
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.gui.*;
import info.gridworld.world.*;

public class PatternBugRunner {

	public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        int [] turnArray = {1,2,3,4};
        PatternBug pBug = new PatternBug(turnArray);
        world.add(new Location(5,4),pBug);
        world.show();
	}
}
