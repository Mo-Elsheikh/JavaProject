 /**
  *  In this class will implemented in a stack class. 
  *   It uses generic object (T) and can be used to implement a 
  *   stack class to store generic objects. 
  * @author MohamedElsheikh
  */
 import java.util.EmptyStackException;
 public class MyStack<T> {
	
	private T [] stack;    // Stack array of the entries
	private int topIndex;  // Index of the entries
	
	/**
	 * Constructor to initialize the stack array and the topIndex
	 */
    public MyStack () {
		 @SuppressWarnings("Unchecked")
		 T [] temp = (T[]) new Object[100];
		 stack = temp ;
		 topIndex = -1;
	 } // End the constructor
    
 /****************************************************************************/	
	/**
	 * Adds a new entry to this stack
	 * @param newEntry The object to be added to the stack
	 */
	public void push(T newEntry) {
		
	   stack[topIndex + 1] = newEntry;
	   topIndex++;
	} // End push
	
 /****************************************************************************/
	/**
	 * Check the entry on the stack
	 * @return The last entry on the stack
	 */
	public T peek() {
	
	   if ( isEmpty() )
	      throw new EmptyStackException();
	   else
	      return stack[topIndex];
	} // End peek
	
 /****************************************************************************/
	/**
	 *  Removed the last entry of the stack
	 * @return The last entry on the stack.
	 */
	public T pop() {
	   
	   if ( isEmpty() ) {
	      throw new EmptyStackException();
	   } // End if   
	   else {
	      T top = stack[topIndex];
	      stack[topIndex] =  null;
	      topIndex--;
	      return top;
	   } // End else
	} // End pop
	
/*****************************************************************************/	
	/**
	 * Check to see if the stack is empty.
	 * @return True if the stack is empty, or false if not.
	 */
	public boolean isEmpty() {
		
	   return topIndex < 0;
	} // End isEmpty

 /****************************************************************************/
	/**
	 * Removes all entries from this stack.
	 */
	public void clear() {
		
	   topIndex = -1 ;
	} // End clear
 } // End clase

