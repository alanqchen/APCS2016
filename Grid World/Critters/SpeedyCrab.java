import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.ArrayList;

/** Alan Chen
 * Project: GridWorld
 * Assignment(File): SpeedyCrab.java
 * Date Started: Nov 28, 2016
 * Brief Description:
 * Notes: Playing around with code templates in eclipse
 */
public class SpeedyCrab extends CrabCritter{
	public SpeedyCrab() {
		setColor(Color.RED);
	}
	/** 
	 * @param directions - directions in a array
	 * @return valid locations
	 */
	public ArrayList<Location> getLocationsInDirections(int[] directions) {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            Location moveToLoc = neighborLoc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc) && gr.isValid(moveToLoc) && gr.get(neighborLoc) == null && gr.get(moveToLoc) == null)
                locs.add(moveToLoc);
        }
        if(locs.size() == 0)
        	return super.getLocationsInDirections(directions);
        else
        	return locs;
	}
}
