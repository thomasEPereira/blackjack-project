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
        doubleDraw(dealerHand);
        System.out.println("The dealer has a " + dealerHand.get(1) + " and 1 flipped over card.");
        doubleDraw(playersHand);
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
            else if (input.equals("double"))
            {
                System.out.println("You drew a " + deck.getFirst() + "and a " + deck.get(1));
                doubleDraw(playersHand);
            }
            else
            {
                System.out.println("Invalid input. Please input hit or stand.");
            }
        }
        System.out.println("The dealer flips over a " + dealerHand.get(0) + ".");
        optimizations.timer(200);
        System.out.println("The dealer has a hand of " + dealerHand.get(0) + " and " + dealerHand.get(1) + ".");
        System.out.println("The dealer has a total of " + handTotal());
    }

    public void draw(List hand)
    {
        hand.add(deck.getFirst());
        deck.removeFirst();
    }

    public void doubleDraw(List hand)
    {
        draw(hand);
        draw(hand);
    }

    public static int handTotal()
    {
        int count = 0;
        int index = 0;
        for (int x = dealerHand.size(); x > 0; x--)
        {
            count = convertToNumber(index);
            count++;
        }
        return (count);
    }

    public static int convertToNumber(int index)
    {
        String number = dealerHand.get(index).toString();
        return(Integer.parseInt(String.valueOf(number.charAt(1))));
    }

}
