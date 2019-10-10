package com.webcheckers.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Author: Atharva Shivankar (ads8046@rit.edu)
 */
public class RowIterator implements Iterator<Row> {
    private Row rows[];
    private int currentRow = 0;

    public RowIterator(Row rows[]){
        this.rows = rows;
    }

    @Override
    public boolean hasNext() {
        return currentRow < rows.length;
    }

    @Override
    public Row next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return rows[currentRow++];
    }
}
