//LinkedList.java
//George J. Pothering

class LLNode {
		   public int data;
		   public LLNode next;
		    
		   public LLNode(int initialData) {
		      data = initialData;
		      next = null;
		   }
			public int getData() {
				return data;
			}
		} //LLNode


public class LinkedList {	
		   protected LLNode head;
		   protected LLNode tail;
		   protected int listSize;
		   	    
		   public LinkedList() {
		      head = null;
		      tail = null;
		      listSize = 0;
		   }

		   public int listSize() {
			   return listSize;
			} //listSize

		   public LLNode getNode(int pos) {
			   int currPos = 0;
			   LLNode currNode = head;
			   
			   while (currPos < pos) {
				  currNode=currNode.next;
				  currPos++;
			   }
			   return currNode;
		   } // getNode
		   
		   public boolean isEmpty() {
				 return listSize()==0;
			 } //isEmpty
		   
		   public void append(LLNode newNode) {
			   if (head == null) {
			      head = newNode;
			      tail = newNode;
			   }
			   else {
			      tail.next = newNode;
			      tail = newNode;
			   }
			   listSize++;
			} //append

		   public void prepend(LLNode newNode) {
			   if (head == null) {
			      head = newNode;
			      tail = newNode;
			   }
			   else {
			      newNode.next = head;
			      head = newNode;
			   }
			   listSize++;
			}//prepend

		   public void insertAfter(int pos, LLNode newNode) {
			   LLNode nodeAtPos = getNode(pos);
			   if (head == null) {
			      head = newNode;
			      tail = newNode;
			   }
			   else if (nodeAtPos == tail) {
			      tail.next = newNode;
			      tail = newNode;
			   }
			   else {
			   
			      newNode.next = nodeAtPos.next;
			      nodeAtPos.next = newNode;
			   }
			   listSize++;
			} //insertAfter;

		   public void removeAt(int pos) {
			   LLNode nodeAtPos = getNode(pos);
			   LLNode succeedingNode, precedingNode;
			   listSize--;
			   if (pos == 0 && head != null) {
			      // Special case: remove head
			      succeedingNode = head.next;
			      head = succeedingNode;
			      if (succeedingNode == null) {
			          // Last item was removed
			          tail = null;
			      }
			   }
			   else if (nodeAtPos.next != null) { // not at tail node
			      succeedingNode = nodeAtPos.next;
				  precedingNode = getNode(pos-1);
				  precedingNode.next = succeedingNode;
			      if (succeedingNode == null) {
			         // Remove tail
			         tail = nodeAtPos;
			      }
			   }
			} // removeAt
/*
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
*/
		   
		   public int search(int dataItem) {
			   int pos;
			   int endPos = listSize - 1;
			   boolean searching;
			   if (head == null) 
				   return -1;//no need to search an empty list;
			   else {
			     LLNode currNode = head;
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
			}
		   
		   public void displayList() {
			   LLNode currNode = head; 
			   for (int pos = 0; pos <= listSize -1; pos++) {			   
				  System.out.print(currNode.getData() + " ");
				  currNode = currNode.next;
			   } //while
			   System.out.println();			   
			} //displayList

		   public void displayNode(int pos) {
			   LLNode nodeAtPos;
			   nodeAtPos = getNode(pos);
			   System.out.println(nodeAtPos.data);				  			   
		   }		   
}// class LinkedList	  