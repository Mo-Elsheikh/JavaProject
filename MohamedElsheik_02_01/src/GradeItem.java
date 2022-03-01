 /** Tracking grade item and calculate the maximum score, actual score
      used a constructor to validate the data and throw exception, array to
      store the types and search for a valid type, calculate grade item class 
      for the maximum score, actual for greater and zero.
 */
 public class GradeItem extends Object {
	 
	 private int gradeItemId ;       // Grade item Id
	 private String studentId ;      // Student's Id
	 private String courseId ;       // Course Id
	 private String date ;           // Date
	 private int maximumScore ;      // Maximum score 
	 private int actualScore ;       // Actual score
	 private String item ;           // Item type match
	 /** Array for item type final, test, quiz, class work, home work */
	 private String [] itemType = { "HW" , "Quiz", "Class Work" ,
			                          "Test" , "Final" } ;

 /****************************************************************************/	
	
	/** Constructor to validate the data and throw illegal argument exception,
	 *   array search all grade item, calculate the maximum score, actual score
	 *   for grade item class.
	 *   @param gradeItemId, a unique value for each grade item
	 *   @param studentId, a unique value for each student
	 *   @param item, item type for all HW, Quiz, Class Work, Test, Final 
	 *   @param courseId, string course Id
	 *   @param date, format yyyymmdd.
	 *   @param maximumScore, must be greater than 0
	 *   @param actualScore, must be in the range of 0 to maximum score
	 *   //@param greadeItemClass, calculate the Maximum Score, Actual Score
	 *   @throws Exception, IllegalArgumentException
	 */
	public  GradeItem(int gradeItemId , String studentId , String courseId ,
			          String item ,String date,  int  maximumScore ,
			          int actualScore) {
        if ( studentId.isEmpty() ) {
           throw new IllegalArgumentException("Error: Student Id  " + 
                   studentId + " is invalid" + "\nGrde item was not added to"
                   + " the grade item list.");
        } // End if
        else if( date.isEmpty() ) {
        	  throw new IllegalArgumentException("Error: Date " + date + 
        			    " is invalid" + "\r\nGrade item was not added to" +
        			    " the grde item list.");
        } // End else if
        else if( courseId.isEmpty() ) {
           throw new IllegalArgumentException("Error: Course Id " + courseId +
        			    " is invalid" + "\r\nGrade item was not added to" + 
        			    " the grde item list.");
        } // End else if 
        else if ( gradeItemId == 0 ) {
        	  throw new IllegalArgumentException("Error: grade Item Id " + 
                   gradeItemId + " is invalid" + "\r\nGrade item was not"
                   + " added to the grade item list.");
        } // End else if 
        else if ( maximumScore < 0 ) {
        	  throw new IllegalArgumentException("Error: Maximum Score " +
                   maximumScore + " is invalid moust be greater than 0 " +
        			    "\r\nGrade item was not added to the grade item list." );
        } // End else if 
        else if ( (actualScore < 0 ) || (actualScore > maximumScore) ) {
           throw new IllegalArgumentException("Error: Acutua Score " +
                   actualScore + " is invalid " + "the range of 0 to maximum "
        			    + "score is: " + maximumScore + "\r\nGrade item was not "
        			    + "added to grade item list." );
        } // End else if 
        else if ( item.isEmpty() ) {
           throw new IllegalArgumentException("Error: Item Type " +  item +
            		 " is invalid" + "\r\nGrade item was not" + 
                   " added to the grade item list.");  
        } // End if
        else {
             boolean found = false ;
             for (int i = 0 ; i < itemType.length ; i++) {
        	      if ( itemType[i].contentEquals(item) ) {
                    found = true ; 
        	      } // End if 
             } // End for loop 
             if ( found == false ) {
        	       throw new IllegalArgumentException ("Error: Item Type " + 
                        item + " is invalid" + "\r\nGrade item type was not" + 
                        " added to the grade item  list.");
             } // End if 
             this.gradeItemId = gradeItemId ;
             this.studentId = studentId ;
             this.courseId = courseId ;
             this.item = item ;
             this.date = date ;
             this.maximumScore = maximumScore ;
             this.actualScore = actualScore ;  
        } // End else
    } // End GradeItem constructor 
 /****************************************************************************/	
	/** To get the course Id 
	 *   @return, course Id
	 */
	public String getCourseId( ) {
		
	   return courseId ;  
	} // End getCourseId
		 
 /****************************************************************************/	
	/** To get the date
	 *   @return, date
	 */
	public  String getDate( ) {

	   return this.date ;  
	} // End getDate
		 
 /****************************************************************************/	
	/** To get the 
	 * @return, student Id 
	 */
	public String getSutdentId( ) {
		
	   return this.studentId ;
	} // End getSutentId
		 
	 
 /*************************************************************************/
	/** To get the maximum score value
	 * @return, maximum score value
	 */
	public int getMaximumScore( ) {
   
	   return this.maximumScore ;
	} // End getMaximumScore
	
 /*************************************************************************/
	/** To get actual score value
	 * @return, actual score value 
	 */
	public int getActualScore( ) {
		 
       return this.actualScore ;  
	} // End getActualScoure
	 
 /*************************************************************************/
	/**To get grade item Id 
	 * @return, grade item Id 
	 */
	public int getGradeItemId( ) {
			 
	   return this.gradeItemId ;  
	} // End getGradeItemId
		 
 /****************************************************************************/
	/** To get item type 
	 *  @return, item type
	*/
	public String  getItemType() {
		return this.item ;
	}
/*****************************************************************************/	
	// Display student Id, course Id, Date 
	public String toString() {
		
		String display;
		display = " "+ this.gradeItemId  
				  + "\t" + this.studentId 
				  + "\t" + this.courseId
				  + "\t" + this.item
				  + "\t" + this.date 
				  + "\t" + this.maximumScore 
				  + "\t" + this.actualScore ;
		return display ;
	} // End toString
	
 /****************************************************************************/
	/** To find there are two objects have the same data
	 * @param other, grade item 
	 * @return, boolean 
	 */
	@Override
	public boolean equals(Object other) {
		
		boolean result = false ;
		
		if ( gradeItemId == ((GradeItem)other).getGradeItemId()
			 && studentId.equals(((GradeItem)other).getSutdentId()) 
			 && item.equals(((GradeItem)other).getItemType())
			 && courseId.equals(((GradeItem)other).getCourseId())
		    && date.equals(((GradeItem)other).getDate())
		    && maximumScore == ((GradeItem)other).getMaximumScore()
		    && actualScore == ((GradeItem)other).getActualScore() ) {
			 result = true ;
		} // End if
	    return result ;   
	} // End equals
 } // End class
