//betCredits.java
package ThomasPrograms;

import java.util.Scanner;

public class betCredits
{
    static int betAmount;

    public static int bet(Float credits)
    {
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            System.out.println("You have " + credits + " credits.");
            try
            {
                System.out.println("How many credits do you want to bet?");
                betAmount = Integer.parseInt(sc.nextLine());
            }
            catch (Exception e) {
                System.out.println("Please input an value.");
                continue;
            }
            if (betAmount > credits)
            {
                System.out.println("You only have " + credits + ". Please bet an amount you can afford.");
                continue;
            }
            System.out.println("You are betting " + betAmount + " credits.\n\n");
            break;
        }
        return betAmount;
    }
}