 /**
  * In main this class will read data from the file and check the first element 
  *  it is equal student or grade item and will call method to process the 
  *  data for each object, and check the second element equal ADD then will 
  *  create a object and call contain method in the List class to make sure
  *  the student or grade item is unique. If is already in the list then 
  *  display message. And call the add method in the List class to add the 
  *  Student or grade item object to the list of students
  *  or grade item. And if DEl call remove method in the list class to remove
  *  the student or grade item object.
  * 
  * Output : call the toArray method in the List class to get a list of Student
  *  objects and call the toArray method in the List class to get a list of
  *  GradeItem objects.
  *  generate a report which will be written to an output file, hw4outputxx.txt.
  * 
  * @author MohamedElsheikh
  * 
  * @version 04, CS 2050, 2
  * 
  * Inspiration quote - "We are what we pretend to be, so we must be careful about 
  *  what we pretend to be."
  * Kurt Vonnegut (1922,2007) 
  */ 
 import java.util.Scanner;         // Access the Scanner class
 import java.io.File;              // Access to files 
 import java.io.FileWriter;        // Access to file writer
 import java.io.PrintWriter;       // Access to printWriter and related classes
 import java.text.DecimalFormat;   // Access to decimal format
 import java.io.IOException;       // Throws exception 
 
 public class MohamedElsheikh_04 {
	 
	private final static String INPUT_FILENAME = "hw4input01.txt";
   private final static String OUTPUT_FILENAME = "hw4Output01.txt"; 
    
	private static ListClass listOfStudents ;  // An object form listClass
	private static ListClass listOfGradeItems; // An object form ListClass
	
	public static void main(String[] args) throws Exception { 
   
		listOfStudents = new ListClass <Student>();
		listOfGradeItems = new ListClass<GradeItem>();
      
	   // Read the data from the file and process  
	   processInput ();
       
	   // Print the report on the file
	   generateReport();
       
	   System.exit(0); 

	} // End main
	
 /****************************************************************************/
	 /**
	  * Read the input file and split by commas, check the first item
	  * student or  grade  item for each lines.
	  * @throws Exception
	  */
	 public static void processInput () throws Exception {
    
	    /** Access the input */
	    File inputDataFile = new File(INPUT_FILENAME);
	    Scanner input  = new Scanner(inputDataFile);
       
	    if ( inputDataFile.exists() ) {
	       try {
	    	     System.out.println("Reading data from file hw4Input01.txt");
              
		        String validLines;     // Valid lines on the file
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
		    	          System.exit(0);
	 	            } // End else 
	           } // End while loop
	       } // End try
          
	       catch (IllegalArgumentException e) {
	              System.err.println(e.getMessage());
	       } // End catch
	       // Close the input
	       input.close();
	    } // End main if
       
	    else {
	        	 System.err.println("The file is not found.");
	        	 System.exit(0);
	    } // End else
	 } // End processInput 
	  
 /****************************************************************************/
    /** 
     * Process student data and check the second item in the array
     * to make sure it is “ADD” and create a student object,
     * use the contains method make sure Student is unique
     * if the second field is a DEL then it will create a student object	
     * call the remove method to remove the student.
     * @param, array for all student data
     */
    public static void processStudentData(String [] studentData ) {
    
	    Student students; // An object from student class
       
		 try { 
		     if ( studentData[1].contentEquals("ADD") ) {
           
		        	 students = new Student(studentData[2] ,studentData[3] ,  
		 				                     studentData[4], studentData[5]);
                                          
		          if ( listOfStudents.contains(students) ) {
		        		   System.err.println("The list already contains Studen Id: " 
		        	                     + studentData[2] );
		          } // End if 
		          else {
		               if ( listOfStudents.add(students) ) {
		        		   System.err.println("Student with Student Id " 
		        	                     + studentData[2] + " was added to the list. ");
		            	} // End else if
		            	else {
		            	     System.err.println("The student operation added failed.");
		            	} // End else
		            } // End else
		     } // End if 	
           
		     else if ( studentData[1].contentEquals("DEL") ) {
		        	      students = new Student(studentData[2] ,
		        			                       studentData[3] , 
		 				                          studentData[4] , 
		 				                          studentData[5]);
		          if ( listOfStudents.remove(students) ) {
		        	      System.err.println("Student with Student Id " + 
		                              studentData[2]+ " was removed from the list."); 
		          } // End if
		          else {
		        	      System.err.println("Student with Student Id: " + 
		                              studentData[2] + " is not in the list "
                                    + "and could not be removed.");
		          } // End else 
		     } // End else if
           
		     else {
		        	 System.err.println("No data for the student to ADD or DEL");
	             System.exit(0);
		     } // End else
		 } // End try
       
		 catch (Exception e) {
			    System.err.println(e.getMessage());
		 } // End catch
	 } // End processStudentData
	  
