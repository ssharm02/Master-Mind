/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind2;

/**
 *
 * @author sarth
 */
public interface MasterMindInterface {

    public abstract void drawGame();

    public abstract int[] newGame();

    public abstract int[] generateCompNum();

    public abstract String checkValues(String[] userInput, int[] computerNum);

    public abstract void updateGame(String[][] resultArray, String[] clueArray);
}
