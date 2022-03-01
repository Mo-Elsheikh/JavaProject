 /** Tracking and hold student grade item data.
  *   In this program will used two classes, student class hold the student 
  *   data student first and last name, Id, emailAddres, and gradeItem class
  *   to track student grade item, date, maximum score, actual score, item type 
  *   ( HW, Quiz, Class Work, Test, Final ) and course id.
  
  *  @author MohamedElsheikh
  *  @version 01, CS 2050, 3
  
  *  Inspiration quote - " The best and most beautiful things in the world
  *  cannot be seen or  even touched-they must felt with the heart "
  *  HELEN KELLER, (1880,1968) 
 */
 public class Student {
	 
	private String firstName ;      // Student's first name 
	private String lastName ;       // Student's last name
	private String emailAddress ;   // Student's email address 
	private String studentId ;      // Student's Id 		
	Student next;
 /****************************************************************************/	
   /** Constructor to validate the data and throw illegal argument exception
	    @param studentId, string – should be a unique value
	    @param firstName , string 
	    @param lastName, string
	    @param emailAddress, string – should be a unique value verify “@”
	    @throws IllegalArgumentException if any parameters is empty 
	*/
	public Student(String studentId , String firstName , String lastName ,
			       String emailAddress) {
		
	   if ( studentId.isEmpty() ) {
		   throw new IllegalArgumentException("Error: Student Id is invalid."
				   + "\r\nStudent was not added to the students list.");
	   } // End if
	   else if ( firstName.isEmpty() ) {
		   throw new IllegalArgumentException("Error: Frist Name is invalid."
				   + "\r\nStudent was not added to the students list.");
	   } // End else if
	   else if ( lastName.isEmpty() ) {
		   throw new IllegalArgumentException("Error: Last Name is invalid."
				   + "\r\nStudent was not added to the students list.");
	   } // End else if
	   else if ( emailAddress.isEmpty() ) {
		   throw new IllegalArgumentException("Error: Email address is invalid."
				   + "\r\nStudent was not added to the students list.");   
	   } // End else if
	   else if( !emailAddress.contains("@") ) {
		   throw new IllegalArgumentException("Error: Email address" +
	               emailAddress + " is invalid." + "\r\nStudent was not added to"
	               + " the students list." );   
	   } // End else if
	   else {
	       this.studentId = studentId ;
	       this.firstName = firstName ;
	       this.lastName = lastName ;
	       this.emailAddress = emailAddress ;
	   } // End else  
    } // End student constructor 
	/****************************************************************************/
	/** To get the student Id 
	  * @return, student Id
	*/
	public String getStudentId( ) {
		 
	   return this.studentId;
	} // End getStudentId
	 
 /****************************************************************************/
	/** To get the first name 
	 * @return, first name
	 */
	public String getFirstName( ) {
		 
	   return this.firstName; 
	} // End getFirstname
	
 /****************************************************************************/
	/** To get the last name 
	 * @return, last name
	 */
	public String getLastName( ) {
		 
	   return this.lastName ;
	} // End getLastName
	 
 /****************************************************************************/ 
	/** To get the email address  
	 * @return, email address 
	 */
	public String getEmailAddress( ) {
	   return this.emailAddress ;
	} // End getEmailAddress
		
 /****************************************************************************/		
	// Display student Id, first name, last name, email address 
	public String toString() {
	   String display;
	   display = this.studentId + "\t"  + this.firstName + "\t"
	             + this.lastName + "\t" + this.emailAddress ;
	   return display ;	
	} // End toString
	
 /****************************************************************************/		
	/** To find there are two objects have the same data\
	 * @param Other, student's
	 * @return, boolean 
	 * @Override
	 */
	@Override
	public boolean equals(Object other) {
		boolean result = false ;
		if ( studentId.equals(((Student)other).getStudentId())
		     && firstName.equals(((Student)other).getFirstName())
		     && lastName.equals(((Student)other).getLastName()) 
		     && emailAddress.equals(((Student)other).getEmailAddress()) ) {
			 result = true ;
		} // End if	
	   return result ;
	} // End equals
 } // End class 
