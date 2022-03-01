 /** In this class will read data from the file and check the first element 
      it is equal student or grade item, check the second element equal ADD
      and after that will process the data, check studen1 equal studen1 and
      display message, check grade item 1 equal grade item2 and display message 
    
     @author MohamedElsheikh
     @version 02, CS 2050, 3 
     Inspiration quote - "Good, better, best. Never let it rest. 'Til your good is
      better and your better is best."
     Jerome, (347,420)
 */
 import java.util.Scanner;         // Access the Scanner class
 import java.io.File;              // Access to files 
 import java.io.FileWriter;        // Access to file writer
 import java.io.PrintWriter;       // Access PrintWriter and related classes
 import java.io.IOException;       // Throws exception 
 
 public class  MohamedElsheikh_02  {

	private static Student student1 ;      // An object form Student class 
	private static GradeItem gradeItem1;   // An object form GradeItem class
	private static Student student2;       // An object form Student class 
	private static GradeItem gradeItem2;   // An object form GradeItem class
	
	// Declare variables for file 
	public static final String INPUT_FILENAME = "Project_02_Input01.txt";
	public static final String OUTPUT_FILENAME = "Project_02_Output01.txt";
	public static void main(String[] args) throws IOException {
	
	   /** Access the input and output files */
		   File inputDataFile = new File(INPUT_FILENAME);
		   Scanner input  = new Scanner(inputDataFile);
		   FileWriter outputDataFile = new FileWriter (OUTPUT_FILENAME);
		   PrintWriter output= new PrintWriter (outputDataFile);

	 /****************************************************************************/
		   /** Student data from the file */
		   String mask = "\nRunning Test " ; // Text format
		   student1 = new Student ( "900123456","Joe",
									  "Doe","joedoe@msudenver.edu");
		   System.out.print(mask + "1a:\n" +
					   "Student { studentId = " + student1.getStudentId() + ", " +
					   "firstName = " + student1.getFirstName() + ", " +
					   "lastName = " + student1.getLastName() + ", " +
					   "\nemailAddres = " + student1.getEmailAddress() + " } " );
	 /****************************************************************************/
		   /** Grade item data from file */
		   gradeItem1 = new GradeItem ( 1,"900123456",
										  "23456", "HW", "20170112", 100, 95);
	   System.out.print( mask + "1b:\n" + 
			      	      "GradeItem { gradeItemId = " +
			      	      gradeItem1.getGradeItemId() + ", " +
			               "studentId = " + gradeItem1.getSutdentId() + ", " +
			               "courseId = " + gradeItem1.getCourseId() + ", " +
			               "\nitemType = " + gradeItem1.getItemType() + ", " +
			               "date = " + gradeItem1.getDate() + ", " + 
			               "maxScore = " + gradeItem1.getMaximumScore() + ", " +
			               "actualScore = " + gradeItem1.getActualScore()
			               + " }\n " );
 /***************************************************************************/
	   /** Read the input file and split by commas, check the first item
	     *  student or  grade  item for each lines.
	   */     
	   try {
		   String validLines; // Valid lines on the file
		   String [] studentData; // Student data read form file
	      while ( input.hasNextLine() ) {
	    	    validLines = input.nextLine();
	    	    studentData = validLines.split(",");
	    	    if ( studentData[0].contentEquals("STUDENT") ) {
	    		     processStudentData(studentData);
	     	    } // End if 
	    	    else if ( studentData[0].contentEquals("GRADE ITEM") ) {
	 		       processGradeItemData(studentData);
	    	    } // End else if
	    	    else {
     	    	         System.err.println("No data for the student or "
	    	    			                + "the grade itme on the file.");
	    	    } // End else 
	      } // End while loop
	   } // End try
	   catch (IllegalArgumentException e) {
	         System.err.println(e.getMessage());
	   } // End catch
 /************************************************************************/
	   /** Use the equals method to compare the two Student objects
	       and display a message whether they are equal or not.
	   */
	   String line2 =  "objects are equal." ;   // Text format 
	   String line1 = "objects are not equal."; // Text format 
	   if ( student1.equals(student2) ) {
	      System.out.println( mask + "3a:"+  "\nStudent " + line2 );
	   } // End if
	   else {
		   System.out.println( mask + "\nStudent " + line1 );
	   } // End else 
 /****************************************************************************/
	   /** Use the equals method to compare the two grade item objects
	       and display a message whether they are equal or not.
	   */  
	   if ( gradeItem1.equals(gradeItem2) ) {
	    	 System.out.println( mask + "3b:" +
	    			              "\nGradeItem " + line2 );
	   } //End if
	   else {
			System.out.println(mask + "3b:" + "\nGradeItem " + line1);
	   } // End else 
	
 /****************************************************************************/	
      // Close the input and output file 
	   input.close();
	   output.close();
	   System.exit(0);     
	} // End main 
 /****************************************************************************/ 
	 /** Process student data and check the second item in the array
	   * to make sure it is �ADD�.
	   * @param, array for all student data
	 */
	 public static void processStudentData(String [] studentData ) {
		try { 
		   if ( studentData[1].contentEquals("ADD") ) {
			     student2 = new Student( 
				  studentData[2] ,studentData[3] , 
				  studentData[4], studentData[5] );	 
		       System.out.println("\nRunning Test 2a:\n" + student2.toString());
		   } // End if 		 
		} // End try
		catch (Exception e) {
			    System.err.println(e.getMessage());
		} // End catch
	 } // End processStudentData
 /****************************************************************************/
	/**  Process grade item data and check the second item in the array
	 *  to make sure it is �ADD�.
	 * @param gradeItemData, array for all grade item data
	*/
	public static void processGradeItemData(String [] gradeItemData) {
	   try {
		  if ( gradeItemData[1].contentEquals("ADD") ) {
				 gradeItem2 = new GradeItem (	  
				 Integer.parseInt(gradeItemData[2]),
				 gradeItemData[3],gradeItemData[4],gradeItemData[5],
			  	 gradeItemData[6],
			    Integer.parseInt(gradeItemData[7]),
				 Integer .parseInt(gradeItemData[8]) );  
			   System.out.println("\nRunning Test 2b:\n"+ gradeItem2.toString());
		  } // End if
		} // End try
	   catch (Exception e) {
			 System.err.println(e.getMessage());
	   } // End catch
	} // processGradeItemData
 } // End the class


