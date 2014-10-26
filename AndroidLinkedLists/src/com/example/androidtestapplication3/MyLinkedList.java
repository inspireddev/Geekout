package com.example.androidtestapplication3;

public class MyLinkedList {
	private Node head;
	private int count;
	

	// Constructor for my Linked List (BUGBUG - constructors should never have return types)
	public MyLinkedList(){
		head = new Node(null);		// build a head with value = null and next = null. This head is never used to return values.
		count = 0;
	}
	
	// Adds a new node to the end of the linked list with value ObjValue
	public void add(Object ObjValue){
		Node newNode = new Node(ObjValue); 
		
		// build a pointer to the head of the node for traversal from head to end
		Node currentNode = head;
		
		// Starting traversing the list
		while (currentNode.getNext() != null){
			currentNode = currentNode.getNext();
		}
		
		// Now that you are at the end node, set the last nodes next pointer to your new node
		currentNode.setNext(newNode);
		count++;
	}
	
	// Adds a new node to a specific location in the linked list
	public void add(Object ObjValue, int index){
		Node newNode = new Node(ObjValue);
		int i=0;					// counter for node
		
		// build a pointer to the head of the list for traversal from head to index
		Node currentNode = head;
		
		// Find node and set the current node to point to it. 
		while (currentNode.getNext() != null && i < index){
			currentNode = currentNode.getNext();
		}
		
		// Now to insert, set the new Nodes next pointer to the current's next pointer
		newNode.setNext(currentNode.getNext());
		
		// Now connect the current node's next to this new Node
		currentNode.setNext(newNode);
		count++;
	}
	
	// Gets the objValue at the specified index
	public Object Get(int index){
		int i = 0;
		
		// check if index is valid
		if (index < 1)
			return null;
		
		Node currentNode = head;
		
		while (i < index && currentNode.getNext() != null){
			currentNode = currentNode.getNext();
			i++;
		}
		
		if (currentNode.getNext() == null)
			return null;
		
		return currentNode.getNodeValue();
	} 
	
	// Remove Node at specified location (PRETTY SURE THIS DOESN"T WORK SINCE YOU SHOULD DO GETNEXT.GETNEXT on the previous pointer not current)
	public boolean Remove(int index){

		// if it's one, you can't remove that node
		if (index < 1 || index > size())  
			return false;
		
		Node currentNode = head;
		int i = 1;
		
		while (i < index && currentNode.getNext() != null){
			currentNode = currentNode.getNext();
			i++;
		}
		
		if (currentNode.getNext() == null || currentNode.getNext().getNext() == null)
			return false;
		
		currentNode.setNext(currentNode.getNext().getNext());
		count--;
		
		return true;
	}
	
	// Return the size of the linked list
	public int size(){
		return count;
	}
	
	// toString override
	public String toString(){
		Node currentNode = head.getNext();
		String output = "";
		
		while (currentNode!=null){
			output = output + "[" + currentNode.getNodeValue().toString() + "]"; 
			currentNode = currentNode.getNext();		
		}
		return output;
	}
	
	
	// class for an individual node
	private class Node
	{
		Object nodeValue;			// node value
		Node next;					// pointer to next node
		
		// constructor that sets value but not next Node
		public Node(Object obj)
		{
			nodeValue = obj;		// when building a new node, assign it a value
			next = null;			// new nodes are not connected at start
		}
		
		// alternative constructor that sets value and next node
		public Node(Object obj, Node nextNode)
		{
			nodeValue = obj;		// when building a new node, assign it a value
			next = nextNode;		// and set the pointer to next node
		}
		
		// Now doing the equivalent of GET SET in c#.
		// Why do this? Because, without this, you cannot pass by reference (apparently)
		public Object getNodeValue(){
			return nodeValue;
		}
		
		public void setNodeValue(Object obj){
			nodeValue = obj;
		}
		
		public Node getNext(){
			return next;
		}
		
		public void setNext(Node nextNode){
			next = nextNode;
		}
		
	}
	
	
}
