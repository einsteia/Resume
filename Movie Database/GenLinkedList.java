//
//Written by Adam Einstein
//
  
 public class GenLinkedList<T> { 
 
// Overall creation of node and its parameters 
     @SuppressWarnings("hiding") 
  private class ListNode<T> 
     { 
         private T data; 
         private ListNode<T> link;       
     }   
     
// Starting node 
     private ListNode<T> head; 
     
// Creates current 
     private ListNode<T> previous; 
     
// Previous node 
     private ListNode<T> current; 
     
// default constructors 
     public GenLinkedList() 
     { 
         head = null; 
         previous = null; 
         current = null; 
     }  
     
// Adds new item 
     public void addItem(T item) 
     { 
         ListNode<T> newNode = new ListNode<T>(); 
         newNode.data = item; 
         newNode.link = null; 
         
         if(head == null) 
         { 
             head = newNode; 
             previous = null; 
             current = head; 
         } 
         else 
         { 
             previous = current; 
             current.link = newNode;   
             current = newNode; 
             previous.link = current; 
         } 
     }    
     
// Removes an item 
     public void removeItem() 
     { 
         if(current == null) 
             return; 
         
         if(previous == null) 
         { 
                head = current.link; 
                current = head; 
         } 
         else 
         { 
             previous.link = current.link; 
             current = current.link; 
         }       
     }  
     
// Returns current 
     public T getCurrent() 
     { 
         if(current == null) 
             return null; 
         else 
             return current.data; 
     }  
     
// Moves current forward 
     public void moveForward() 
     { 
         if(current == null || current.link == null) 
         { 
             return; 
         } 
         else 
         { 
             previous = current; 
             current = current.link; 
         } 
     }  
     
// Moves the current backwards 
     public void moveBackward() 
     { 
         if(previous == null || current == null) 
         { 
             return; 
         } 
         else 
         { 
             current = previous; 
             
             ListNode<T> tempNode = head; 
             while(tempNode != null && tempNode.link != previous) 
             { 
                 tempNode = tempNode.link; 
             } 
             
             previous = tempNode;           
         } 
     }  
     
// Moves to head node 
     public void moveToHead() 
     { 
         previous = null; 
         current = head; 
     }  
     
// Prints list starting from head node 
     public void printList() 
     { 
         ListNode<T> tempNode = head; 
         while(tempNode != null) 
         { 
             System.out.println(tempNode.data); 
             tempNode = tempNode.link; 
         }       
     }  
     
// Returns movie allocation 
     public int getSize() 
     { 
         int count = 0; 
         
         ListNode<T> tempNode = head; 
         while(tempNode != null) 
         { 
             count++; 
             tempNode = tempNode.link; 
         }       
         
         return count; 
     }  
 } 
  
