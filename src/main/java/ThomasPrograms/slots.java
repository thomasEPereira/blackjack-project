//slots.java
package ThomasPrograms;

import java.util.ArrayList;

public class slots
{
    static float credits = 1000;
    static float betAmount;
    static clearCMD clear = new clearCMD();
    static String[] symbols = {"♣", "$", "BAR", "7", "♦"};
    public void game()
    {
        while (true)
        {
            betAmount = betCredits.bet(credits);
            credits -= betAmount;
            System.out.println("""
                    -------------------------------
                    |                             |
                    |   -----    -----    -----   |
                    |   |   |    |   |    |   |   |
                    |   -----    -----    -----   |
                    |             ___             |
                    |            |___|            |
                    |             | |             |
                    |             | |             |
                    -------------------------------
                    """);
            while (true)
            {
                String input = IO.readln("\nPull the lever.\n");
                if (optimizations.decapitalizeInput(input).equals("pull"))
                {
                    break;
                }
                System.out.println("Please input pull to pull the lever.");
            }
            clear.clearCMD();
            System.out.println("""
                    -------------------------------
                    |                             |
                    |   -----    -----    -----   |
                    |   |   |    |   |    |   |   |
                    |   -----    -----    -----   |
                    |                             |
                    |             ___             |
                    |            |___|            |
                    |             | |             |
                    -------------------------------
                    """);
            optimizations.timer(500);
            clear.clearCMD();
            System.out.println("""
                    -------------------------------
                    |                             |
                    |   -----    -----    -----   |
                    |   |   |    |   |    |   |   |
                    |   -----    -----    -----   |
                    |                             |
                    |                             |
                    |             ___             |
                    |            |___|            |
                    -------------------------------
                    """);
        }
    }
}
