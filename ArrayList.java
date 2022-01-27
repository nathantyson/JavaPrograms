//ArrayList.java
//George J. Pothering


class ArrayNode {
	public int data;
		    
	public ArrayNode(int initialData) {
		data = initialData;
	}
	
	public int getData() {
		return data;
	}
} //Node


public class ArrayList {
   // Private members
   protected ArrayNode[] arrayData;
   protected int listSize;
   protected int arrayCapacity = 4;
   
   private void resize(int newAllocationSize) {
		   // Create a new array with the indicated size
		   ArrayNode[] newArray = new ArrayNode[newAllocationSize];

		   // Copy items in current array into the new array
		   for (int i = 0; i < listSize; ++i) {
		      newArray[i] = arrayData[i];
		   }
		   // Assign the arrayData member with the new array
		   arrayData = newArray;
		}   

   // The default constructor initializes the list with a capacity of arrayCapacity
   public ArrayList() {
	      arrayData = new ArrayNode[arrayCapacity];
	      listSize = 0;
} //ArrayList
   
   public ArrayList(int arrayCapacity) {
   arrayData = new ArrayNode[arrayCapacity];
   listSize = 0;
} //ArrayList
      
   public int listSize() {
	   return listSize;
	} //listSize

   public ArrayNode getNode(int pos) {	   
	   return arrayData[pos];
   } // getNode
 
   public boolean isEmpty() {
		 return listSize()==0;
	 }
	 
   public void append(ArrayNode newNode) {
	   // Resize if the array is full
	   if (arrayData.length == listSize) {
	      resize(listSize * 2);
	   }

	   // Insert the new item at index listSize
	   arrayData[listSize] = newNode;

	   // Increment the array's length and update tail position
	   listSize++;
//	   System.out.println("Appended value "+newNode.getData()+ " at position "+ (listSize-1));
	}
	   
   public void prepend(ArrayNode newNode) {

		   // Resize if the array is full
		   if (arrayData.length == listSize) {
		      resize(listSize * 2);
		   }

		   // Shift all array items to the right,
		   // starting from the last index and moving 
		   // down to the first index
		   for (int i = listSize; i > 0; i--) {
		      arrayData[i] = arrayData[i - 1];
		   }

		   // Insert the new item at index 0
		   arrayData[0] = newNode;
		   // Update the array list's length
		   listSize++;
//		   System.out.println("Prepended value "+newNode.getData());		        
	}//prepend

   public void insertAfter(int pos, ArrayNode newNode) {
		   // Resize if the array is full
		   if (arrayData.length == listSize) {
		      resize(listSize * 2);
		   }
		   // Shift all the array items to the right,
		   // starting from the last item and moving down to
		   // the item just past the given index
		   for (int i = listSize; i > pos + 1; i--) {
		      arrayData[i] = arrayData[i - 1];
		   }
		   // Insert the new item at the index just past the
		   // given index
		   arrayData[pos+1] = newNode;
		   // Update the array's length
	   listSize++;
//	   System.out.println("Inserted value "+newNode.getData()+ " after position "+ pos);		        
	} //insertAfter;

   public void removeAt(int pos) {
	   if (listSize !=  0 && pos == (listSize-1)) {
	      // Special case: remove last element
	   }
	   else{
	      for(int i = pos; i < (listSize - 1); i++) {
	    	 arrayData[i]=arrayData[i+1];
	      } //for
	   } //else
	   listSize--;
//	   System.out.println("Removed element at position "+ pos);
	} // removeAt

   public int search(int dataItem) {
	  if (listSize == 0) {//no need to search an empty list;
		   return -1;
	  }
	  else { // for now do linear search
	  int pos = 0;
	  boolean searching = true;
	  for (pos = 0; pos < listSize; pos++) {
		  if (arrayData[pos].getData() == dataItem) {
			  return pos;
		  }
	  }//for
	  return -1;  // if get to here, dataItem is not in the list
	}//else
   } // search
   
   public void displayNode(int pos) {
	   ArrayNode nodeAtPos;
	   nodeAtPos = arrayData[pos];
	   System.out.print(nodeAtPos.getData()+" ");
		  			   
   }
     public void displayList() {
	  ArrayNode currNode;
	  if (listSize > 0) {
	  for (int i = 0; i < listSize; i++) {
		  displayNode(i);
	   }
	  System.out.println();//for
	  }//if
	  else {
		   System.out.println("List is empty");			   
	  }
	} //displayList
} //ArrayList