/*****************************************************************************/
    /** Process grade item data and check the second item in the array
      *  to make sure it is “ADD” and create a grade item object,
      *  use the contains method make sure grade item is unique
      *  if the second field is a DEL then it will create a grade item object	
      *  call the remove method to remove the grade item.
      * @param gradeItemData, array for all grade item data
      */
	 public static void processGradeItemData(String [] gradeItemData) {
    
	    GradeItem gradeItems ; // An object form grade item class
       
	    try {
		     if ( gradeItemData[1].contentEquals("ADD") ) {
           
				    gradeItems = new GradeItem (	  
				    Integer.parseInt(gradeItemData[2]),
				    gradeItemData[3],gradeItemData[4],gradeItemData[5],
			  	    gradeItemData[6],
			       Integer.parseInt(gradeItemData[7]),
				    Integer .parseInt(gradeItemData[8]) ); 
                 
				    if ( listOfGradeItems.contains(gradeItems) ) {
			            System.err.println("The list already contains item" 
                            + gradeItems );
			       } // End if 
			       else { 
			    	      if ( listOfGradeItems.add(gradeItems) ) {
			               System.err.println("Grade Item with Student Id "
                               + "xxxxxxxxxxx and " + "Grade item Id "
			        			       + gradeItemData[2] + " was added to the list. ");
			            } // End if 
			    	      else {
			    		        System.err.println("The Grade Item operation added failed.");
			    	      } // End else
		          } // End else
		     } // End if	    
			  else if ( gradeItemData[1].contentEquals("DEL") ) {
				         gradeItems = new GradeItem (	  
				         Integer.parseInt(gradeItemData[2]),
				         gradeItemData[3],gradeItemData[4],gradeItemData[5],
			  	         gradeItemData[6],
			            Integer.parseInt(gradeItemData[7]),
				         Integer .parseInt(gradeItemData[8]));
                       
				     if ( listOfGradeItems.remove(gradeItems) ) {
				          System.err.println ("Grade Item with Student Id " 
                             + "xxxxxxxxxxxx" + "and Grade Item Id " +
                             gradeItemData[2] + " was removed from the list.");
				     } // End if 
				     else {
				        	  System.err.println("Grade item  with is" +
				                  gradeItemData[2] +" not in the list "
                              + "and could not be removed.");
				     } // End else 
		     } // End else if
			  else {
		        	 System.err.println("No data for the grade item to ADD or DEL");
	             System.exit(0);
		     } // End else
		 } // End try
       
	    catch ( Exception e ) {
			    System.err.println(e.getMessage());
	    } // End catch
	 } // processGradeItemData
	  
 /****************************************************************************/
	 // Print all reports for student and grade item
	 public static void generateReport () throws IOException {	
    
	    /** Access the output files */
	    FileWriter outputDataFile = new FileWriter (OUTPUT_FILENAME);
		 PrintWriter output= new PrintWriter (outputDataFile);
       
		 DecimalFormat df = new DecimalFormat("##.##");
		 Student students ;    // An object from student class
	    GradeItem gradeItem ; // An object from grade item class 
       
		 Object[] newArray = listOfStudents.toArray();    // Students data
	    Object[] newArray2 = listOfGradeItems.toArray(); // Grade items data
	      
	    String line = "==============================================" +
	 	               "======================================" ;
	        
	    System.out.println("Generating report to file hw4output01.txt... done.");
	    output.println("StudentID  FirstName  LastName  Email " + "\r\n"
	                        + " " + "Grade Items");
	    output.println(" " +  "GradeItemID" + "\t" + "CourseID" + "  " +
	    	             "Type" + "\t" + "Date" + "\t" + "Maximum Score " +
	    		          "Actual Score"  +  "\t" +  "Grade (%)");
	    output.println(line);
	    output.println("Total" +"                                " + 
	    			       "SumOfMaxScore   SumOfActualScore");
	          
	      
	    for ( int i = 0 ; i < listOfStudents.getCurrentSize() ; i++ ) {  
	        	
	    	  students = (Student) newArray[i];
	    	  double Grade = 00 ;
	    	  int sumActualScore = 0 ;
	    	  int sumMaximumScore = 0 ;
	    	  output.println( newArray[i] );

	    	  for ( int j = 0 ; j < listOfGradeItems.getCurrentSize() ; j++ ) {   
           	  
	    	    	int maximumScore = 0 ;
	    	    	int actualScore = 0 ;  
	    	      gradeItem = (GradeItem) newArray2[j];
               
	    	    	if ( students.getStudentId().equals(gradeItem.getSutdentId()) ) { 
                    maximumScore = gradeItem.getMaximumScore();
	    	    		  actualScore = gradeItem.getActualScore();
	    	    		  output.println( newArray2[j] );
	    	    		  sumMaximumScore = sumMaximumScore + maximumScore;
	    	    		  sumActualScore =  sumActualScore + actualScore;  
	    	    	} //End if   
	    	  } // End for loop listOfGradeItems
           
	        Grade = ( (double) sumActualScore / sumMaximumScore ) * 100 ;
	    	  output.println(line);
	        output.println("  " + "Total" + "\t\t\t" + "\t\t\t" 
	        	    		     + "\t" + sumMaximumScore + "\t"+
	        	    		     sumActualScore + "\t" + df.format(Grade)+ " %" );   
                              
	    } // End for loop listOfStudents   
	    // Close the output
	    output.close();
	 } // End generateReport ()   
 } // End class 
