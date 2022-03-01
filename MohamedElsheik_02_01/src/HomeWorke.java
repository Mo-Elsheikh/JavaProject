
 public class HomeWorke {
	Node headNode;
	public int iterativeFibonacciSequence( int n) { 
	   if ( n == 1 ) { 
	        return 0;
	   } // End if 
	   else if ( n == 2 ) {
	        return 1;
	   } // End else if 
	   else {
	         int f1 = 0 ;
	         int f2 = 1 ;
	         int fib = 0 ;

	         for ( int i = 3 ; i <= n ; i++ ) {
	               fib = f1 + f2;
	               f1 = f2;
	               f2 = fib;
	         } // End for loop
	         return fib;
	   } //End else
	} // End iterativeFibonacciSequence
	
 /****************************************************************************/	   
	// Recursive fibonacci sequence
	public int fibonacciSequence( int n) {
	   if ( n == 1 ) {
	        return 0; 
	   } // End if  
	   else if ( n == 2 ) {
	        return 1;
	    } // End else if
	   else {
	         return fibonacciSequence(n-1) + fibonacciSequence(n-2);
	   } // End else
	} // End    
	
 /****************************************************************************/	
	// Recursive factorial
	public int factorial( int n) {
	   if( n== 0 ) {
	       return 1;
	   } // End if
	   else {
	       return n * factorial(n - 1);
	   } // End else
    } // End factorial 
	
 /****************************************************************************/
	// Iterative factorial
	public int iterativeFactorial (int n) {
		int factorial = 1 ;
		for ( int i = 1 ; i <= n ; i++ ) {
			   factorial = factorial * i ; 
		} // End for loop
		return factorial;
    } // End iterativeFactorial
	
 /****************************************************************************/
	// Iterative search in the lincked list
	public boolean iterativeSearch(T data) {
		boolean found = false ;
	    Node temp = headNode;
	    while ( temp != null ) {
	       if ( temp.data.equals(data) ){
	        	found = true ; 
	        	temp = null ;
	       } // End if 
	       temp = temp.next;
	    } // End while 
	    return found ;
	} // End iterativeSearch
 /****************************************************************************/
	// Recursive sarch in the lincked list
	public boolean search( T data) {
	   Node temp = headNode;
	   if ( temp == null) {
	        return false; 
	   } // End if   
	   if ( temp.data.equals(data)) {
	        return true; 
	   } // End if 
	   return search(temp.next, data); 
	} // End search 
 } // End class HomeWorke
 /********************************************
 public class Postfix <T> {
		//public String convertToPostfix (StringBuffer inputExp) {
		
		   char open ;
		   char close ;
		   char topOperator ;
		   Stack operatorStack ;
		   String postfix = " " ;
		   while (infix has characters left to parse) { 
				  nextCharacter = next nonblank character of infix
				  switch(topOperator) {
				     case variable:
				           postfix = topOperator;
				     break
				     case '^' :
				          operatorStack.push(nextCharacter) 
				          break ;
				     case '+' : case '-' : case '*' : case '/' :
				          while (!operatorStack.isEmpty() and
				   	       precedence of nextCharacter <= precedence of operatorStack.peek()) {
				               Append operatorStack.peek() to postfix
				               operatorStack.pop(); 
				            } 
				           operatorStack.push(nextCharacter); 
				           break;

	                 case open == '(':
	                      operatorStack.push(nextCharacter); 
	                break ;
	               case close == ')': // Stack is not empty if infix expression is valid 
	                    topOperator = operatorStack.pop() ;
	                    while (topOperator != '(') {
	                    Append topOperator to postfix
	                    topOperator = operatorStack.pop();
	                    }
	               break ;
	               default: 
	              break ;// Ignore unexpected characters
	              } 
	          } 
	          while (!operatorStack.isEmpty())  {
	                topOperator = operatorStack.pop();
	                postfix = topOperator ; 
	               } 
	 return postfix;
		   
		             //( && close == ')') ||
		             //(open == '[' && close == ']') ||
		             //(open == '{' && close == '}');
		   
**/}
	}
