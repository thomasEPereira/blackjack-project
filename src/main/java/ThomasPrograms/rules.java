//rules.java
package ThomasPrograms;

public class rules
{
    static clearCMD clear = new clearCMD();
    public void rules(String game)
    {
        if (game.equals("blackjack"))
        {
            System.out.println("----BLACKJACK----");
            System.out.println(" --How To Play--");
            IO.readln("In Blackjack your goal is to get you cards to add up 21 without going over.\nWhen it is your turn you can say HIT to draw a card, DOUBLE to draw 2 cards, STAND to pass your turn.\nYou can type SHOP during your turn in order to view upgrades you can buy with your credits.\nWhen you run out of credits you lose and have to restart.\nType anything once you read the rules to continue.\n");
            clear.clearCMD();
        }
        else
        {
            System.out.println("----SLOTS----");
            System.out.println(" --How To Play--");
            IO.readln("In slots you bet money and pull a lever. You either lose or gain money based on a 3 element output.\nYou get payed out anywhere from 5x-1000x from a 3 of a kind depending on the symbol.\nThe combinations and payouts are in the chart below.\n" +
                    "----------------------------\n" +
                    "|    COMBO    |    PAYOUT   |\n" +
                    "|     ♣♣♣     |     5x      |\n" +
                    "|     $$$     |     10x     |\n" +
                    "|    3xBAR    |     30x     |\n" +
                    "|     777     |     200x    |\n" +
                    "|     ♦♦♦     |    1000x    |\n" +
                    "----------------------------\n" +
                    "You can also get a Wildcard represented by *\nWildcards can be used as any symbol.\nAfter making a bet, type pull to start rolling symbols.\n\nType anything to start to the game");
            clear.clearCMD();
        }
    }
}
