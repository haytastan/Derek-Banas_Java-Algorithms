import java.util.Arrays;

// a queue is like a line of people
// the first person in the line is served
public class TheQueue {
	
	private String[] queueArray;
	private int queueSize;
	

//	we also monitor the front unlike the stack
	private int front, numberOfItems, rear = 0;
	// Sets stack as empty
	
	TheQueue(int size){ // constructor
		
		queueSize = size;
		
		queueArray = new String[size];
		
		// Assigns the value of -1 to every value in the array
		// so they will not show up on the screen
				
		Arrays.fill(queueArray, "-1");
		
	}
	
//	instead of pushing
	public void insert(String input){
		
//		"+ 1" cause we are gonna be adding a new item
		if(numberOfItems + 1 <= queueSize){
			
//			we put our new info to the rear/back 
//			(and we are gonna be pulling from the front)
			queueArray[rear] = input;
			
			rear++;
//			to put following values to further back
		
			numberOfItems++;
			
			System.out.println("INSERT " + input + " Was Added to the Stack\n");
		
		} else {
			
			System.out.println("Sorry But the Queue is Full");
			
		}
		
	}
	
	// This priority insert will add items in order from high to low
	
	public void priorityInsert(String input){
		
		int i;
		
		if(numberOfItems == 0){
			
			insert(input);
			
		} else { // we enter everything from high to low
			
			for(i = numberOfItems-1; i >= 0; i--){
				
				System.out.println("INSERT " + input + " Was Added to the Stack\n");
				
				if(Integer.parseInt(input) > Integer.parseInt(queueArray[i])){
					
//					we are copying the value further up in the array 
					queueArray[i+1] = queueArray[i];
					
				} else break; // Done shifting items in queue and gets out of for loop
				
			}
			
//			we put our new info to the rear/back 
			queueArray[i+1] = input; // i �nce -1 ard�ndan 1 olur
//			yani i �nce 0'dan k���k oldu, ard�ndan loop i�erisinde 
//			break sta oldu�undan 0'dan b�y�k oldu
			
			rear++;
			
			numberOfItems++;
			
		}
		
	}
	
	public void remove(){
		
		if(numberOfItems > 0){
			
			System.out.println("REMOVE " + queueArray[front] + " Was Removed From the Queue\n");
//			we are gonna be removing from the front (unlike stack)
			
			// Just like in memory an item isn't deleted, but instead is just not available
			queueArray[front] = "-1";
			
			front++;
//			for future items to be removed from one further up
		
			numberOfItems--;
		
		} else {
			
			System.out.println("Sorry But the Queue is Empty");
			
		}
		
	}
	
	public void peek(){
		
		System.out.println("The First Element is " + queueArray[front]);
		
	}
	
	public void displayTheQueue(){
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < queueSize; n++){
			
			System.out.format("| %2s "+ " ", n);
			
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < queueSize; n++){
			
			
			if(queueArray[n].equals("-1")) System.out.print("|     ");
			
			else System.out.print(String.format("| %2s "+ " ", queueArray[n]));
			
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
		
		// Number of spaces to put before the F
		
		int spacesBeforeFront = 3*(2*(front+1)-1);
		
		for(int k = 1; k < spacesBeforeFront; k++)System.out.print(" ");
		
		System.out.print("F");
		
		// Number of spaces to put before the R
		
		int spacesBeforeRear = (2*(3*rear)-1) - (spacesBeforeFront);
		
		for(int l = 0; l < spacesBeforeRear; l++)System.out.print(" ");
		
		System.out.print("R");
		
		System.out.println("\n");
	
}
	
	public static void main(String[] args){
		
		TheQueue theQueue = new TheQueue(10);
//		we want 10 spaces inside
		
		theQueue.priorityInsert("16");
//		ilk de�er i�in priorityInsert metodu �zerinden insert metodu �a��r�l�r
		
		theQueue.priorityInsert("25");
		
		theQueue.priorityInsert("10");
		
		/*
		theQueue.insert("10");
//		added to rear/back
		
		theQueue.displayTheQueue();
		
		theQueue.insert("15");
		
		theQueue.displayTheQueue();
		
		theQueue.insert("25");
		
		theQueue.displayTheQueue();
		
		theQueue.insert("25");
		
		theQueue.displayTheQueue();
		
		theQueue.insert("25");
		*/
		
		theQueue.displayTheQueue();
		
		theQueue.remove();
//		removed from the front
		
		theQueue.displayTheQueue();
		
		theQueue.remove();
		
		theQueue.displayTheQueue();
		
		theQueue.peek();
		
		theQueue.displayTheQueue();
	}

}
/*
INSERT 16 Was Added to the Stack

INSERT 25 Was Added to the Stack

INSERT 10 Was Added to the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 25  | 16  | 10  |     |     |     |     |     |     |     |
-------------------------------------------------------------
  F              R

REMOVE 25 Was Removed From the Queue

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|     | 16  | 10  |     |     |     |     |     |     |     |
-------------------------------------------------------------
        F        R

REMOVE 16 Was Removed From the Queue

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|     |     | 10  |     |     |     |     |     |     |     |
-------------------------------------------------------------
              F  R

The First Element is 10
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|     |     | 10  |     |     |     |     |     |     |     |
-------------------------------------------------------------
              F  R
*/