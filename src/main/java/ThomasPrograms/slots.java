//slots.java
package ThomasPrograms;

import java.util.*;

public class slots
{
    static float credits = 100;
    static float betAmount;
    static String machineSlot1;
    static String machineSlot2;
    static String machineSlot3;
    static clearCMD clear = new clearCMD();
    static String[] symbols = {"♦", "7", "¢", "$", "♣"};
    public void game()
    {
        Scanner sc = new Scanner(System.in);
        List probability = setProbability();
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
                System.out.println("\nPull the lever.");
                String input = sc.nextLine();
                if (optimizations.decapitalizeInput(input).equals("pull") || optimizations.decapitalizeInput(input).isEmpty())
                {
                    break;
                }
                System.out.println("Please input pull or nothing to pull the lever.");
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
            randomizeSlots(probability);
            System.out.println("-------------------------------\n" +
                    "|                             |\n" +
                    "|   -----    -----    -----   |\n" +
                    "|   | "+ machineSlot1 +" |    | "+ machineSlot2 +" |    | "+ machineSlot3 +" |   |\n" +
                    "|   -----    -----    -----   |\n" +
                    "|                             |\n" +
                    "|                             |    __\n" +
                    "|                             |   / /\n" +
                    "|                             | / /\n" +
                    "-------------------------------\n");
            optimizations.timer(500);
            clear.clearCMD();
            randomizeSlots(probability);
            System.out.println("-------------------------------\n" +
                               "|                             |\n" +
                               "|   -----    -----    -----   |\n" +
                               "|   | "+ machineSlot1 +" |    | "+ machineSlot2 +" |    | "+ machineSlot3 +" |   |\n" +
                               "|   -----    -----    -----   |\n" +
                               "|                             |\n" +
                               "|                             |    __\n" +
                               "|                             |   / /\n" +
                               "|                             | / /\n" +
                               "-------------------------------\n");
            optimizations.timer(250);
            clear.clearCMD();
            randomizeSlots(probability);
            System.out.println("-------------------------------\n" +
                               "|                             |\n" +
                               "|   -----    -----    -----   |\n" +
                               "|   | "+ machineSlot1 +" |    | "+ machineSlot2 +" |    | "+ machineSlot3 +" |   |\n" +
                               "|   -----    -----    -----   |\n" +
                               "|                             |\n" +
                               "|                             |    __\n" +
                               "|                             |   / /\n" +
                               "|                             | / /\n" +
                               "-------------------------------\n");
            optimizations.timer(250);
            clear.clearCMD();
            randomizeSlots(probability);
            System.out.println("-------------------------------\n" +
                               "|                             |\n" +
                               "|   -----    -----    -----   |\n" +
                               "|   | "+ machineSlot1 +" |    | "+ machineSlot2 +" |    | "+ machineSlot3 +" |   |\n" +
                               "|   -----    -----    -----   |\n" +
                               "|                             |\n" +
                               "|                             |    __\n" +
                               "|                             |   / /\n" +
                               "|                             | / /\n" +
                               "-------------------------------\n");
            System.out.printf("You have a combo of %s, %s, and %s.%n", machineSlot1, machineSlot2, machineSlot3);
            int payout = winCon();
            System.out.println("You got payed out " + payout + " : 1.\n");
            credits += betAmount*payout;
            if (credits == 0)
            {
                System.out.println("You have zero credits and leave.");
                break;
            }
            System.out.println("You now have " + credits + " credits.\n\n");
            System.out.println("Would you like to leave?");
            String leave = sc.nextLine();
            if (optimizations.decapitalizeInput(leave).equals("yes")) {break;}
        }
    }
    private void randomizeSlots(List probability)
    {
        Random r = new Random();
        machineSlot1 = probability.get(r.nextInt(probability.size())).toString();
        machineSlot2 = probability.get(r.nextInt(probability.size())).toString();
        machineSlot3 = probability.get(r.nextInt(probability.size())).toString();
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
        return options;
    }
    private static int winCon()
    {
        int payout = 0;
        if (machineSlot1.equals(machineSlot2) && machineSlot1.equals(machineSlot3))
        {
            switch (machineSlot1)
            {
                case "♦" -> payout = 1000;
                case "7" -> payout = 200;
                case "¢" -> payout = 30;
                case "$" -> payout = 10;
                case "♣" -> payout = 5;
            }
        }
        else if (machineSlot1.equals(machineSlot2) || machineSlot1.equals(machineSlot3))
        {
            switch (machineSlot1)
            {
                case "♦" -> payout = 100;
                case "7" -> payout = 50;
                case "¢" -> payout = 5;
                case "$" -> payout = 3;
                case "♣" -> payout = 2;
            }
        }
        else if (machineSlot2.equals(machineSlot3))
        {
            switch (machineSlot2)
            {
                case "♦" -> payout = 100;
                case "7" -> payout = 50;
                case "¢" -> payout = 5;
                case "$" -> payout = 3;
                case "♣" -> payout = 2;
            }
        }
        else if (machineSlot1.equals("♦") || machineSlot2.equals("♦") || machineSlot3.equals("♦"))
        {
            payout = 1;
        }
        else
        {
            System.out.println("you got nothing.");
        }
        return payout;
    }
}
