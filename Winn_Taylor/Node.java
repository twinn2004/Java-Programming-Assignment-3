/*
 Taylor Winn
 Assignment 3
 July 2024
 */

package assignment3;

public class Node {

    private int num;    // data
    private Node next;  // next after current

    public Node(int data){  // no argument constructor acting as malloc
        this.num = data;
        this.next = null;
    }

    public int getNum(){    // getter method to return the value within called node
        return this.num;
    }

    public Node getNextNode(){  // getter method to return the next node after called
        return this.next;
    }

    public void setNextNode(Node node){ // setter method to set the next node after current (defaults to null)
        this.next = node;
    }

}