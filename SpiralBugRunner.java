import java.awt.Color;
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.gui.*;
import info.gridworld.world.*;

public class SpiralBugRunner {

	public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        SpiralBug sBug = new SpiralBug(2);
        world.add(new Location(5, 5), sBug);
        world.show();
	}
}
