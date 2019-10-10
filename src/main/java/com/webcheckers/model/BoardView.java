package com.webcheckers.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author: Mason Zhong
 */

public class BoardView implements Iterator {

    private Row rows[];
    private int currentRow = 0;

    public BoardView(){
    }

    public Iterator<Row> iterator() {
        return null;
    }


    @Override
    public boolean hasNext() {
        return currentRow < rows.length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return rows[currentRow++];
    }
}
