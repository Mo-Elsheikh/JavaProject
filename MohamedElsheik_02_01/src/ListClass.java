 /**
  * In this class we will implement the MyCollectionInterfaceProject04  
  * linckedist of Students and Grade Items and internal node class
  * 
  * @author MohamedElsheikh
  */
 public class ListClass <T> implements MyCollectionInterfaceProject04 <T> {
  
    private Node firstNode ;           // First node
    private int numberOfEntries = 0;   // Nubmer of entries
 
 /****************************************************************************/   
	@Override
    public boolean add(T newItem) {
		boolean found = false ;
		if( contains(newItem) ) {
			found = false ;
		} // End if 
		else {
			Node newNode = new Node(newItem);
			newNode.setNextNode(firstNode);
			firstNode = newNode ;
			found = true;
			numberOfEntries++;	
		} // End else 
		return found;
	} // End add()
	
 /****************************************************************************/	
	@Override
	public boolean add(T newItem, int position) {
		boolean found = false ;
      if ((position >= 1) && (position <= numberOfEntries + 1)) {
		      Node newNode = new Node(newItem);
		      if (position == 1) {
		         newNode.setNextNode(firstNode);
		         firstNode = newNode;
		         found = true ;
		         numberOfEntries++;
		      } // End if
		      else {
               Node nodeBefore = getNodeAt( position-1);
		         Node nodeAfter = nodeBefore.getNextNode();
		         newNode.setNextNode(nodeAfter);
		         nodeBefore.setNextNode((Node)newItem);
		      } // End else
		      numberOfEntries++;	
		} // End if
	   else {
		      throw new IndexOutOfBoundsException(
		                "Illegal position given to add operation.");
		} // else
		return false;
   } // End add
 /****************************************************************************/	
	@Override
	public boolean remove(T anEntry) {
		boolean found1 = false;
		T data = null;
		Node currentNode = firstNode ;
		Node pv = new Node (null);
		 if ( isEmpty() ) {
			 found1 = false ; 
		 } // End if
			 while ( (currentNode != null ) ) {
				 if ( currentNode.data.equals(anEntry) ) {
					 data = (T) currentNode.data;
					 pv.nextNode = currentNode.nextNode;
					 found1 = true ;
					 numberOfEntries--;
			 } // End if
				 pv = currentNode;
				 currentNode = currentNode.nextNode;
		  } // End while
	    return found1;
	} // End remove()
	
 /****************************************************************************/	
	@Override
	public void clear() {
		firstNode = null;
	} // End clear()

 /****************************************************************************/	
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	} // End getCurrentSize

 /****************************************************************************/
	@Override
	public boolean isEmpty() {
		boolean found = false ;
		if( numberOfEntries == 0 ) {
			 found = true ;
		} //  End if 
		else {
			found = false ;
		} // End else
		return found;
	} // End isEmpty()

 /****************************************************************************/	
	@Override
	public int getFrequencyOf(T anEntry) {
       int Frequency = 0 ;
       Node currentNode = firstNode;
       while (currentNode != null) {
    	   if ( currentNode.data.equals(anEntry) ) {
    		   Frequency++;
    	   } // End if
    	   currentNode = currentNode.nextNode;
       } // End while
		return Frequency;
	} // End getFrequencyOf
	
 /****************************************************************************/
	@Override
	public boolean contains(T anEntry) {
	   boolean found = false;
	   Node currentNode = firstNode;
	   while ( !found && (currentNode != null ) ) {
		   if ( anEntry.equals(currentNode.getData()) ) {
			    found = true;
		   } // End if 
		   else {
			   currentNode = currentNode.getNextNode();
		   } // else
	   } // End while
	   return found;
	} // End contains
	
 /****************************************************************************/
	@Override
	public T[] toArray() {
	   @SuppressWarnings("unchecked")
	   T[] result = (T[]) new Object[numberOfEntries];
	   int index = 0;
	   Node currentNode = firstNode ;
	   while ( (index < numberOfEntries) && currentNode != null ) {
		       result [index] = (T)currentNode.getData();
		       currentNode = currentNode.getNextNode();
		       index++;
	   } // End while 
		return result;	
	} // End 
   
 /****************************************************************************/
	 private Node getNodeAt(int givenPosition) {  
      // Assertion: (firstNode != null) &&
      //            (1 <= givenPosition) && (givenPosition <= numberOfEntries)
      Node currentNode = firstNode;
      
      // Traverse the chain to locate the desired node
      // (skipped if givenPosition is 1)
      for (int counter = 1; counter < givenPosition; counter++)
         currentNode = currentNode.getNextNode();
      // Assertion: currentNode != null
      return currentNode;
   } // end getNodeAt
  
 //////////////////////////////////////////////////////////////////////////////
	
 private class Node <T> {
	 private Node nextNode ;  // Next node 
	 private T data;          // Data in the node 
	 
 /*****************************************************************************/	
	 private Node (T newData) {
	       this.data = newData;
	       nextNode = null ;
	  } // End node constructor 
	 
 /****************************************************************************/	 
	  private void setNextNode(Node nextNode) {
	
		   this.nextNode = nextNode;
	  } // End setNextNode
	  
 /****************************************************************************/	  
 	  private void setData(T data) {
 		  
		   this.data = data;  
	  } // End setData
 	  
 /****************************************************************************/ 	  
	  private T getData() {
		  
		 return this.data;
	} // End getData()
	  
 /****************************************************************************/	  
    private Node getNextNode() {
    	
         return this.nextNode;
    } // End getNextnode()
    
 } // End Node class 
 } // End main class
