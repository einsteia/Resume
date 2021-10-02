/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IteratorDesignPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author adameinstein
 */
public class ContractorToDoList {
    /**
     * Corresponding attributes for ContractorToDoList
     */
    private final String address;
    private ToDo[] todos;
    private int count;
    /**
     * Constructor
     * @param address 
     */
    public ContractorToDoList(String address) {
        todos = new ToDo[2];
        createIterator();
        this.address = address;
        count = 0;
    }
    /**
     * Accepts the title, description, price,
     * contact, and list of supplies
     * @param title
     * @param description
     * @param price
     * @param contact
     * @param supplies 
     */
    public void addToDo(String title, String description, double price, String contact, ArrayList<String> supplies) {
         ToDo todo = new ToDo(title, description, price, contact, supplies);

        if (todos.length == count) {
            todos = growAway(todos);
        }
        todos[count] = todo;
        count++;
    }
    /**
     * @return new ToDoIterator
     */
    public ToDoIterator createIterator() {
        return new ToDoIterator(this.todos);
    }
    /**
     * @return address of contractor
     */
    public String getAddress() {
        return this.address;
    }
    /**
     * @return the total price of 
     * completing all the todo items in the list
     */
    public double getTotalCost() {
        double total = 0.0;
        for(ToDo t : todos) {
            if(t != null) {
                total += t.getPrice();
            }
        }
        return total;
    }
    /**
     * @param toDos
     * @return an array of twice the size with the same data
     */
    private ToDo[] growAway(ToDo[] toDos) {
        todos = Arrays.copyOf(todos, count * 2);
        return todos;
        }   
}
