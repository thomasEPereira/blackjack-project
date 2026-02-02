package ThomasPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class mainGame
{
    static List deck = shuffle.createDeck();
    static List playersHand = new ArrayList<>();
    static List dealerHand = new ArrayList<>();
    public void game()
    {
        while (true)
        {
            doubleDraw(dealerHand);
            System.out.println("The dealer has a " + dealerHand.get(1) + " and 1 flipped over card.");
            doubleDraw(playersHand);
            label:
            while (true)
            {
                System.out.println(playersHand);
                String input = IO.readln("Hit or Stand?\n");
                input = optimizations.decapitalizeInput(input);
                switch (input)
                {
                    case "hit":
                        System.out.println("You drew a " + deck.getFirst() + "!");
                        draw(playersHand);
                        break;
                    case "stand":
                        System.out.println("You stood.");
                        break label;
                    case "double":
                        System.out.println("You drew a " + deck.getFirst() + "and a " + deck.get(1));
                        doubleDraw(playersHand);
                        break;
                    default:
                        System.out.println("Invalid input. Please input hit or stand.");
                        break;
                }
            }
            int playersTotal = handTotal(playersHand);
            System.out.println("You have a total of " + playersTotal + ".\n");
            optimizations.timer(1500);
            System.out.println("The dealer flips over a " + dealerHand.get(0) + ".");
            System.out.println("The dealer has a hand of " + dealerHand.get(0) + " and " + dealerHand.get(1) + ".");
            int dealersTotal = handTotal(dealerHand);
            System.out.println("The dealer has a total of " + dealersTotal + ".\n");
            optimizations.timer(5000);
            while (true)
            {
                if (dealersTotal < 17)
                {
                    System.out.println("The dealer flips a card over from the top of the deck.");
                    draw(dealerHand);
                    System.out.println("The dealer draws a " + dealerHand.getLast() + ".");
                    dealersTotal = handTotal(dealerHand);
                    System.out.println("The dealer has a total of " + dealersTotal + ".\n");
                    optimizations.timer(3000);
                    continue;
                }
                System.out.println("The dealers ends his turn with a " + handTotal(dealerHand) + ". And a hand of " + dealerHand + ".");
                break;
            }
            determineWin(playersTotal,dealersTotal);
            String input = IO.readln("Play again?\n");
            if (Objects.equals(optimizations.decapitalizeInput(input), "yes"))
            {
                System.out.println("Restarting\n\n\n");
                optimizations.timer(500);
                deck = shuffle.createDeck();
                clearHand(playersHand);
                clearHand(dealerHand);
            }
            else
            {
                System.out.println("Quiting game.");
                break;
            }
        }
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

    public static int handTotal(List hand)
    {
        int count = 0;
        int index = 0;
        for (int x = hand.size(); x > 0; x--)
        {
            count += convertToNumber(index, hand);
            index++;
        }
        return (count);
    }

    public static int convertToNumber(int index, List hand)
    {
        String num = hand.get(index).toString();
        String number = String.valueOf(num.charAt(0));
        int value;
        if (number.equals("J") || number.equals("K") || number.equals("Q"))
        {
            value = 10;
        }
        else if (number.equals("A"))
        {
            value = 1;
        }
        else
        {
            if (String.valueOf(num.charAt(1)).equals("0"))
            {
                value = 10;
            }
            else
            {
                value = Integer.parseInt(number);
            }
        }
        return(value);
    }
    public void clearHand(List hand)
    {
        while (!hand.isEmpty())
        {
            hand.removeFirst();
        }
    }
    public void determineWin(int playersTotal, int dealersTotal)
    {
        if (playersTotal == dealersTotal)
        {
            System.out.println("You tied.");
        }
        else if (playersTotal > dealersTotal && playersTotal <= 21)
        {
            System.out.println("You beat the dealer.");
        }
        else if (playersTotal < dealersTotal && dealersTotal <= 21)
        {
            System.out.println("You lost to the dealer.");
        }
        else if (playersTotal > dealersTotal)
        {
            System.out.println("You busted.");
        }
        else if (playersTotal == 21)
        {
            System.out.println("You won with exactly 21.");
        }
        else if (playersTotal > 21)
        {
            System.out.println("You both busted, but you had a lower total then the dealer.");
        }
        else
        {
            System.out.println("You beat the dealer.");
        }
    }
}
