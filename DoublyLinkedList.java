//DoublyLinkedList.java
//George J. Pothering

class DLLNode {
	protected int data;
		   protected DLLNode previous;
		   protected DLLNode next;
		    
		   public DLLNode(int initialData) {
		      data = initialData;
		      next = null;
		      previous = null;
		   }
			public int getData() {
				return data;
			}
		} //DLLNode

public class DoublyLinkedList {
	   protected DLLNode head;
	   protected DLLNode tail;
	   protected int listSize;
	   
 
	   public DoublyLinkedList() {
	      head = null;
	      tail = null;
	      listSize = 0;
	   }

	   public int listSize() {
		   return listSize;
		} //listSize

	   public DLLNode getNode(int pos) {
		   int currPos = 0;
		   DLLNode currNode = head;
		   while (currPos < pos) {
			  currNode=currNode.next;
			  currPos++;
		   }
//		   System.out.println("getNode will return node with value: "+ currNode.getData());
		   return currNode;
	   } // getNode
	      
	   public boolean isEmpty() {
			 return listSize()==0;
		 } //isEmpty
		 
	   public void append(DLLNode newNode) {
			   if (head == null) {
				      head = newNode;
				      tail = newNode;
				   }
				   else {
				      tail.next = newNode;
				      newNode.previous = tail;
				      tail = newNode;
				   }
			   listSize++;
		} //append

	   public void prepend(DLLNode newNode) {
		   if (head == null) {
			      head = newNode;
			      tail = newNode;
			   }
			   else {
				  DLLNode oldHead = head;
//				  System.out.println("Value of oldHead is "+oldHead.getData());
			      newNode.next = oldHead;
			      head = newNode;
			   }
		   listSize++;
		}//prepend

	   public void insertAfter(int pos, DLLNode newNode) {
		   DLLNode successor;
		   DLLNode nodeAtPos = getNode(pos); 
//		   System.out.println("Node at position "+ pos + " has value " + nodeAtPos.getData());
		   if (head == null) {
			      head = newNode;
			      tail = newNode;
			   }
			   else if (nodeAtPos == tail) {
			      tail.next = newNode;
			      newNode.previous = tail;
			      tail = newNode;
			   }
			   else {			     
		   		  successor = nodeAtPos.next;
//		   		  System.out.println("Successor has value " + successor.getData());
			      newNode.next = successor;
			      newNode.previous = nodeAtPos;
			      nodeAtPos.next = newNode;
			      successor.previous = newNode;
			  }
		   listSize++;
		} //insertAfter;

	   public void removeAt(int pos) {
		   DLLNode nodeAtPos = getNode(pos);
		   DLLNode succeedingNode;
		   DLLNode precedingNode;
		   listSize--;
		   if (pos == 0 && head != null) {
		      // Special case: remove head
		      succeedingNode = head.next;
		      succeedingNode.previous = null;
		      head = succeedingNode;
		      if (succeedingNode == null) {  //head node was the only node
		          // Last item was removed
		          tail = null;
		      }
		   }
		   else if (nodeAtPos.next != null) { //not at tail node
//			      succeedingNode = nodeAtPos.next.next;
			  succeedingNode = nodeAtPos.next;
		      precedingNode = nodeAtPos.previous;
			  precedingNode.next = succeedingNode;
			  succeedingNode.previous = precedingNode;
		      
		      if (succeedingNode == null) {
		         // Remove tail
		         tail = nodeAtPos.previous;
		      }
		   }
		} // removeAfter
	   
	   public int search(int dataItem) {
		   int pos = -1;
		   int endPos = listSize - 1;
		   boolean searching;
		   if (head == null) 
			   return -1;//no need to search an empty list;
		   else {
		     DLLNode currNode = head;
		     pos = 0;
		     searching = (pos <= endPos); 
		     while (searching) {
		      if (currNode.data == dataItem) {
		         return pos;
		      }
		      else {
		    	  pos++;
		          currNode = currNode.next;
		          searching = (pos <= endPos);
		      } // else
		    } //while
		   }//else
		   return -1;
		} //search
	   
	   public void displayList() {
		   DLLNode currNode = head; 
		   for (int pos = 0; pos <= listSize -1; pos++) {			   
			  System.out.print(currNode.getData() + " ");
			  currNode = currNode.next;
		   } //while
		   System.out.println();			   
		} //displayList
	   
	   public void displayNode(int pos) {
		   DLLNode nodeAtPos;
		   nodeAtPos = getNode(pos);
		   System.out.print(nodeAtPos.data);			  			   
	   }//displayNode
} //DoublyLinkedList
