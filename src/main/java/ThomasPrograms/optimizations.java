//optimizations.java
package ThomasPrograms;

public class optimizations
{
    public static String decapitalizeInput(String str)
    {
        if (str == null || str.isEmpty())
        {
            return str;
        }
        return str.toLowerCase().replaceAll("\\.", "");
    }

    public static int timer(int n)
    {
        try
        {
            Thread.sleep(n);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        return n;
    }
}

