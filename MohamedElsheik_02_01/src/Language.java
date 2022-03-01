/**
 * Represents a finite language.
 * 
 * In this call will implament interface Iterator class. It uses String generic object and
 * Collection class to add and store the generic object.
 * 
 * @author Dr. Jody Paul
 * @author TODO_Mohamed Elsheikh
 * @version 1.3.TODO_002, CS 3240, 1
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public final class Language implements Iterable<String>, java.io.Serializable {
  
    private static final String EMPTY_STRING = "";   // The empty string.
    private static final Set<String> EMPTY_SET = new TreeSet<String>();  // The empty set. 
    private Set<String> strings; // The set of strings in this language, initially empty.  
    
    
/********************************************************************************************/ 
    /**
     * Create a language with no strings.
     */    
    public Language() {
        //TODO
     strings = new TreeSet<>();
    } // End Language
    
 /********************************************************************************************/ 
    /**
     * Indicates if this language has no strings.
     * @return true if the language is equivalent to the empty set;
     * false otherwise
     */
    public boolean isEmpty() {
        
    	boolean found = false ;
    	if( strings.equals(EMPTY_SET) ) {
    		 found = true ;
    	} //  End if 
    	return found;
   } // End isEmpty()
    
 /********************************************************************************************/ 
    /**
     * Accesses the number of strings (cardinality) in this language.
     * @return the cardinality of the language
     */
    public int cardinality() {
        
    	int min_Value = strings.size();
        return min_Value;
    } // End cardinality()
    
 /********************************************************************************************/ 
    /**
     * Determines if a specified string is in this language.
     * @param candidate the string to check
     * @return true if the string is in the language,
     *         false if not in the language or the parameter is null
     */
    public boolean includes(final String candidate ) {
       
    	boolean result = false ;
    	if( candidate == null || !strings.contains(candidate)) {
		    return result;	
	    } // End if 
    	else {
    		 result = true;
    	} // End else
        return  result;
    } // End  includes
    
/********************************************************************************************/ 
    /**
     * Ensures that this language includes the given string
     * (adds it if necessary).
     * @param memberString the string to be included in the language
     * @return true if this language changed as a result of the call
     */
    public boolean addString(final String memberString) {
        
    	boolean result = false ;
    	if(memberString == null || strings.contains(memberString)) {
		    return result;	
	    } // End if 
	    else {
	    	strings.add(memberString);
		    result = true ;
	    	return result;
	   } // End else
	} // End addString

/********************************************************************************************/ 
    /**
     * Ensures that this language includes all of the strings
     * in the given parameter (adds any as necessary).
     * @param memberStrings the strings to be included in the language
     * @return true if this language changed as a result of the call
     */
    public boolean addAllStrings(final Collection<String> memberStrings) {
        
     	boolean result = false ;
    	if( memberStrings == null || EMPTY_SET.contains(memberStrings) ) {
		    return result;	
	    } // End if 
	    else {
	    	EMPTY_SET.addAll(memberStrings);
		    result = true ;
	    	return result;
	   } // End else
	} // End addAllString
    
 /********************************************************************************************/ 
    /**
     * Provides an iterator over the strings in this language.
     * @return an iterator over the strings in this language in ascending order
     */
    public Iterator<String> iterator() {
        
    	 Iterator<String> ascending_Order = strings.iterator();
        return ascending_Order;
    } // End iterator
    
/********************************************************************************************/ 
    /**
     * Creates a language that is the concatenation of this language
     * with another language.
     * @param language the language to be concatenated to this language
     * @return the concatenation of this language with the parameter language
     */
    public Language concatenate(final Language language) {
        
    	Language new_Language = new Language ();
    	for(String string1 : strings) {
    		for(String string2 :language) {
    			String merge = string1 + string2;
    			new_Language.addString(merge);
    		} // End for string1
    	} // End For string2
        return new_Language ;
    } // End Language concatenate
	
/********************************************************************************************/ 
    /**
     * Use the equals method to compare the two Language objects and casting obj.
	 * @return the result whether they are equal or not.
     */
    @Override
    public boolean equals(final Object obj) {
 
        if (obj instanceof Language) {
            Language lgu = (Language) obj;  // Casting the obj
            return ( this.strings != null && this.strings.equals(lgu.strings) );
    	} // End if	
    	return false ;
    }// End equals
    
/********************************************************************************************/ 
    /**
     *  Use the hashCod method to store unique value 
     *  @return integers value for unique instances.
     */
    @Override
    public int hashCode() {
 
    	int min_Value = strings.hashCode();
        return min_Value ;
    } // End hashCode
} // End class
