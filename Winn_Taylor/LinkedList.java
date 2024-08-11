/*
 Taylor Winn
 Assignment 3
 July 2024
 */

package assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LinkedList {
    
    private Node head;  // creating the first node of the linked list 

    public LinkedList(){
        this.head = null;   // constructor for the linked list using the head as the first node
    }

    public void add(int num){   // method to add nodes to our linked list using an int value as it's only argument
        Node node = new Node(num);  // initializing the node
        if(head == null){   // making the node the first in the list if it is empty
            head = node;
        } else {
            Node temp = head;   // temporary variable to traverse list
            while(temp.getNextNode() != null){
                temp = temp.getNextNode();  // getting the last node in the list
            }
            temp.setNextNode(node); // setting the node as the next node to the last current list node
        }
    }

    public void populateList(String file) throws IOException {  // method to read in the data and populate the linked list
        BufferedReader buffer = new BufferedReader(new FileReader(file));   // creating line buffer for file
        String currentLine;
        while ((currentLine = buffer.readLine()) != null) { // executes until the file has been scanned
            String[] data = currentLine.split(" "); // spliting the data based on a space (the vals are seperated by a single space)
            for (String d : data) { 
                int num = Integer.parseInt(d); 
                if (num > 0) {
                    add(num);   // only adding a new node to the list if the value within is greater than 0
                }
            }
        }
        buffer.close(); 
    }
    

    public void writeFile(String file) throws IOException { // method to write our output file

        FileWriter writeFile= new FileWriter(file);
        Node temp = head;   // another temp variable to traverse our final list
        while(temp != null){    
            writeFile.write(temp.getNum() + " ");   // writing the data within each node in the output file as string format
            temp = temp.getNextNode();
        }
        writeFile.close();
    }

    public void shrinkList(){   // method to shrink the list based on given paramenters
        int count = -100;
        Node temp = head;
        Node prev = null;
        boolean lastValCount = false;   // to track if the last node will be a count variable or not

        while ((temp != null) && temp.getNextNode() != null) {
            Node nextNode = temp.getNextNode(); // getting the x[i] value
            int val = (temp.getNum() * 2) + 7;  // checking is x[i] = x[i-1]*2 + 7
            if (nextNode.getNum() == val) {
                lastValCount = true;    // the most recent node appended will be a count val
                if (prev == null) { // if the head of the list is being replaced
                    head = nextNode.getNextNode(); 
                } else {
                    prev.setNextNode(nextNode.getNextNode());   
                }
                Node node = new Node(count);    // creating the new node with the current count value as it's data
                count++;    // incrementing count AFTER creating the new node
                if (prev == null) { // if the head node was deleted, the count node become the new head
                    node.setNextNode(head);
                    head = node;
                } else {
                    node.setNextNode(prev.getNextNode());   // setting the node after the new count node 
                    prev.setNextNode(node); 
                }
                prev = node;    // accounting for the replaced nodes by making the count node the prev node
                temp = node.getNextNode();  // continuing through the list
            } else {
                prev = temp;    // if the condition was not met, no need to change anything, just progress through the list
                temp = temp.getNextNode();
                lastValCount = false;   // setting the last count value to false indicating the last node was NOT a count value adn therefore if it was the last we need to add another count node
            }
        }

        if (!lastValCount || (temp != null)) {
            add(count); // if the last node in the new list is not a count value, we need to add a node with the count value to the end of the list
        }
    }
}

    
    
