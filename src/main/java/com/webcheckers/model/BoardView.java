package com.webcheckers.model;

import java.util.Iterator;

/**
 * Class for checkers board
 */

public class BoardView {

    private Row[] rows;

    /**
     * Creates checkers board and populates it with rows and spaces
     */
    public BoardView(){
        rows = new Row[8];
        int i = 0;
        for (Row r: rows) {
            rows[i] = new Row(i);
            i++;
        }
    }

    /**
     * Creates and returns an iterator that iterates through the rows in the board
     * @return an iterator that iterates through the rows
     */
    public Iterator<Row> iterator() {
        return new RowIterator(rows);
    }

}
