/*
 Taylor Winn
 Assignment 3
 July 2024
 */

package assignment3;

import java.io.IOException;

public class LinkedListTester {

    public static void main(String[] args) throws IOException{  // adding the IO condition for if the file is corrupt of cannot be found
        LinkedList linkedList = new LinkedList();   // initializing the linked list 

        String input = "data.txt";  // name of input file
        String output = "processed.txt";    // name of output file

        linkedList.populateList(input); // reading the input file and populating the linked list

        linkedList.shrinkList();    // checking conditions to shrink the list if needed

        linkedList.writeFile(output);   // writing the new list to the output file
    }

}