//main.java
package ThomasPrograms;

public class Main
{
    static startGame start = new startGame();
    static rules rules = new rules();
    static mainGame game = new mainGame();
    static void main()
    {
        start.startGame();
        rules.rules();
        game.game();
    }
}