import java.awt.Color;
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.gui.*;
import info.gridworld.world.*;

public class WBugRunner {

	public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        WBug wBug = new WBug(3);
        world.add(new Location(2, 1), wBug);
        world.add(new Rock());
        world.show();
	}
}
