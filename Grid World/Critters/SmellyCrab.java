import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.ArrayList;
/** Alan Chen
 * Project: GridWorld
 * Assignment(File): SmellyCrab.java
 * Date Started: Nov 28, 2016
 * Brief Description:
 * Notes: Playing around with code templates
 */
public class SmellyCrab extends CrabCritter{
	public SmellyCrab() {
		setColor(Color.ORANGE);
	}
	
	public void processActors(ArrayList<Actor> actorList) {
		for(Actor testActor : actorList) {
			Location testLocation = testActor.getLocation();
			Location nextLocation = testLocation.getAdjacentLocation(getLocation().getDirectionToward(testLocation));
			if (getGrid().isValid(nextLocation)) {
				testActor.moveTo(nextLocation);
			} else {
				testActor.removeSelfFromGrid();
			}
		}
	}
}
