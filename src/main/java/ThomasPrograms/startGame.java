//startGame.java
package ThomasPrograms;

public class startGame
{
    public void startGame()
    {
        clearCMD clear = new clearCMD();
        while(true)
        {
             String shouldStart = IO.readln("To start the game type start.\n");
             shouldStart = optimizations.decapitalizeInput(shouldStart);
             if (!shouldStart.equals("start"))
             {
                 System.out.println("Not a valid input. Please input start.");
                 continue;
             }
             break;
        }
        System.out.println("Starting.");
        optimizations.timer(500);
        System.out.println("Starting..");
        optimizations.timer(750);
        System.out.println("Starting...");
        optimizations.timer(500);
        clear.clearCMD();
    }
}

