package com.webcheckers.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author: Mason Zhong
 */

public class BoardView {

    private Row[] rows;
    private int currentRow = 0;

    public BoardView(){
        rows = new Row[8];
        int i = 0;
        for (Row r: rows) {
            rows[i] = new Row(i);
            i++;
        }
    }

    public Iterator<Row> iterator() {
        return null;
    }

}
