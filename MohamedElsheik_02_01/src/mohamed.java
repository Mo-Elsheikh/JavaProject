
import java.util.Scanner;
import java.util.Stack;

public class mohamed{

   // function to return the precedence of the operator
   public static int precedence(String ch) {
	  switch(ch) {
	       case "+" :
           case "-" : return 1;      
           case "*" :
	       case "/" :        
	       case "%" : return 2;

	                  }
	                              return -1;

	               }

	              

	               public static boolean isOperator(String oper)

	               {

	                              if(oper.equals("+") || oper.equals("-")|| oper.equals("*") || oper.equals("/") || oper.equals("%"))

	                                             return true;

	                              return false;

	               }

	               // function to convert an infix expression to postfix

    public static StringBuffer convertToPostfix (StringBuffer infix)

	               {

	                              StringBuffer result = new StringBuffer(""); // result returns the postfix expression

	                              Stack<String> stack = new Stack<String>();

	                              String[] inputs = infix.toString().split(" ");// split the input into the array

	                              for(int i=0;i<inputs.length;i++)

	                              {

	                                             // if input if a operator

	                   if(isOperator(inputs[i]))

	                  {              // continue while operator on stack has a precedence <= input operator

	               while(!stack.isEmpty() && precedence(inputs[i]) <= precedence(stack.peek()))

	                  {

	                    result = result.append(stack.pop()+" "); // add the operator to the result

	                  }

	                  stack.push(inputs[i]); // push the input operator to the stack

	                  }// if opening parenthesis

	                  else if(inputs[i].equals("("))

	                   {

	                 stack.push(inputs[i]);

	                  } // if closing parenthesis

	                 else if(inputs[i].equals(")"))

	                {

	                 while(!stack.isEmpty() && !stack.peek().equals("("))

	                        result = result.append(stack.pop()+" ");

	                       if(!stack.isEmpty() && !stack.peek().equals("("))

	                         return new StringBuffer("Invalid Expression");

	                         else if(stack.isEmpty())

	                        return new StringBuffer("Invalid Expression");

	                        else

	                        stack.pop();

	                        } // if operand

	                        else

	                           result= result.append(inputs[i] +" ");

	                         }

	                        // add all the operators from stack to the result

	                        while(!stack.isEmpty())

	                        {

	                       if(stack.peek().equals("("))

	                         return new StringBuffer("Invalid Expression");

	                         result = result.append(stack.pop()+" ");

	                         }

	                             

	                   result = new StringBuffer(result.toString().trim()); // trim will remove the last space from string

	                  return result;

	                                                           

	               }

	              

	               public static void main(String[] args) throws Exception {

	                              Scanner scan = new Scanner(System.in);

	                              System.out.print("\n Enter the infix expression(with space in between): ");

	                              StringBuffer inputExp = new StringBuffer(scan.nextLine());

	                              StringBuffer postfix = convertToPostfix (inputExp);

	                              System.out.println("\n This expression converted to postfix is : " +postfix);

	                              scan.close();

	               }

	}

	// end of program

