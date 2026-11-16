
import java.util.Scanner;

public class TicTacToe
{
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        boolean playAgain = true;

        do
        {
            clearBoard();
            String player = "X";
            boolean gameOver = false;

            while (!gameOver)
            {
                display();

                System.out.println("Player " + player + "'s turn");

                int row = SafeInput.getRangedInt(console, "Enter row (1-3): ", 1, ROWS) - 1;
                int col = SafeInput.getRangedInt(console, "Enter column (1-3): ", 1, COLS) - 1;

                while (!isValidMove(row, col))
                {
                    System.out.println("Space already taken. Try again.");

                    row = SafeInput.getRangedInt(console, "Enter row (1-3): ", 1, ROWS) - 1;
                    col = SafeInput.getRangedInt(console, "Enter column (1-3): ", 1, COLS) - 1;
                }

                board[row][col] = player;

                if (isWin(player))
                {
                    display();
                    System.out.println("Player " + player + " wins!");
                    gameOver = true;
                }
                else if (isTie())
                {
                    display();
                    System.out.println("It's a tie!");
                    gameOver = true;
                }
                else
                {
                    player = player.equals("X") ? "O" : "X";
                }
            }

            playAgain = SafeInput.getYNConfirm(console, "Play again? (Y/N): ");

        } while (playAgain);

        System.out.println("Thanks for playing!");
        console.close();
    }

    private static void clearBoard()
    {
        for (int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLS; c++)
                board[r][c] = " ";
    }

    private static void display()
    {
        for (int r = 0; r < ROWS; r++)
        {
            System.out.println(board[r][0] + " | " + board[r][1] + " | " + board[r][2]);

            if (r < ROWS - 1)
                System.out.println("--+---+--");
        }
    }

    private static boolean isValidMove(int row, int col)
    {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player)
    {
        return isRowWin(player) || isColWin(player) || isDiagnalWin(player);
    }

    private static boolean isRowWin(String player)
    {
        for (int r = 0; r < ROWS; r++)
            if (board[r][0].equals(player) &&
                    board[r][1].equals(player) &&
                    board[r][2].equals(player))
                return true;

        return false;
    }

    private static boolean isColWin(String player)
    {
        for (int c = 0; c < COLS; c++)
            if (board[0][c].equals(player) &&
                    board[1][c].equals(player) &&
                    board[2][c].equals(player))
                return true;

        return false;
    }

    private static boolean isDiagnalWin(String player)
    {
        if (board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player))
            return true;

        if (board[0][2].equals(player) &&
                board[1][1].equals(player) &&
                board[2][0].equals(player))
            return true;

        return false;
    }

    private static boolean isTie()
    {
        for (int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLS; c++)
                if (board[r][c].equals(" "))
                    return false;

        return true;
    }
}
