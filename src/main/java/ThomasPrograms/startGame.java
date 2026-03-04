//startGame.java
package ThomasPrograms;

public class startGame
{
    public String startGame()
    {
        clearCMD clear = new clearCMD();
        String shouldStart;
        while(true)
        {
             shouldStart = IO.readln("To start blackjack type blackjack.\nTo start slots type slots\n");
             shouldStart = optimizations.decapitalizeInput(shouldStart);
             if (shouldStart.equals("blackjack") || shouldStart.equals("slots"))
             {
                 break;
             }
             System.out.println("Not a valid input. Please input slots or blackjack.");
        }
        System.out.println("Starting.");
        optimizations.timer(500);
        System.out.println("Starting..");
        optimizations.timer(750);
        System.out.println("Starting...");
        optimizations.timer(500);
        clear.clearCMD();
        return (shouldStart);
    }
}