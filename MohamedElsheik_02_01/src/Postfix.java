/**
 * In this class will have only one method convertToPostfix.
 * It will convert the given infix expression to postfix expression and return
 * the postfix expreeion.
 * 
 * Operand : append each operand to the end of the output expression.
 * 
 * Operator ^ : push ^ onto stack
 * Operator +, - , *, / : pop Operators from the stack, appending them to the 
 *  output expression, until either the stack is empty or its top entry has 
 *  a lower precedence than the a stack operator. Then push the new operator 
 *  onto the  stack.
 *  
 *  Open parenthesis : push onto the satck.
 *  Close parenthesis : pop operator from the stack and append them to the 
 *  output expression until an open parenthesis is poped.
 *   
 * @author MohamedElsheikh
 * @version 05, CS 2050, 2
 */
 public class Postfix extends Object {
	 
    public String convertToPostFix (String inputExpression) throws Exception { 
	     
	   String result = " " ;  // The postFix expression
	   String[] input ;       // Input the expression
      
      MyStack operatorStack = new MyStack <String>(); // Access to the MyStack calss
	   input = inputExpression.split(" ") ; // Split the input into the array
      
	   for ( int i = 0 ; i < input.length  ; i++  ) {
      
		   if ( input[i].equals("+") 
			     || input[i].equals("-")
			     || input[i].equals("*") 
			     || input[i].equals("/") 
			     || input[i].equals("%")
			     || input [i].equals("^") ) {
             
		      if ( input[i].equals("+") || input[i].equals("-") ) { 
           
				   while ( ! operatorStack.isEmpty()  
                       && (operatorStack.peek().equals("^")
           			     || operatorStack.peek().equals("*")
           			     || operatorStack.peek().equals("+")
           			     || operatorStack.peek().equals("-")) ) {
                      
           		    result += operatorStack.pop() + " ";
           	   } // End while 
			   } //  End if
           
			   else if ( input[i].equals("*") || input[i].equals("/") ) {
           
				    while ( !operatorStack.isEmpty() 
	           			   &&(operatorStack.peek().equals("^")
	           			   || operatorStack.peek().equals("*")
	           			   || operatorStack.peek().equals("/"))) {
                      
	           		  result += operatorStack.pop() + " ";
	             } // End while
			   } //  End else if
           
			   else if ( input[i].equals("^") ) {
           
				    while ( !operatorStack.isEmpty() 
	           			   && operatorStack.peek().equals("^") ) {
                        
					     result += operatorStack.pop() + " ";
				    } // End while
			   } // End else if 
            
            // Push the input operator to the stack
			   operatorStack.push(input[i]);  
         } // End if
         // If opening parenthesis
         else if ( input[i].equals("(") ){
        
        	  operatorStack.push(input[i]);
         } // End else if 
        
         // If closing parenthesis
         else if ( input[i].equals(")") ) {
        
              while ( !operatorStack.isEmpty() 
            		    && !operatorStack.peek().equals("(") ) {
                      
        	        result += operatorStack.pop() + " ";
              } // End while
              
              if ( !operatorStack.isEmpty() 
                   && !operatorStack.peek().equals("(")) {
                   
                 return ("Invalid Expression");
              } // End if
              else if ( operatorStack.isEmpty()) {
               
                 return ("Invalid Expression");
              } // End else if
              else {
                 operatorStack.pop();
              } // End else
              } // End else if
         else {
              result += input[i] + " " ;
         } // End else
      } // End for loop
       
	   // Add all the operators from stack to the result
      while ( !operatorStack.isEmpty() ) {
       
           if ( operatorStack.peek().equals("(") ) {
                 return ("Invalid Expression");
            } // End if 
           else {
              result += operatorStack.pop() + " " ;
           } // End else
      } // End while 
      result = result.toString(); 
      return result;
   } // End convertToPostFix
 } // End class
 
 