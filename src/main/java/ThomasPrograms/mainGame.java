package ThomasPrograms;

import java.util.ArrayList;
import java.util.List;

public class mainGame
{
    static List deck = shuffle.createDeck();
    static List playersHand = new ArrayList<>();
    static List dealerHand = new ArrayList<>();
    public void game()
    {
        draw(dealerHand);
        draw(dealerHand);
        System.out.println("The dealer has a " + dealerHand.get(1) + " and 1 flipped over card.");
        draw(playersHand);
        draw(playersHand);
        while (true)
        {
            System.out.println(playersHand);
            String input = IO.readln("Hit or Stand?\n");
            input = optimizations.decapitalizeInput(input);
            if (input.equals("hit"))
            {
                System.out.println("You drew a " + deck.getFirst() + "!");
                draw(playersHand);
            }
            else if (input.equals("stand"))
            {
                System.out.println("You stood.");
                break;
            }
            else
            {
                System.out.println("Invalid input. Please input hit or stand.");
            }
        }
    }

    public void draw(List hand)
    {
        hand.add(deck.getFirst());
        deck.removeFirst();
    }
    public void double(List hand)
    {
        draw(hand);
        draw(hand);
    }
}
