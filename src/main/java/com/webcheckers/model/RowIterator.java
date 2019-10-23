package com.webcheckers.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator class for Rows
 */
public class RowIterator implements Iterator<Row> {
    private Row rows[];
    private int currentRow = 0;

    /**
     * Creates row iterator
     * @param rows that will be iterated through
     */
    public RowIterator(Row rows[]){
        this.rows = rows;
    }

    /**
     * hasNext method for rows
     * @return true if there is a next row in the iterator, false otherwise
     */
    @Override
    public boolean hasNext() {
        return currentRow < rows.length;
    }

    /**
     * Returns the next row if there is one
     * @return next row
     */
    @Override
    public Row next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return rows[currentRow++];
    }
}
