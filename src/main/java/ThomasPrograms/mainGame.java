package ThomasPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class mainGame
{
    static List deck = shuffle.createDeck();
    static List playersHand = new ArrayList<>();
    static List dealerHand = new ArrayList<>();
    static int credits = 10;
    static int betAmount;
    static String input;
    static String[] possibleAceValues = {String.valueOf(1),String.valueOf(11)};
    static int aceValue1 = 0;
    static int aceValue2 = 0;
    static int aceValue3 = 0;
    static int aceValue4 = 0;
    public void game()
    {
        while (true)
        {
            while (true)
            {
                System.out.println("You have " + credits + " credits.");
                try
                {
                    betAmount = Integer.parseInt(IO.readln("How many credits do you want to bet?\n"));
                }
                catch (Exception e)
                {
                    System.out.println("Please input an value.");
                    continue;
                }
                if (betAmount > credits)
                {
                    System.out.println("You only have " + credits + ". Please bet an amount you can afford.");
                    continue;
                }
                System.out.println("You are betting " + betAmount + " credits.\n\n");
                credits -= betAmount;
                break;
            }
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
                        System.out.println("You drew a " + deck.getFirst() + " and a " + deck.get(1));
                        doubleDraw(playersHand);
                        break;
                    case "credits":
                        System.out.println("You have " + credits + " credits.");
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
            boolean win = determineWin(playersTotal,dealersTotal);
            if (win)
            {
                credits += betAmount*2;
            }
            if (credits == 0)
            {
                System.out.println("Your all out of money.");
                break;
            }
            System.out.println("You now have " + credits + " credits.");
            input = IO.readln("Play again?\n");
            if (Objects.equals(optimizations.decapitalizeInput(input), "no"))
            {
                System.out.println("Quiting game.");
                System.out.println("You left with " + credits + " credits.");
                break;
            }
            else
            {
                System.out.println("Restarting\n\n\n");
                optimizations.timer(500);
                deck = shuffle.createDeck();
                clearHand(playersHand);
                clearHand(dealerHand);
                aceValue1 = 0;
                aceValue2 = 0;
                aceValue3 = 0;
                aceValue4 = 0;
            }
        }
    }

    public void draw(List hand)
    {
        String card = deck.getFirst().toString();
        hand.add(card);
        deck.removeFirst();
        if (hand == playersHand && String.valueOf(card.charAt(0)).equals("A"))
        {
            switch (String.valueOf(card.charAt(7)))
            {
                case "C" ->
                        aceValue1 = dertermineAce();
                case "D" ->
                        aceValue2 = dertermineAce();
                case "H" ->
                        aceValue3 = dertermineAce();
                case "S"  ->
                        aceValue4 = dertermineAce();
            }
        }
        else
        {
            switch (String.valueOf(card.charAt(7)))
            {
                case "C" ->
                {
                    if (handTotal(dealerHand) <= 10)
                    {
                        aceValue1 = 11;
                    }
                    else
                    {
                        aceValue1 = 1;
                    }
                }
                case "D" ->
                {
                    if (handTotal(dealerHand) <= 10)
                    {
                        aceValue2 = 11;
                    }
                    else
                    {
                        aceValue2 = 1;
                    }
                }
                case "H" ->
                {
                    if (handTotal(dealerHand) <= 10)
                    {
                        aceValue3 = 11;
                    }
                    else
                    {
                        aceValue3 = 1;
                    }
                }
                case "S" ->
                 {
                    if (handTotal(dealerHand) <= 10)
                    {
                        aceValue1 = 11;
                    }
                    else
                    {
                        aceValue2 = 1;
                    }
                }
            }
        }

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
        int value = 0;
        if (number.equals("J") || number.equals("K") || number.equals("Q"))
        {
            value = 10;
        }
        else if (number.equals("A"))
        {
            switch (String.valueOf(num.charAt(7)))
            {
                case "C" ->
                        value = aceValue1;
                case "D" ->
                        value = aceValue2;
                case "H" ->
                        value = aceValue3;
                case "S"  ->
                        value = aceValue4;
            }
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
    public static boolean determineWin(int playersTotal, int dealersTotal)
    {
        if (playersTotal == dealersTotal)
        {
            System.out.println("You tied.");
            return true;
        }
        else if (playersTotal > dealersTotal && playersTotal <= 21)
        {
            System.out.println("You beat the dealer.");
            return true;
        }
        else if (playersTotal < dealersTotal && dealersTotal <= 21)
        {
            System.out.println("You lost to the dealer.");
            return false;
        }
        else if (playersTotal > dealersTotal)
        {
            System.out.println("You busted.");
            return false;
        }
        else if (playersTotal == 21)
        {
            System.out.println("You won with exactly 21.");
            return true;
        }
        else if (playersTotal > 21)
        {
            System.out.println("You both busted, but you had a lower total then the dealer.");
            return true;
        }
        else
        {
            System.out.println("You beat the dealer.");
            return true;
        }
    }
    public static int dertermineAce()
    {
        int aceValue;
        while (true)
        {
            System.out.println("You have a hand of " + playersHand + ".");
            aceValue = Integer.parseInt(IO.readln("You drew an ace. Do you want your ace to be an 11 or a 1? "));
            if (aceValue == 11 || aceValue == 1){break;}
            else
            {
                System.out.println("Please input a 1 or 11.\n");
            }
        }
        return aceValue;
    }
}
