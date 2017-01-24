/**
 * Alan Chen - APCompSci 2017
 * Project: Linked Lists
 * Date started: 1/22/2017
 * Notes: This is a BONUS assingment!
 * TODO: Document
 */
// with thanks to Matt Ferraro

import java.io.IOException;
import java.util.ArrayList;
//import java.util.Queue;
import java.util.Scanner;
/*
 * CLASS FOR THE GAME
 * generateDecks - takes 2 decks and adds the cards to the decks(random)
 * shuffle - takes 2 decks and shuffles them
 * pause - for pausing
 * play - method that will be called by the main method
 * game - called by the play method, handles the drawing of the card, comparing, etc.
 * getTurns - returns the number of turns (not used?)
 * getp1Wins - returns the number of player 1 wins
 * getp2Wins - returns the number of player 2 wins
 * Note about getp1/2Wins - Will always return 0 or 1. These are used for the 3rd option in the menu 
 */
public class WarGame { 
	//private QueueList<Integer> deck1;
	//private QueueList<Integer> deck2;
	private static boolean war;
    private static int p1win;
    private static int p2win;
    private static int turnnum;
    //private boolean continuegame;
    public static void generateDecks(int deckSize, QueueList<Integer> deck1, QueueList<Integer> deck2)
    {
    	// Make sure the deckSize is a multiple of four
    	deckSize = (deckSize / 4) * 4;
    	
    	// Create the entire deck and fill it with the four suits
    	ArrayList<Integer> bigDeck = new ArrayList<Integer>();
    	for (int i = 0; i < deckSize; i++)
    		bigDeck.add(new Integer(i % (deckSize / 4)));
    	
		// Deal the cards
		while (!bigDeck.isEmpty())
		{
			deck1.add(bigDeck.remove((int)(Math.random()*bigDeck.size())));
			deck2.add(bigDeck.remove((int)(Math.random()*bigDeck.size())));
		}
		turnnum = 0;
    }
    public static void shuffle(QueueList<Integer> deck1, QueueList<Integer> deck2, boolean steps) {
    	if (steps)
    		System.out.println("Possible Stalemate - Shuffling!");
    	ArrayList<Integer> bigDeck1 = new ArrayList<Integer>();
    	ArrayList<Integer> bigDeck2 = new ArrayList<Integer>();
    	//System.out.println("Deck 1 has: ");
    	while (!deck1.isEmpty()) {
    		bigDeck1.add((Integer) deck1.remove());
    	}
    	//System.out.println("Deck 2 has: ");
    	while (!deck2.isEmpty()) {
    		bigDeck2.add((Integer) deck2.remove());
    	}
    	//System.out.println("Adding to Deck 1: ");
    	while (!bigDeck1.isEmpty()) {
    		deck1.add(bigDeck1.remove((int)(Math.random()*bigDeck1.size())));
    	}
    	//System.out.println("Adding to Deck 2: ");
    	while (!bigDeck2.isEmpty()) {
    		deck2.add(bigDeck2.remove((int)(Math.random()*bigDeck2.size())));
    	}
    	pause(steps);
    }
    private static void pause(boolean steps) {
    	if (!steps) {
    		return;
    	} else {
    		System.out.println("Press ENTER to continue...");
    		try {
    			System.in.read();
    		} catch (IOException e) {
    		}
    	}
    }
    public static int play(boolean steps, boolean result) {
    	p1win = 0;
    	p2win = 0;
    	QueueList<Integer> deck1 = new QueueList<Integer>();
    	QueueList<Integer> deck2 = new QueueList<Integer>();
    	QueueList<Integer> placed = new QueueList<Integer>();
    	generateDecks(52, deck1, deck2);
    	/*
    	int temp;
    	while(!deck1.isEmpty()) {
    		temp = deck1.remove();
    		System.out.println(temp);
    	}
    	*/
    	//continuegame = true;
    	//System.out.println("In the play method");
    	while (!(deck1.isEmpty() || deck2.isEmpty())) {
        	if (turnnum != 0 && (turnnum % 2500) == 0 && !(deck1.isEmpty() || deck2.isEmpty())) {
        		//turnnum++;
        		shuffle(deck1, deck2, steps);
        	}
    		turnnum++;
    		game(placed, deck1, deck2, steps, result);
    		pause(steps);
    	}
    	if (deck1.isEmpty()) {
    		if (result) {
    			System.out.println("Player 2 Won!!! In " + turnnum + " turns!"); 
    			pause(steps);
    		}
	        p2win++;
    	} if (deck2.isEmpty()) {
    		if (result) {
    			System.out.println("Player 1 Won!!! In " + turnnum + " turns!");
    			pause(steps);
    		}
	        p1win++;
    	}
    	return turnnum;
    }
    public static void game(QueueList<Integer> placed, QueueList<Integer> deck1, QueueList<Integer> deck2, boolean steps, boolean result) {
    	int card1 = deck1.remove();
    	int card2 = deck2.remove();
    	if (result) {
    		if (!war) {
    			System.out.println("---------------\nPlayer 1's card: " + card1);
    		} else {
    			System.out.println("Player 1's card: " + card1);
    		}
    		System.out.println("Player 2's card: " + card2);
    		war = false;
    	}
    	placed.add(card1);
    	placed.add(card2);
    	if (card1 > card2) {
    		if (result) {
    			System.out.println("Player 1 gets cards!\n---------------");
    			//pause(steps);
    		}
    		while (!placed.isEmpty()) {
    			deck1.add((Integer) placed.remove());
    		}
    	} else if (card1 < card2) {
    		if (result) {
    			System.out.println("Player 2 gets cards!\n---------------");
    			//pause(steps);
    		}
    		while (!placed.isEmpty()) {
    			deck2.add((Integer) placed.remove());
    		}
    	} else {
    		if (result) {
    			war = true;
    			System.out.println("Cards are the same! - WAR!");
    			System.out.println("Placing 3 cards facedown....");
    		}
    		int i = 0;
    		while (i < 3 && !(deck1.isEmpty() || deck2.isEmpty())) {
    			//System.out.println("int i count: " + i);
    			placed.add((Integer) deck1.remove());
    			placed.add((Integer) deck2.remove());
    			i++;
    		}
    		if (i == 3 && !(deck1.isEmpty() || deck2.isEmpty())) {
    			game(placed, deck1, deck2, steps, result);
    		} else if (result) {
    			System.out.println("Player's deck empty while placing!");
    			war = false;
    		}
    		return;
    	}
    }
    public int getTurns() {
    	return turnnum;
    }
    public static int getp1Wins() {
    	//System.out.println(p1win);
    	return p1win;
    }
    public static int getp2Wins() {
    	//System.out.println(p2win);
    	return p2win;
    }
    /* 
     * MAIN METHOD
     * Has the looping menu
     * 1. Play War (with steps) - Starts a game of war, doing it step-by-step
     * 2. Play War (without steps) - Starts a game of war, without doing step-by-step
     * 3. Simulate several games - User enters number of times they want to simulate, and then displays
     *    average number of turns to finsih game, and then the number of wins from both player 1 and player 2
     * 4. Quit - Terminates program
     */
    private static Scanner input = new Scanner(System.in); 
    public static void main(String[] args) {
    	int menu = 0;
		do {
			System.out.println("");
			System.out.println("#============== War Card Game (BONUS) ===============#");
			System.out.println("|1. Play War (with steps)                            |");
			System.out.println("|2. Play War (without steps)                         |");
			System.out.println("|3. Simulate several games                           |");
			System.out.println("|4. Quit                                             |");
			System.out.println("#====================================================#");
			System.out.println("");
			System.out.print("Please choose a selection: ");
			menu = input.nextInt();
			if (menu == 1) {
				System.out.println("Starting game...");
				play(true, true);
			}
			if (menu == 2) {
				play(false, true);
			}
			if (menu == 3) {
				System.out.print("How many times to simulate war? ");
				int count = input.nextInt();
				if (count == 0) {
					System.out.println("0?! Really!?");
				} else {
					int turns = 0;
					int p1 = 0;
					int p2 = 0;
					int i = 0;
					while(i < count) {
						turns += play(false, false);
						p1 += getp1Wins();
						p2 += getp2Wins();
						i++;
					}
					int average = turns / count;
					String line1 = "#======================= Info =======================#";
					String line2 = "\n| Average number of turns to win: " + average;
					String line3 = "\n| Number of Player 1 wins: " + p1;
					String line4 = "\n| Number of Player 2 wins: " + p2;
					String line5 = "\n#====================================================#";
					while (line2.length() < line1.length() - 1) {
						line2 += " ";
					}
					while (line3.length() < line1.length() - 1) {
						line3 += " ";
					}
					while (line4.length() < line1.length() - 1) {
						line4 += " ";
					}
					line2 += " |";
					line3 += " |";
					line4 += " |";
					System.out.println(line1 + line2 + line3 + line4 + line5);
				}
			}
		} while (menu != 4);
	}
}
