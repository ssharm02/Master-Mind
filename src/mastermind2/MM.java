/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind2;
import java.util.*;
import java.util.regex.*;
/**
 *
 * @author sarth
 */
public class MM implements MasterMindInterface {
    
    String[][] grid = new String[10][4];
    
    /*
    * DrawGame Void method draws the grid 
    */
    @Override
    public void drawGame() 
    {
        System.out.println("------------------------");
        System.out.println("|  " + "X" + "  |  " + "X" + "  |  " + "X" + "  |  " + "X" + "  |");
        System.out.println("------------------------    -----");
        
        for (int i = 0; i < grid.length; i++) {
            System.out.println("|  "  +  "  |  " + "  |  " + "  |  "  +  "  |==|    |    |");  
            
            System.out.println("------------------------    -----");
        }
    }//End of Draw Game method
    
    /*
    * New Game method asks the user to type in 4 unique numbers
    *Returns the numbers at the end
    *@Param unserInput - an array where the 4 numbers entered by the user are stored
    */
    @Override
    public int [] newGame()
    {
        //Regular expression so only numbers are entered
        String match = "[0-9]+";
        Pattern p = Pattern.compile(match);
        Scanner input = new Scanner(System.in);
        int [] userInput = new int[4];
        System.out.println("Please enter a unique 4 digit number with spaces in between");
        try 
        {
        String userNum = input.nextLine();
          
        Matcher m = p.matcher(userNum);
         
        if (m.find())
        {
        String [] tempNum  = userNum.split(" ");
        userInput[0] = Integer.parseInt(tempNum[0]);
        userInput[1] = Integer.parseInt(tempNum[1]);
        userInput[2] = Integer.parseInt(tempNum[2]);
        userInput[3] = Integer.parseInt(tempNum[3]);
        }
        else 
        {
        System.out.println("Invalid entry by user nothing was found");    
        }
        }
         catch(ArrayIndexOutOfBoundsException ex){}
        return userInput;
    }
    
    /*
    * Method generates 4 digit random number between 1 and 8
    */   
    @Override
    public int [] generateCompNum()
    {
    int [] random = new int [4];
    List<Integer>compNumber = new ArrayList<>(4);
    //add numbers 1 to 8 in the list
    for (int i = 1; i <= 8; i++) 
    {
        compNumber.add(i);
    }
       //Shuffle the list
       Collections.shuffle(compNumber);   
       //Put for random numbers into the secondary list after shuffle
       for (int i = 0; i < random.length; i++)
       {
       random[i] = compNumber.get(i);
       }

      //System.out.println(Arrays.toString(random));
       return random;
    }
    
    @Override
    public String checkValues(String [] userInput, int [] computerNumber)
    {
   int flag = 0;
   String [] validate = {""};
   //Results can be put inside an int array 
   //int  [] results = new int[4];
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            if (Integer.parseInt(userInput[i]) == computerNumber[j]) {
               if (i==j) {
                   validate[0]+="2";
                   flag++ ;
                }
            }
        }
    }
 for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            if (Integer.parseInt(userInput[i])==computerNumber[j] && (i!=j)) {
                validate[0]+="1";
                flag++;
            }
        }
    }
 switch(flag) 
 {
     case 0: validate[0]+="0000"; break;
     case 1: validate[0]+="000"; break;
     case 2: validate[0]+="00"; break;
     case 3: validate[0]+="0"; break;
 }
    return validate[0];
    }//End of checkValue method
    
    @Override
        public void updateGame(String[][] resultArray,String[] clueArray) {
        System.out.println(" ---------------");
        System.out.println("| "+"X"+" | "+"X"+" | "+"X"+" | "+"X"+" | ");
        
        for(int i=0;i<10;i++){
        System.out.println(" ---------------"+"     ----");
        System.out.println("| "+resultArray[i][0]+" | "+resultArray[i][1]+" | "+resultArray[i][2]+" | "+resultArray[i][3]+" | "+"=="+"|"+clueArray[i]+"|");
        }
        System.out.println(" ---------------"+"     ----");
        System.out.println("");
    
    }
    
    
    public void finalUpdateGame(String [][] resultArray, String[] clueArray, int [] secretCodeArray)
    {
        System.out.println(" ---------------");
        System.out.println("| "+secretCodeArray[0]+" | "+secretCodeArray[1]+" | "+secretCodeArray[2]+" | "+secretCodeArray[3]+" | ");
        
        for(int i=0;i<10;i++){
            System.out.println(" ---------------"+"     ----");
            System.out.println("| "+resultArray[i][0]+" | "+resultArray[i][1]+" | "+resultArray[i][2]+" | "+resultArray[i][3]+" | "+"=="+"|"+clueArray[i]+"|");
        }
        
        System.out.println(" ---------------"+"     ----");
        
        System.exit(0);
    }
}
