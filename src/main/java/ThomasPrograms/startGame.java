//startGame.java
package ThomasPrograms;

import java.util.Scanner;

public class startGame
{
    public String startGame()
    {
        clearCMD clear = new clearCMD();
        String shouldStart;
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("To start blackjack type blackjack.\nTo start slots type slots.");
            shouldStart = sc.nextLine();
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