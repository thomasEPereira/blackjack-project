//rules.java
package ThomasPrograms;

public class rules
{
    static clearCMD clear = new clearCMD();
    public void rules()
    {
        System.out.println("----BLACKJACK----");
        System.out.println(" --How To Play--");
        IO.readln("In Blackjack your goal is to get you cards to add up 21 without going over.\nWhen it is your turn you can say HIT to draw a card, DOUBLE to draw 2 cards, STAND to pass your turn.\nYou can type SHOP during your turn in order to view upgrades you can buy with your credits.\nWhen you run out of credits you lose and have to restart.\nType anything once you read the rules to continue.\n");
        clear.clearCMD();
    }
}
