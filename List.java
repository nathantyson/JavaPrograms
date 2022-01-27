//List.java
//George J. Pothering

class Node extends DLLNode{
	
 public Node(int initialData) {
    super(initialData);
 } //Node
 
 public int getData() {
	return super.getData();
 } //getData
}//Node


public class List extends DoublyLinkedList{
 public List() {
	  super(); 
 } //List
 
 public int listSize() {
	   return super.listSize();
 } //listSize

 public Node getNode(int pos) {	   
	   return (Node) super.getNode(pos);
 } // getNode

 public boolean isEmpty() {
	 return super.isEmpty();
 }
 
 public void append(Node newNode) {
	 super.append(newNode);
 } //append
	   
 public void prepend(Node newNode) {
	 super.prepend(newNode);
 }//prepend

 public void insertAfter(int pos, Node newNode) {
		 super.insertAfter(pos, newNode);		        
 } //insertAfter

 public void removeAt(int pos) {
	 super.removeAt(pos);
 } // removeAt

 public int search(int dataItem) {
	 return super.search(dataItem);
 } // search
 
 public void displayNode(int pos) {
	 super.displayNode(pos);		  			   
 }
   public void displayList() {
	   super.displayList();
	} //displayList
} //List
