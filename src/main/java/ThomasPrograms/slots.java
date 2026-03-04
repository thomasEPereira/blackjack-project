package ThomasPrograms;

public class slots
{
    static float credits = 100;
    static float betAmount;
    public void game()
    {
        while (true)
        {
            betAmount = betCredits.bet(credits);
            credits -= betAmount;
            break;
        }
    }
}
