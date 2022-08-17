// Class:		Data Structures Section W02
// Term:		Summer 2022
// Name:		Gustavo Ramos
// Program Number:	Sorting Assignment
// IDE: 		Eclipse, JDK 1.8
import java.util.*;



public class QuickSortReverseGustavoRamos {
	
	
	
	public static void quicksort(int [] list, int first, int last) {  //method that sorts the array
		
		if(first < last) {            // if first element is less than the last then the condition is executed
			
			int pivotIndex = partition(list, first, last);   // create pivtoIndex using the partition method
			quicksort(list, first, pivotIndex);
			quicksort(list, pivotIndex+1, last);                //recursivley calling the method with respected parameters
		}
	}
	
	public static int partition(int [] list, int first, int last) {
		
		int pivot = list[first];
		int low = first;
		int high = last;             //creating variables to partition the list given
		
		while(true) {             
			
			while(list[low] > pivot) {         //while the lowest value of the list is greater than the pivot, low is incremtented
				low++;
			}
			
			while(list[high] < pivot) {       //while the highest value of the list is less than the pivot, high is reduced by one
				high--;
			}
			
			if(low < high) {
				int temp = list[low];
				list[low] = list[high];
				list[high]= temp; 
		
			}
			else {
				return high;
			}
		}
	

	}
	
	public static void main(String [] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String userChoice;
				
		
		
		do {
		
	
		System.out.print("How many integer numbers do you have? : ");
		int userInput = scan.nextInt();
		
		int [] inputs = new int[userInput];
		

		System.out.println("Enter " + userInput + " integer numbers: ");
		
		for(int i = 0; i < inputs.length; i++) {
			inputs[i] = scan.nextInt();
		}
		
		System.out.print("Inputs array before sorting (quick): ");
		
		for(int i = 0; i < inputs.length; i++) {
			
			System.out.print(inputs[i] + ",");
		
		}
		
		System.out.println();
		
		quicksort(inputs,0,inputs.length-1);
		
		System.out.print("Inputs array after sorting (quick): ");
		
		
		
        for(int i = 0; i < inputs.length; i++) {
			
			System.out.print(inputs[i] + ",");
			
		
		}
        
        System.out.println();
        
        
        System.out.println("Do you want to continue? (Y/N)");
        userChoice=scan.next();
        
		}while(userChoice.equals("Y"));
		
		scan.close();
		
	
		
	}

}
