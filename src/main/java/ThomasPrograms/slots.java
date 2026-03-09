//slots.java
package ThomasPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class slots
{
    static float credits = 1000;
    static float betAmount;
    static String machineSlot1;
    static String machineSlot2;
    static String machineSlot3;
    static clearCMD clear = new clearCMD();
    static String[] symbols = {"♦", "7", "★", "$", "♣"};
    public void game()
    {
        List probabilitys = setProbability();
        System.out.println(probabilitys);
        while (true)
        {
            betAmount = betCredits.bet(credits);
            credits -= betAmount;
            System.out.println("""
                    -------------------------------
                    |                             |
                    |   -----    -----    -----   |
                    |   |   |    |   |    |   |   |
                    |   -----    -----    -----   |     __
                    |                             |    / /
                    |                             |   / /
                    |                             |  / /
                    |                             | /_/
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
                    |   -----    -----    -----   |       __
                    |                             |      / /
                    |                             |     / /
                    |                             |   / /
                    |                             | /_/
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
                    |                             |       __
                    |                             |     / /
                    |                             |   / /
                    |                             | /_/
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
                    |                             |    __
                    |                             |   / /
                    |                             | / /
                    -------------------------------
                    """);
            optimizations.timer(500);
            clear.clearCMD();
            randomizeSlots();
            System.out.println("""
                    -------------------------------
                    |                             |
                    |   -----    -----    -----   |
                    |   |   |    |   |    |   |   |
                    |   -----    -----    -----   |
                    |                             |
                    |                             |    __
                    |                             |   / /
                    |                             | / /
                    -------------------------------
                    """);
        }
    }
    private void randomizeSlots()
    {
        machineSlot1 = Random.from()
    }
    private static List setProbability()
    {
        List<String> options = new ArrayList<>();
        int x = 5;
        while (!(x == 30))
        {
            for (int i = 0; i < x; i++)
            {
                options.add(symbols[(x/5)-1]);
            }
            x += 5;
        }
        System.out.println(options);
        return options;
    }
}
