//blackjack.java
package ThomasPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class blackjack
{
    static List deck = shuffle.createDeck();
    static List playersHand = new ArrayList<>();
    static List player2Hand = new ArrayList<>();
    static List dealerHand = new ArrayList<>();
    static float credits = 10;
    static float betAmount;
    static String input;
    static int aceValue1;
    static int aceValue2;
    static int aceValue3;
    static int aceValue4;
    public void game()
    {
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            betAmount = betCredits.bet(credits);
            doubleDraw(dealerHand);
            System.out.println("The dealer has a " + dealerHand.get(1) + " and 1 flipped over card.");
            doubleDraw(player2Hand);
            System.out.println("The other player has a hand of " + player2Hand + ".");
            doubleDraw(playersHand);
            label:
            while (true)
            {
                System.out.println(playersHand);
                System.out.println("Hit or Stand?");
                String input = sc.nextLine();
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

            System.out.println("The other player starts their turn.");
            System.out.println("The other player has a hand of " + player2Hand.get(0) + " and " + player2Hand.get(1) + ".");
            int player2Total = handTotal(player2Hand);
            System.out.println("Their hand has a total of " + player2Total + ".\n");
            optimizations.timer(4000);
            while (true)
            {
                if (player2Total < 17)
                {
                    System.out.println("The other player hits.");
                    boolean isDrawable = draw(player2Hand);
                    if (isDrawable)
                    {
                        System.out.println("The dealer passes a card to the other player and flips it over.");
                        System.out.println("The other player drew a " + player2Hand.getLast() + ".");
                        player2Total = handTotal(playersHand);
                        System.out.println("The other player now has a total of " + player2Total + ".\n");
                        optimizations.timer(3000);
                        continue;
                    }
                    break;
                }
                System.out.println("The other player ends their with a " + player2Total + ". And a hand of " + player2Hand + ".\n");
                break;
            }
            optimizations.timer((1500));

            System.out.println("The dealer flips over a " + dealerHand.get(0) + ".");
            System.out.println("The dealer has a hand of " + dealerHand.get(0) + " and " + dealerHand.get(1) + ".");
            int dealersTotal = handTotal(dealerHand);
            System.out.println("The dealer has a total of " + dealersTotal + ".\n");
            optimizations.timer(4000);
            while (true)
            {
                if (dealersTotal < 17)
                {
                    System.out.println("The dealer flips a card over from the top of the deck.");
                    boolean isDrawable = draw(dealerHand);
                    if (isDrawable)
                    {
                        System.out.println("The dealer draws a " + dealerHand.getLast() + ".");
                        dealersTotal = handTotal(dealerHand);
                        System.out.println("The dealer has a total of " + dealersTotal + ".\n");
                        optimizations.timer(3000);
                        continue;
                    }
                    break;
                }
                System.out.println("The dealers ends his turn with a " + handTotal(dealerHand) + ". And a hand of " + dealerHand + ".\n");
                break;
            }
            boolean isWin = determineWin(playersTotal, dealersTotal, player2Total);
            if (isWin)
            {
                credits = credits + betAmount*2;
            }
            if (credits == 0)
            {
                System.out.println("Your all out of money.");
                break;
            }
            System.out.println("You now have " + credits + " credits.");
            System.out.println("Play again?");
            input = sc.nextLine();
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

    public boolean draw(List hand)
    {
        if (!deck.isEmpty())
        {
            String card = deck.getFirst().toString();
            hand.add(card);
            deck.removeFirst();
            final boolean isAce = String.valueOf(card.charAt(0)).equals("A");
            if (hand == playersHand && isAce)
            {
                assignAceValue(playersHand, card);
            } else if (hand == dealerHand && isAce)
            {
                assignAceValue(dealerHand, card);
            } else if (hand == player2Hand && isAce)
            {
                assignAceValue(player2Hand, card);
            }
            return true;
        }
        else
        {
            System.out.println("The deck is empty.");
            return false;
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
                case "C" -> value = aceValue1;
                case "D" -> value = aceValue2;
                case "H" -> value = aceValue3;
                case "S"  -> value = aceValue4;
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
    public static boolean determineWin(int playersTotal, int dealersTotal, int player2Total)
    {
        boolean isWin;
        if (playersTotal == dealersTotal)
        {
            System.out.println(" You tied.");
            isWin = true;
        }
        else if (playersTotal > dealersTotal && playersTotal <= 21)
        {
            System.out.println("You beat the dealer.");
            isWin = true;
        }
        else if (playersTotal < dealersTotal && dealersTotal <= 21)
        {
            System.out.println("You lost to the dealer.");
            isWin = false;
        }
        else if (playersTotal > dealersTotal)
        {
            System.out.println("You busted.");
            isWin = false;
        }
        else if (playersTotal == 21)
        {
            System.out.println("You won with exactly 21.");
            isWin = true;
        }
        else if (playersTotal > 21)
        {
            System.out.println("You both busted, but you had a lower total then the dealer.");
            isWin = true;
        }
        else
        {
            System.out.println("You beat the dealer.");
            isWin = true;
        }

        if (player2Total > dealersTotal)
        {
            System.out.println("\nThe other player won.\n");
        }
        else if (player2Total == dealersTotal)
        {
            System.out.println("\nThe other player tied with the dealer.\n");
        }
        else
        {
            System.out.println("\nThe other player lost.\n");
        }
        return isWin;
    }
    public void assignAceValue(List hand, String card)
    {
        switch (String.valueOf(card.charAt(7)))
        {
            case "C" -> aceValue1 = dertermineAce(hand);
            case "D" -> aceValue2 = dertermineAce(hand);
            case "H" -> aceValue3 = dertermineAce(hand);
            case "S" -> aceValue4 = dertermineAce(hand);
        }
    }

    public static int dertermineAce(List hand)
    {
        int aceValue;
        Scanner sc = new Scanner(System.in);
        if (hand == playersHand)
        {
            while (true)
            {
                System.out.println("You have a hand of " + playersHand + ".");
                System.out.println("You drew an ace. Do you want your ace to be an 11 or 1?");
                aceValue = Integer.parseInt(sc.nextLine());
                if (aceValue == 11 || aceValue == 1)
                {
                    break;
                }
                else
                {
                    System.out.println("Please input a 1 or 11.\n");
                }
            }
        }
        else
        {
            if (handTotal(hand) <= 10)
            {
                aceValue = 11;
            }
            else
            {
                aceValue = 1;
            }
        }
        return aceValue;
    }
}
