/// 
///
///
// with thanks to Matt Ferraro

import java.util.ArrayList;
//import java.util.Queue;
  
public class WarGame { 
	//private QueueList<Integer> deck1;
	//private QueueList<Integer> deck2;
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
    public static void play() {
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
    	System.out.println("In the play method");
    	while (!(deck1.isEmpty() || deck2.isEmpty())) {
    		turnnum++;
    		game(placed, deck1, deck2);
    	}
    	if (deck1.isEmpty())
    		System.out.println("Player 2 Won!!! In " + turnnum + " turns!");
    	if (deck2.isEmpty())
    		System.out.println("Player 1 Won!!! In " + turnnum + " turns!");
    }
    public static void game(QueueList<Integer> placed, QueueList<Integer> deck1, QueueList<Integer> deck2) {
    	int card1 = deck1.remove();
    	int card2 = deck2.remove();
    	System.out.println("----------\nc1 " + card1);
    	System.out.println("c2 " + card2);
    	placed.add(card1);
    	placed.add(card2);
    	if (card1 > card2) {
    		System.out.println("c1 won");
    		while (!placed.isEmpty()) {
    			System.out.println("Added: " + deck1.add(placed.remove()) + "\n----------");
    		}
    	} else if (card1 < card2) {
    		System.out.println("c2 won");
    		while (!placed.isEmpty()) {
    			System.out.println("Added: " + deck2.add(placed.remove()) + "\n----------");
    		}
    	} else {
    		System.out.println("WAR!");
    		int i = 0;
    		while (i < 3 && !(deck1.isEmpty() || deck2.isEmpty())) {
    			System.out.println("int i count: " + i);
    			System.out.println("Placed1: " + placed.add(deck1.remove()));
    			System.out.println("Placed2: " + placed.add(deck2.remove()));
    			i++;
    		}
    		if (i == 3 && !(deck1.isEmpty() || deck2.isEmpty()))
    			game(placed, deck1, deck2);
    		else
    			System.out.println("Empty while dealing");
    			return;
    	}
    }
    public int getTurns() {
    	return turnnum;
    }
    
    public static void main(String[] args)
    {
    	System.out.println("Starting game......");
    	play();
    }
}
