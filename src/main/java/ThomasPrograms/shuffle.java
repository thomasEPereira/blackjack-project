//shuffle.java
package ThomasPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class shuffle
{
    public static List<String> createDeck()
    {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        List<String> deck = new ArrayList<>(52);

        for (String suit : suits)
        {
            for (String rank : ranks)
            {
                deck.add(rank + " of " + suit);
            }
        }
        return shuffle(deck);
    }
    public static List<String> shuffle(List<String> deck)
    {
        Collections.shuffle(deck);
        return(deck);
    }
}
