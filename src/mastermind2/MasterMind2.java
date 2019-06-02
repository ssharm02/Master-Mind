
package mastermind2;

/**
 *
 * @author sarth
 */
public class MasterMind2 {

    public static String[][] board = new String[10][4];
    public static int[] tempComp;
    public static String[] computerNum = new String[10];

    public static void main(String[] args) {
        // Calling the MM class with all methods
        MM mastermind = new MM();
        // Initialize the board
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = "";
            }
        }

        for (int i = 0; i < 10; i++) {
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

            if (Integer.parseInt(computerNum[i]) == 2222) {
                mastermind.finalUpdateGame(board, computerNum, tempComp);
            } else {
                mastermind.updateGame(board, computerNum);
            }
        }
    }
}