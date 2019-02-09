package com.liao.list;


public class BothwayLinkedList {
	public BothwayLinkedList(){
		listSize=0;
		headNode=null;
		tailNode=null;
	}
	
	private class Node{
		private Object data;
		private Node next;
		public Node(Object data){
			this.data=data;
		}
		@Override
		public String toString() {
			return "Node [data=" + data +"]";
		}
		
	}
	
	private int listSize;
	private Node headNode;
	private Node tailNode;
	
	public boolean deleteHead(){
		if(listSize<=0){
			return false;
		}
		if(headNode.next==null){
			headNode=null;
			tailNode=null;			
		}
		else{
			headNode=headNode.next;
		}		
		listSize--;
		return true;
	}
	
	public void addHead(Object object){
		Node node=new Node(object);
		if(listSize==0){
			headNode=node;
			tailNode=node;
		}
		else{
			node.next=headNode;
			headNode=node;
		}		
		listSize++;
	}
	public void addTail(Object object){
		Node node=new Node(object);
		if(listSize==0){
			headNode=node;
			tailNode=node;
		}
		else{
			tailNode.next=node;
			tailNode=node;
		}		
		listSize++;
	}
	
	public Node findNodeFromHead(Object object){
		Node current=headNode;
		int tempSize=listSize;
		while(tempSize>0){
			if(object.equals(current.data)){
				return current;
			}
			else{
				current=current.next;
			}
			tempSize--;
		}
		return null;
	}
	
	
	public boolean deleteNode(Object object){
		if(listSize<=0){
			return false;
		}
		Node current=headNode;
		Node previous=headNode;
		while(!current.data.equals(object)){
			if(current.next==null){
				return false;
			}
			previous=current;
			current=current.next;
		}
		if(current==headNode){
			headNode=current.next;
		}
		else{
			previous.next=current.next;
		}	
		listSize--;
		return true;
	}
	
	
	public void display() {
		if (listSize > 0) {
			Node node = headNode;
			int tempSize = listSize;
			if (tempSize == 1) {// 当前链表只有一个节点
				System.out.println("[" + node.data + "]");
				return;
			}
			while (tempSize > 0) {
				if (node.equals(listSize)) {
					System.out.print("[" + node.data + "->");
				} else if (node.next == null) {
					System.out.print(node.data + "]");
				} else {
					System.out.print(node.data + "->");
				}
				node = node.next;
				tempSize--;
			}
			System.out.println();
		} else {// 如果链表一个节点都没有，直接打印[]
			System.out.println("[]");
		}

	}
}
