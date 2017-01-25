/**
 * Alan Chen - APCompSci 2017
 * Project: Linked Lists
 * Date started: 1/22/2017
 * Notes: This is a BONUS assignment!
 * TODO: DOONNNNEEE!
 */
// with thanks to Matt Ferraro
import java.util.ArrayList;
//import java.util.Queue;
import java.util.Scanner;
/*
 * -=CLASS FOR THE GAME=-
 * generateDecks - takes 2 decks and adds the cards to the decks(random)
 * shuffle - takes 2 decks and shuffles them
 * pause - for pausing
 * play - method that will be called by the main method
 * game - called by the play method, handles the drawing of the card, comparing, etc.
 * getp1Wins - returns the number of player 1 wins
 * getp2Wins - returns the number of player 2 wins
 * -----------------------------------------------------------------------------------------------------
 * Note about getp1/2Wins - Will always return 0 or 1. These are used for the 3rd option in the menu 
 * Note about if (result) - boolean if true, will display to the screen the info about the game
 * Note about pause(steps) - boolean, if true, will pause each step
 */
public class WarGame { 
	/* 
	 * -=PRIVATE VARIABLES=-
	 * boolean war - used to track if the game is in a 'war' state. Used for telling which line to print to the screen
	 * int p1/2win - used to hold the number of wins player 1/2 has (Will only store 0 or 1). Used for the 3rd option in the menu
	 * int turnnum - counter for the number of turns
	 * */
	private static boolean war;
    private static int p1win;
    private static int p2win;
    private static int turnnum;
    //private boolean continuegame;
    /*
     * -=GENERATE DECKS=-
     * takes 2 decks and adds the cards to the decks(random)
     */
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
    /*
     * -=SHUFFLE=-
     * takes 2 decks and shuffles them
     */
    public static void shuffle(QueueList<Integer> deck1, QueueList<Integer> deck2, boolean steps, boolean result) {
    	if (result) {
    		System.out.println("#============== Shuffling ==============#");
    		System.out.println("| Possible Stalemate - Shuffling Decks! |");
    		System.out.println("#=======================================#");
    	}
    	//Two bigDecks to not mix up the cards from each player's deck
    	ArrayList<Integer> bigDeck1 = new ArrayList<Integer>();
    	ArrayList<Integer> bigDeck2 = new ArrayList<Integer>();
    	//removes cards and adds them to their respective bigdeck
    	while (!deck1.isEmpty()) {
    		bigDeck1.add((Integer) deck1.remove());
    	}
    	while (!deck2.isEmpty()) {
    		bigDeck2.add((Integer) deck2.remove());
    	}
    	//adds cards back randomly to their respective deck
    	while (!bigDeck1.isEmpty()) {
    		deck1.add(bigDeck1.remove((int)(Math.random()*bigDeck1.size())));
    	}
    	while (!bigDeck2.isEmpty()) {
    		deck2.add(bigDeck2.remove((int)(Math.random()*bigDeck2.size())));
    	}
    	pause(steps);
    }
    /*
     * -=PAUSE=-
     * for pausing
     */
    private static void pause(boolean steps) {
    	if (!steps) {
    		return;
    	} else {
    		System.out.println("Press ENTER to continue...");
    		Scanner pause = new Scanner(System.in);
    		pause.nextLine();
    	}
    }
    /*
     * -=PLAY=-
     * method that will be called by the main method
     */
    public static int play(boolean steps, boolean result) {
    	//win count to 0
    	p1win = 0;
    	p2win = 0;
    	//initializes the players decks, and the placed deck(deck that stores the cards the players placed down)
    	QueueList<Integer> deck1 = new QueueList<Integer>();
    	QueueList<Integer> deck2 = new QueueList<Integer>();
    	QueueList<Integer> placed = new QueueList<Integer>();
    	//Adds 26 cards to each deck
    	generateDecks(52, deck1, deck2);
    	//while neither of the decks are empty
    	while (!(deck1.isEmpty() || deck2.isEmpty())) {
    		//shuffles every 1500 turns(if both decks still are not empty), as there is a very good chance that it's a stalemate
        	if (turnnum != 0 && (turnnum % 1500) == 0 && !(deck1.isEmpty() || deck2.isEmpty())) {
        		shuffle(deck1, deck2, steps, result);
        	}
        	//increments turn counter
    		turnnum++;
    		//starts turn of game
    		game(placed, deck1, deck2, steps, result);
    		pause(steps);
    	}
    	//if deck1 is empty, player 2 wins
    	if (deck1.isEmpty()) {
    		if (result) {
    			//setting up message box
    			String line1 = "#================== Game Over! ==================#";
    			String line2 = "\n| Player 2 Won!!! In " + turnnum + " turns!";
    			String line3 = "\n#================================================#";
    			//adds spaces
				while (line2.length() < line1.length() - 1) {
					line2 += " ";
				}
				//adds end wall
				line2 += " |";
				//display
    			System.out.println(line1 + line2 + line3); 
    			pause(steps);
    		}
	        p2win++;
	    //if deck2 is empty, player 1 wins
    	} if (deck2.isEmpty()) {
    		if (result) {
    			//setting up message box
    			String line1 = "#================== Game Over! ==================#";
    			String line2 = "\n| Player 1 Won!!! In " + turnnum + " turns!";
    			String line3 = "\n#================================================#";
				while (line2.length() < line1.length() - 1) {
					line2 += " ";
				}
				line2 += " |";
				//display
    			System.out.println(line1 + line2 + line3); 
    			pause(steps);
    		}
	        p1win++;
    	}
    	//returns turn count
    	return turnnum;
    }
    /*
     * -=GAME=-
     * called by the play method, handles the drawing of the card, comparing, etc.
     */
    public static void game(QueueList<Integer> placed, QueueList<Integer> deck1, QueueList<Integer> deck2, boolean steps, boolean result) {
    	//removes 1 card from each deck, stores in their respective int variable
    	int card1 = deck1.remove();
    	int card2 = deck2.remove();
    	//Display details?
    	if (result) {
    		//if there is not a war, adds the divider line
    		if (!war) {
    			System.out.println("------------------------------\nTurn " + turnnum + "\nPlayer 1's card: " + card1);
    		} else {
    			System.out.println("Player 1's card: " + card1);
    		}
    		System.out.println("Player 2's card: " + card2);
    		war = false;
    	}
    	//adds both cards to the placed deck(pile)
    	placed.add(card1);
    	placed.add(card2);
    	//is card1 larger than card2?
    	if (card1 > card2) {
    		if (result) {
    			System.out.println("Player 1 gets cards!\n------------------------------");
    		}
    		//gives player 1 the cards
    		while (!placed.isEmpty()) {
    			deck1.add((Integer) placed.remove());
    		}
    	//is card2 larger than card3?
    	} else if (card1 < card2) {
    		if (result) {
    			System.out.println("Player 2 gets cards!\n------------------------------");
    		}
    		//gives player 2 the cards
    		while (!placed.isEmpty()) {
    			deck2.add((Integer) placed.remove());
    		}
    	//else, it's a war!
    	} else {
    		if (result) {
    			war = true;
    			System.out.println("Cards are the same! - WAR!");
    			System.out.println("Placing 3 cards facedown....");
    		}
    		//takes three cards from each deck, and adds to the placed pile
    		int i = 0;
    		while (i < 3 && !(deck1.isEmpty() || deck2.isEmpty())) {
    			placed.add((Integer) deck1.remove());
    			placed.add((Integer) deck2.remove());
    			i++;
    		}
    		//the decks must not be empty, or they lose
    		if (i == 3 && !(deck1.isEmpty() || deck2.isEmpty())) {
    			//game is run again, placing the 4th card that will be shown and compared
    			game(placed, deck1, deck2, steps, result);
    		//one of the decks is empty
    		} else {
    			if (result)
    				System.out.println("Player's deck empty while placing!");
    			war = false;
    		}
    		return;
    	}
    }
    /*
     * -=GET P1 WINS=-
     * returns the number of player 1 wins
     */
    public static int getp1Wins() {
    	return p1win;
    }
    /*
     * -=GET P2 WINS=-
     * returns the number of player 2 wins
     */
    public static int getp2Wins() {
    	return p2win;
    }
    /* 
     * MAIN METHOD
     * Has the looping menu
     * 1. Play War (with pauses) - Starts a game of war, doing it step-by-step
     * 2. Play War (without pauses) - Starts a game of war, without doing step-by-step 
     * 3. Simulate several games - User enters number of times they want to simulate, and then displays
     *    average number of turns to finish game, and the number of wins from both player 1 and player 2
     * 4. Quit - Terminates program
     */
    private static Scanner input = new Scanner(System.in); 
    public static void main(String[] args) {
    	int menu = 0;
		do {
			//display menu
			System.out.println("");
			System.out.println("#=================== War Card Game (BONUS) ====================#");
			System.out.println("|1. Play War (with pauses)                                     |");
			System.out.println("|2. Play War (without pauses)                                  |");
			System.out.println("|3. Simulate several games                                     |");
			System.out.println("|4. Quit                                                       |");
			System.out.println("#==============================================================#");
			System.out.println("");
			System.out.print("Please choose a selection: ");
			menu = input.nextInt();
			/*
			 * -=PLAY WAR (WITH PAUSES)=-
			 * plays war, step-by-step (with pauses)
			 * steps: true
			 * result: true
			 */
			if (menu == 1) {
				System.out.println("Starting game...");
				play(true, true);
			}
			/*
			 * -=PLAY WAR (WITHOUT PAUSES)=-
			 * plays war, without the pauses
			 * steps: false
			 * result: true
			 */
			if (menu == 2) {
				System.out.println("Starting game...");
				play(false, true);
			}
			/*
			 * -=SIMULATE SEVERAL GAMES=-
			 * Simulate several games - User enters number of times they want to simulate, and then displays
			 * average number of turns to finish game, and the number of wins from both player 1 and player 2
			 * steps: false
			 * result: false
			 */
			if (menu == 3) {
				//gets the number of times to simulate
				System.out.print("How many times to simulate war? ");
				int count = input.nextInt();
				//makes sure the user doesn't enter 0
				if (count == 0) {
					System.out.println("0?! Really!?");
				} else {
					//sets all the counters to 0
					int turns = 0;
					int p1 = 0;
					int p2 = 0;
					int i = 0;
					//Times the time it takes to execute code - just for fun :)
					long timeStart = System.nanoTime();
					//keeps playing war for the set number of times, adding to the counters
					while(i < count) {
						turns += play(false, false);
						p1 += getp1Wins();
						p2 += getp2Wins();
						i++;
					}
					//stops timer
					long timeEnd = System.nanoTime(); 
					//divides recorded time by 1000000 to convert to miliseconds
					long time = (timeEnd - timeStart) / 1000000;
					//calculates average turns to win
					int average = turns / count;
					//sets up the info display
					String line1 = "#============================ Info ============================#";
					String line2 = "\n| Average number of turns to win: " + average;
					String line3 = "\n| Number of Player 1 wins: " + p1;
					String line4 = "\n| Number of Player 2 wins: " + p2;
					String line5 = "\n| It took " + time + " miliseconds to simulate " + count + " games";
					String line6 = "\n#==============================================================#";
					//adds spaces so the box looks clean
					while (line2.length() < line1.length() - 1) {
						line2 += " ";
					}
					while (line3.length() < line1.length() - 1) {
						line3 += " ";
					}
					while (line4.length() < line1.length() - 1) {
						line4 += " ";
					}
					while (line5.length() < line1.length() - 1) {
						line5 += " ";
					}
					//adds the end walls
					line2 += " |";
					line3 += " |";
					line4 += " |";
					line5 += " |";
					//displays the box
					System.out.println(line1 + line2 + line3 + line4 + line5 + line6);
				}
			}
		} while (menu != 4);
		System.out.println("Have a nice day!");
	}
}
