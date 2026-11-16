
import java.util.Scanner;

public class SafeInput
{
    public static int getRangedInt(Scanner console, String prompt, int low, int high)
    {
        int number;

        while (true)
        {
            System.out.print(prompt);

            if (console.hasNextInt())
            {
                number = console.nextInt();

                if (number >= low && number <= high)
                {
                    return number;
                }
            }
            else
            {
                console.next();
            }

            System.out.println("Enter a number between " + low + " and " + high);
        }
    }

    public static boolean getYNConfirm(Scanner console, String prompt)
    {
        System.out.print(prompt);
        String answer = console.next();

        while (!answer.equalsIgnoreCase("Y") &&
                !answer.equalsIgnoreCase("N"))
        {
            System.out.println("Enter Y or N.");
            System.out.print(prompt);
            answer = console.next();
        }

        return answer.equalsIgnoreCase("Y");
    }
}
