
package mastermind2;

/**
 *
 * @author sarth
 */
public class MasterMind2 {

    public static String[][] board = new String[10][4];
    public static int[] tempComp;
    public static String[] computerNum = new String[10];
    public static int num_tries = 10;
    public static int correct_code = 2222;
    public static int guess_times = 4;

    public static void main(String[] args) {
        // Calling the MM class with all methods
        MM mastermind = new MM();
        // Initialize the board
        for (int tries = 0; tries < num_tries; tries++) {
            for (int guess_num = 0; guess_num < guess_times; j++) {
                board[tries][guess_num] = "";
            }
        }

        for (int i = 0; i < num_tries; i++) {
            computerNum[i] = "    ";
        }
        // Call the draw game method
        mastermind.drawGame();
        tempComp = mastermind.generateCompNum();
        // give user 10
        for (int i = 9; i > 0; i--) {
            int temp[] = mastermind.newGame();
            for (int j = 0; j < 4; j++) {
                board[i][j] += temp[j];
            }
            computerNum[i] = mastermind.checkValues(board[i], tempComp);

            if (Integer.parseInt(computerNum[i]) == correct_code) {
                mastermind.finalUpdateGame(board, computerNum, tempComp);
            } else {
                mastermind.updateGame(board, computerNum);
            }
        }
    }
}