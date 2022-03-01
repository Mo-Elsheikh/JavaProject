 /**
  * In this class using two methods Shell Sort and Quick Sort
  * Output files : for Shell Sort is "hw6input.txt" and 
  *  Quick Sort is "hw6output2.txt". 
  *  
  * @author MohamedElsheikh
  * @version 06, CS 2050, 2 
  * 
  *  Inspiration quote -"The future belongs to those who believe in the 
  *   beauty of their dreams."
  *  Eleanor Roosevelt (1884 , 1962). 
  */
 import java.io.File;          // Access to files          
 import java.io.FileWriter;    // Access PrintWriter and related classes
 import java.io.PrintWriter;   // Access to file writer
 import java.util.Scanner;     // Access the Scanner class
 import java.io.IOException;   // Throws exception 

 public class MohamedElsheikh_06 {
	
	 // Declare variables for files
	 private final static String INPUT_FILENAME = "hw6input.txt";
	 private final static String OUTPUT_FILENAME = "hw6output1.txt";
	 private final static String OUTPUT_FILENAME2 = "hw6output2.txt";
    
    public static void main(String[] args) throws Exception {
	 
	   /** Access to the input files */
	   File inputDataFile = new File(INPUT_FILENAME);
	   Scanner input  = new Scanner(inputDataFile);
	   
	   /** Access to the shellSort output files */
      FileWriter outputDataFile = new FileWriter (OUTPUT_FILENAME );
 	   PrintWriter output = new PrintWriter (outputDataFile);
 	   
 	   /** Access to the quickSort output files */
 	   FileWriter outputDataFile2 = new FileWriter (OUTPUT_FILENAME2 );
 	   PrintWriter output2 = new PrintWriter (outputDataFile2);
	   
 	   // The array need to sort by shell sort
	   int[] shellSortArray = new int [100]; 
	   
	   // The array need to sort by quick sort
	   int[] quickSortArray = new int [100];
	   
	   int  index = 0 ; // The input counter
	   
	   // Read the data from file 
	   while ( input.hasNext() ) {
      
		   shellSortArray[index] = input.nextInt();
		   quickSortArray[index] =  shellSortArray[index];
		   index++;
	   } // End while		   
      
      // Sort the array by shell Sort
      // Print out the shell sort array
	   shellSort(shellSortArray );
	   for ( int i = 0 ; i < shellSortArray.length ; i++ ) {
      
			output.println(shellSortArray[i]);
	   } //End for loop
      
      // Sort the array by quick sort 
      // print out the quick sort array
	  	quickSort( quickSortArray , 0 ,  quickSortArray.length - 1 );
	   for ( int j = 0 ; j <  quickSortArray.length ; j++ ) {
      
      	 output2.println( quickSortArray[j]);
		} // End for loop
		
      // Close the result   
	   output.close();
      output2.close();
	   input.close();
	   System.exit(0);
    } // End main
		
 /****************************************************************************/	 
	/**
	 * Using Shell Sort to sort the numbers on the array.
	 * @param, Array, The array to be sort.
	 * @return, Zero.
	 */
    public static int shellSort ( int array [] ) {	
    
	    int size = array.length; // The array size
	    
       // Get the gap by (size / 2)
       // The for loop continue working until ( gap = 0),
       // Than the array sort by shell sort.  
	    for (int gap = size / 2 ;  gap > 0  ; gap /= 2) {
       
           // Initialize the (i = gap  ) as right pointer and increase the i 
		     for ( int i = gap ; i < size ; i++ ) {
              
	    		   int temp = array [i]; // The elament of the counter i
				   int j; // Declare variable not initialize 
               
               // Initialize the (j = i ), and the for loop continue wrorking until ( j >= 0)
               // and decrease (j - gap ) as left pointer and compare with 
               // (avlue of the array[j- gap] and with temp which the value of array[i])
				   for ( j = i ; j >= gap && array[j-gap] > temp ; j -= gap ) { 
               
					    array [j] = array[j - gap]; // Shell Sort ( Ex: j = 4-4 = 0)
				    } // End for loop
					 array[j] = temp; // Sorting the array
		     } // End for	
		 } // End main for loop
       
	    return 0 ; 
    } // End shellSort
    
 /****************************************************************************/
    /**
     * Sort the numbers on the array by using Quick Sort.  
     * @param array, The array need to be sort
     * @param leftIndex, The left pointer of the index
     * @param rightIndex, The right pointer of the index
     */
    public static void quickSort( int array [] , 
                                  int leftIndex ,
                                  int rightIndex )  {	
       // If the array has one index or not initialize than return                         
 	    if ( leftIndex >= rightIndex ) {
 		    return;
 	    } // End if
        
       // Call partition method to sort the array and return partition index 
       // Quick sort by using recursively method.
       else {
 	        int partition = partition (array , leftIndex , rightIndex );
 		     quickSort( array , leftIndex , partition - 1 ) ; 
 		     quickSort( array , partition , rightIndex ) ;
       } // End else
    } // End quickSort
    
 /****************************************************************************/
    /**
     * Using partition method to sorting the array 
     * @param array, The array need to be sort 
     * @param leftIndex, the left pointer of the index
     * @param rightIndex, The right pointer of the index
     * @return, The left index
     */
    public static int partition( int [] array , 
                                  int leftIndex , 
                                  int rightIndex ) {
                                  
       // Get the pivot in the center by (lower index + higher index ) / 2                             
       int pivot = array [ ( leftIndex + rightIndex ) / 2 ] ;
       
       // Check left index smaller than or equal right index than sort,
       // return left index which is the partition                   
    	 while ( leftIndex <= rightIndex ) {
         
          // Check the left index on the array smaller than the pivot,
          // and move the pointer on the next left index by increase left index    
    	    while (array[leftIndex] < pivot) 
          {
    			  leftIndex++;
          } // End while
          
          // Check the right index on the array greater than the pivot,
          // move the pointer on the next left index by decrease right index 
    		 while ( array[rightIndex] > pivot ) {
          
    			  rightIndex--;
    		 } // End while
          
          // If left index smaller than or equal right index, than
          // swap the index on the array, and move the pointer 
          // on the next right index by increase left index, and
          // move the pointer on the next left index by decrease right index 
    		 if ( leftIndex <= rightIndex ) {
          
            // Sorting the array 
    			int temp = array[leftIndex];
    			array[leftIndex] = array[rightIndex];
    			array[rightIndex] = temp;
    			leftIndex++;
    			rightIndex--;
    		 } // En if
    	 } // End while
   
       return leftIndex;
    } // End partition
 } // End class