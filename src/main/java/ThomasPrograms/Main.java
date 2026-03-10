//main.java
package ThomasPrograms;

public class Main
{
    static startGame start = new startGame();
    static rules rules = new rules();
    static blackjack blackjack = new blackjack();
    static slots slots = new slots();
    static void main()
    {
        String game = start.startGame();
        if (game.equals("blackjack"))
        {
            rules.rules(game);
            blackjack.game();
        }
        else if (game.equals("slots"))
        {
            rules.rules(game);
            slots.game();
        }
    }
}