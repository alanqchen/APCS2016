import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.ArrayList;

public class BlushingCritter extends Critter{
	private static final double factor = 0.5;
	private int c;
	public BlushingCritter(int c) {
		this.c = c;
	}
	public ArrayList<Actor> getActors() {
	    ArrayList<Actor> actors = new ArrayList<Actor>();
	    Location myLoc = this.getLocation();

	    for (int row = myLoc.getRow() - 2; row <= myLoc.getRow() + 2; row++)
	    {
	      for (int col = myLoc.getCol() - 2; col <= myLoc.getCol() + 2; col++)
	      {
	        Location loc = new Location(row, col);
	        if (this.getGrid().isValid(loc))
	        {
	          Actor actorAtLoc = this.getGrid().get(loc);
	          if (actorAtLoc != null && actorAtLoc instanceof Critter)
	            actors.add(actorAtLoc);
	        }
	      }
	    }

	    actors.remove(this);
	    return actors;
	  }
	public void processActors(ArrayList<Actor> actorList) {
		if (actorList.size() >= c) {
			darken();
		} else {
			lighten();
		}
	}
	private void darken() {
    	Color c = getColor();
        int red = (int) (c.getRed() * (1 - factor));
        int green = (int) (c.getGreen() * (1 - factor));
        int blue = (int) (c.getBlue() * (1 - factor));

        setColor(new Color(red, green, blue));
	}
	private void lighten() {
    	Color c = getColor();
        int red = (int) ((c.getRed() + 2) * (1 + factor));
        int green = (int) ((c.getGreen() + 2) * (1 + factor));
        int blue = (int) ((c.getBlue() + 2) * (1 + factor));
        if(red > 255)
        	red = 255;
        if(green > 255)
        	green = 255;
        if(blue > 255)
        	blue = 255;
        setColor(new Color(red, green, blue));
	}
}
