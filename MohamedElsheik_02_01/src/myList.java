 /** In this class we will implement the MyCollectionInterface 
  * a list of Students and Grade Items 
  */
 import java.util.ArrayList;  // Access the ArrayList
 import java.util.List;       // Access the List
 public class myList<T> implements  MyCollectionInterface<T> {
	 
	private  List <T> internalList = new ArrayList<T>();
 

 /****************************************************************************/		
	@Override
	public boolean add(T newItem) {	
		boolean result = false ;
    	if( internalList.contains(newItem)) {
		    return result;	
	    } // End if 
	    else {
		    internalList.add(newItem);
		    result = true ;
	    	return result;
	   } // End else
	} // End add(T newItem)
	
 /****************************************************************************/		
	@Override
	public T remove() {
		T found ;
		if (internalList.isEmpty()) {
			found = null;
		} // End if
		else {
			 found =  internalList.get(0);
			 internalList.remove(0);
		} // End else
		return found;
	} // End T remove()
	
 /****************************************************************************/		
	@Override
	public boolean remove(T anEntry) {
		boolean found = false;
	  if(internalList.contains(anEntry)) {
		  found = true;
		  internalList.remove(anEntry);
	  } // End if
		return found;
	} //End remove(T anEntry)
	
 /****************************************************************************/		
	@Override
	public void clear() {
		internalList.removeAll(internalList);
		} //End clear
	
 /****************************************************************************/		
	@Override
	public int getCurrentSize() {
		int positsionEntry = 0 ;
		positsionEntry  = internalList.size();
	    return positsionEntry ;
	} // End getCurrentSize
	
 /****************************************************************************/	
	@Override
	public boolean isEmpty() {
	boolean found = false ;
	if( internalList.isEmpty()) {
		 found = true ;
	} //  End if 
	return found;
	} // End isEmpty()
	
 /****************************************************************************/	  
	
	@Override
	public int getFrequencyOf(T anEntry) {
		int counter = 0;
		for (int i = 0 ; i < internalList.size() ; i++) {
		    if (anEntry.equals(internalList.get(i))) {
	             counter++;
		    } // End if
		} // End for loop
		  return counter;
	} // End getFrequencyOf(T anEntry)
	
 /****************************************************************************/		
	@Override
	public boolean contains(T anEntry) {
	   boolean found = false;
	   for(int i = 0 ; i < internalList.size() ; i++ ) {
	    	  if ( anEntry.equals(internalList.get(i))) {
		    	found = true ;
		      } //End if 	 
	    } // End loop
	 
	    return found;

	} // End contains(T anEntry)
	
 /****************************************************************************/		
	@Override
	public T[] toArray() {
	  Object[] newArray = new Object[internalList.size()];
	  for(int i = 0 ; i < internalList.size() ; i++ ) {	
		  if ( internalList.isEmpty()) {
			  break;
		  } // End if
		  else {
			  newArray [i] = internalList.get(i);
		  } // End else
	  } // End for loop
		return (T[]) newArray;
	} // End toArray()	
 } // End class
