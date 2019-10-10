package com.webcheckers.model;

import java.util.Iterator;

/**
 *
 * @author: Mason Zhong
 */

public class Row {

    private int index;
    private Space space[];

    public Row(int index, Space space[]) {
        this.index = index;
        this.space = space;
    }


    public int getIndex() {
        return this.index;
    }

    public Iterator<Space> iterator() {
        return null;

    }
}