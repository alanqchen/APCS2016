import info.gridworld.actor.Bug;

public class PatternBug extends Bug{
	private int [] turnarray;
	private int linecount;
	public PatternBug(int [] input) {
		turnarray = input;
		linecount = 0;
	}
	public void act() {
		if (linecount == turnarray.length) {
			linecount = 0;
		}
		for (int i = 0; i < turnarray[linecount]; i++) {
			turn();
		}
		linecount++;
		super.act();
	}
}
