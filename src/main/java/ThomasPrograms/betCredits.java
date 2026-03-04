package ThomasPrograms;

public class betCredits
{
    static int betAmount;

    public static int bet(Float credits)
    {
        while (true)
        {
            System.out.println("You have " + credits + " credits.");
            try
            {
                betAmount = Integer.parseInt(IO.readln("How many credits do you want to bet?\n"));
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