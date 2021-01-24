/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IteratorDesignPattern;

import java.util.Iterator;

/**
 *
 * @author adameinstein
 */
public class ToDoIterator implements Iterator {
    /**
     * Corresponding attributes for ToDoIterator
     */
    private final ToDo[] todos;
    private int position = 0;
    /**
     * Constructor
     * @param todos 
     */
    public ToDoIterator(ToDo[] todos) {
        this.todos = todos;
    }
    /**
     * @return false if position is less than length
     * and if position is not null
     * otherwise return true
     */
    @Override
    public boolean hasNext() {
        return !(position >= todos.length || todos[position] == null);
    }
    /**
     * @return the next ToDo, if there is one, and null otherwise
     */
    @Override
    public ToDo next() {
		ToDo toDo = todos[position];
		position = position + 1;
		return toDo;
    }
}
