 /**
  * In this main class will ask the user for input expressions, and call the
  *  convertToPostfix method in the PostFix class. And display the output 
  *  posFix expression. Use a loop to continually prompt for input and
  *  generate output until the user enters quit.
  *  
  * @author MohamedElsheikh
  * @version 05, CS 2050, 2
  * 
  * Inspiration quote - " When you have a dream, you've got to grab it and 
  *  never let go."
  *  Carol Burnett (1933).
  */
 import java.util.Scanner;

 public class MohamedElsheikh_05 {
	
	 public static void main(String[] args) throws Exception{
		
	    Postfix call  = new Postfix(); // Access to the Postfix  calss
	    Scanner  console = new Scanner(System.in); // Access the input 
	   
	    String output [] = new String [100];  // Output the PostFix expression
	    String inputExpression  = " ";        // Input the inFix expression
	    int  postFixdNumber = 0 ;             // The number of output postfix
	    
       while ( !inputExpression.equals("quit") ) {
    	   
           postFixdNumber ++ ;
           System.out.print("\n Enter the infix expression"
           		+ " (with space in between to end enter 'quit'): ");
           inputExpression = console.nextLine();
           String postFix = call.convertToPostFix(inputExpression);
           output [postFixdNumber] = postFix ;
       } // Edn while loop
       
       for ( int i = 1 ; i < postFixdNumber ; i++ ) {
           System.out.println("\n This expression converted to postfix is : " 
                + output[i]);
  	    } // End for loop
       
       // Close the results 
       console.close();
       System.exit(0);
    } // End main method 
 } // End class
