package ThomasPrograms;

import java.util.ArrayList;
import java.util.List;

public class mainGame
{
    static List deck = shuffle.createDeck();
    static List hand = new ArrayList<>();
    public void game()
    {
        draw();
        while (true)
        {
            System.out.println(hand);
            String input = IO.readln("Hit or Stand?\n");
            input = optimizations.decapitalizeInput(input);
            if (input.equals("hit"))
            {
                System.out.println("You drew a " + deck.getFirst() + "!");
                draw();
            }
            else if (input.equals("stand"))
            {
                System.out.println("You stood.");
            }
            else
            {
                System.out.println("Invalid input. Please input hit or stand.");
            }
        }
    }

    public void draw()
    {
        hand.add(deck.getFirst());
        deck.removeFirst();
    }
}
