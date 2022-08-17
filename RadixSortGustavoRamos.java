// Class:		Data Structures Section W02
// Term:		Summer 2022
// Name:		Gustavo Ramos
// Program Number:	Sorting Assignment
// IDE: 		Eclipse, JDK 1.8


import java.util.*;

public class RadixSortGustavoRamos {
	
	
	
	
	public static int ExtractDigit( int num, int place) {

	    return (int) ((num) / Math.pow(10, place) % 10);          //method that extracts each digit separately 

	}
	 
	public static int DigitCount(int num) {      //method that counts each digit passed through
		
		return (int)(Math.log10((num))) + 1;
	}




	public static void radixSort(int[] list) {
		
		

	    Queue<Integer>[] buckets =new Queue[10];       //creating ten buckets and initializing them 
	      
	    
	    for(int i = 0; i<buckets.length; i++)
	    {
	         buckets[i] = new Queue();
	    }

	

	
	    int maximum = 0;
		   
		   for(int i = 0; i < list.length; i++) {
			  
			   maximum = Math.max(maximum, DigitCount(list[i]));           // for loop to find the maximum number in the array
		   }

	    
		int currentNum = 0;
		
	    while (currentNum < maximum) {                    // adds each number into the queue in order of theri maximum value

	       for (int i = 0; i < list.length; i++) {

	         int extractedDigit = ExtractDigit(list[i],currentNum);

	         buckets[extractedDigit].enqueue(list[i]);

	      }

	     

	      int returnArray = 0;

	      
	      for (int i = 0; i < 10; i++) {         // Returning the numbers left from the step above into the array

	       
	    	  while (!buckets[i].isEmpty()) {

	    		  
	          int temp = buckets[i].front();

	          list[returnArray] = temp;

	          buckets[i].dequeue();

	          
	          
	          returnArray++;

	        }

	      }

	      currentNum++;

	    }

	}
	
	public static void main(String[] ergs) {

	    Scanner scan = new Scanner(System.in);
	    
	    String userChoice;
	    
	    
	    
	    do {

	    
	    System.out.print("How many integer numbers do you have?: ");
        int userInput = scan.nextInt();
	    
	    int[] inputs = new int[userInput];

	    
	    System.out.print("Enter " + userInput + " integer numbers: ");

        
	    for (int i = 0; i < inputs.length; i++) {

	      inputs[i] = scan.nextInt();
	    }

	   

	    System.out.print("Inputs array before sorting (radix): ");

	    for (int i = 0; i < inputs.length; i++) {

	      System.out.print(inputs[i] + ", ");
	    }
	    
	    System.out.println();


	    radixSort(inputs);

	   

	    System.out.print("Inputs array after sorting (radix): ");

	    
	    for (int i = 0; i < inputs.length; i++) {

	      System.out.print(inputs[i] + ", ");
	    }
	    
	    

	    System.out.println();
	    
	    System.out.println("Do you want to continue? (Y/N)");
        userChoice=scan.next();

	   

	   

	}while(userChoice.equals("Y"));
		
		scan.close();
	
	}

	}