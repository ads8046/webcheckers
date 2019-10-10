package com.webcheckers.model;

import java.util.Iterator;

/**
 *
 * @author: Mason Zhong
 */

public class Row implements Iterable {

    private int index;
    private int currentSpace = 0;
    private Space spaces[];

    public Row(int index, Space spaces[]) {
        this.index = index;
        this.spaces = spaces;
    }


    public int getIndex() {
        return this.index;
    }

    public Iterator<Space> iterator() {
        return new SpaceIterator(this.spaces);
    }

}