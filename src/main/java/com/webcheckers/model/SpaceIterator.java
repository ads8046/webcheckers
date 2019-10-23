package com.webcheckers.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator class for Spaces
 */
public class SpaceIterator implements Iterator<Space>{
    private Space spaces[];
    private int currentSpace = 0;

    /**
     * Creates space iterator
     * @param spaces that will be iterated through
     */
    public SpaceIterator(Space spaces[]){
        this.spaces = spaces;
    }

    /**
     * hasNext method for spaces
     * @return true if there is next space, false otherwise
     */
    @Override
    public boolean hasNext() {
        return currentSpace < spaces.length;
    }

    /**
     * Returns the next space in the row if there is one
     * @return next space
     */
    @Override
    public Space next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return spaces[currentSpace++];
    }
}
