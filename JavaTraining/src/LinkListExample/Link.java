/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LinkListExample;

import java.util.List;

/**
 *
 * @author rzimmerman
 */
public class Link {
    public String bookName;
    public int millionsSold;
    
    // reference the name of the linklist next
    public Link next;
    
    // constructor
    public Link(String bookName, int millionsSold) {
        this.bookName = bookName;
        this.millionsSold = millionsSold;
    }
   
    // display
    public void display() {
        System.out.println(bookName+ " : "+ millionsSold + ",000,000");
    }
    
    //set a toString
    public String toString() {
        return bookName;
    }
    
    // main method
    public static void main(String[] args) {
        
        // execution
        LinkList theLinkedList = new LinkList();
        
        theLinkedList.insertFirstLink("Don Quixote", 20);
        theLinkedList.insertFirstLink("Harry Potter", 440);
        theLinkedList.insertFirstLink("Bugs Bunny", 100);
        theLinkedList.insertFirstLink("Lord Of the Rings", 200);
        theLinkedList.insertFirstLink("Hot Man", 540);
        theLinkedList.insertFirstLink("John Man", 300);
        
        
    }
    
}

// link list method
class LinkList {
    
    // ref to the first link of the list
    public Link firstLink;
    
    // constructor
    LinkList() {
        firstLink = null; // we should always know that the "last" to enter is null
    }
    
    public boolean isEmpty() {
        return(firstLink == null);
    }
    // inserting 
    public void insertFirstLink(String bookName, int millionsSold) {
        Link newLink = new Link(bookName, millionsSold);
        
        newLink.next = firstLink;
        
        firstLink = newLink;
        
    }
    // removal
    public Link removeFirst(){
        Link linkReference = firstLink;
        if (!isEmpty()) {
            firstLink = firstLink.next;
        } else {
            System.out.println("Empty Linklist");
        }
        
        return linkReference;
    }
    
    public Link find(String bookName) {
        
        Link theLink = firstLink;
        
        if (!isEmpty()) {
            
            while(theLink.bookName != bookName) {
                if (theLink.next == null) {
                    // end of the list 
                    return null;
                } else {
                    theLink = theLink.next; // go to next one
                }
            }
            
            
        } else {
            System.out.println("Empty List");
        }
        return theLink; // return object that has the bookName
    }
    
    // remove an item in link list
    public Link removeLink(String bookName) {
        
        Link currentLink = firstLink;
        Link previousLink = firstLink;
        
        while(currentLink.bookName != bookName) {
            
            if (currentLink.next == null ) {
                return null;
            }
            else {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        
        if (currentLink == firstLink) {
            firstLink = firstLink.next;
        } else {
            previousLink.next = currentLink.next;
        }
        
        return currentLink.next;
    }
    
    public void display() {
        Link theLink = firstLink;
        
        while(theLink != null) {            
            theLink.display();
            
            // print the next value that came after next
            System.out.println("Next Link: " + theLink.next);
            
            theLink = theLink.next; 
            
            System.out.println();
        }
    }
}