package com.webcheckers.model;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author: Mason Zhong
 */

public class Row implements Iterator {

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

    public Iterator<Space> spaceIterator() {
        return null;

    }

    @Override
    public boolean hasNext() {
        return currentSpace < spaces.length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return spaces[currentSpace++];
    }
}